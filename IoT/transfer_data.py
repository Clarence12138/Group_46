import time
from ultralytics import YOLO
import cv2
import torch
import os
import requests
import pymysql


def insert_db(insert_sql):
    """插入"""
    # 建立数据库连接
    db = pymysql.connect(
        host="localhost",
        port=3306,
        user="root",
        passwd="111111",
        db="javawebdb"  # rec
    )
    # 通过 cursor() 创建游标对象
    cur = db.cursor()
    try:
        # 使用 execute() 执行sql
        cur.execute(insert_sql)
        # 提交事务
        db.commit()
    except Exception as e:
        print("操作出现错误：{}".format(e))
        # 回滚所有更改
        db.rollback()
    finally:
        # 关闭游标
        cur.close()
        # 关闭数据库连接
        db.close()


def getid_and_increment():
    filename = 'record.txt'
    if not os.path.exists(filename):
        with open(filename, 'w') as f:
            f.write('0')

    with open(filename) as f:
        count = int(f.read())

    with open(filename, 'w') as f:
        f.write(str(count + 1))

    return count


def add_time(recordid, timegap):
    timegap = "\'" + str(timegap)+ "\'"
    sql = 'INSERT INTO record (record_id, time, treasure_num, robot_id) VALUES (' + str(recordid) + ', ' + timegap + ', 1, 1)'
    print(sql)
    insert_db(sql)


def add_img(recordid, img):
    sql = 'INSERT INTO image_paths(record_id, path) VALUES(' + str(recordid) + ', ' + img + ')'
    print(sql)
    insert_db(sql)

if __name__ == "__main__":
    # Load a model
    model = YOLO("best.pt")  # load a pretrained model (recommended for training)

    # predict video
    cap = cv2.VideoCapture('rtsp://admin:admin@192.168.137.176:554')

    idx = 0
    record_id = getid_and_increment()
    start = time.time()
    # Loop through the video frames
    while cap.isOpened():
        # Read a frame from the video
        success, frame = cap.read()

        if success:
            results = model(frame)
            annotated_frame = results[0].plot()

            frame_tmp = torch.tensor(frame, dtype=torch.float64, requires_grad=False)  # frame tmp是frame的复制，数据值一致
            annotated_frame_tmp = torch.tensor(annotated_frame, dtype=torch.float64,
                                               requires_grad=False)  # anno frame tmp是anno frame的复制，数据值一致
            save_dir = 'upload'  # dir to save img
            os.makedirs(save_dir, exist_ok=True)
            if False in (frame_tmp == annotated_frame_tmp):
                if idx % 10 == 0:
                    cv2.imwrite(save_dir + '/' + str(record_id) + '_detect_%d.png' % idx, annotated_frame)
                    path = "\'"+str(record_id) + '_detect_' + str(idx)+'.png'+"\'"
                    add_img(recordid=record_id, img=path)
                idx += 1
            del frame_tmp, annotated_frame_tmp
            cv2.imshow("YOLOv8 Inference", annotated_frame)  # 用于打开窗口播放检测的帧，即annotated_frame

            # Break the loop if 'q' is pressed
            if cv2.waitKey(1) & 0xFF == ord("q"):
                end = time.time()
                time_gap = round(end - start, 2)
                add_time(recordid=record_id, timegap=time_gap)
                break
        else:
            # Break the loop if the end of the video is reached
            break

    cap.release()
    cv2.destroyAllWindows()
