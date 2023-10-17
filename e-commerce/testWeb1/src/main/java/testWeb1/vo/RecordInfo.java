package testWeb1.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//record information class
public class RecordInfo{
	private int id;
	private float time;
	private int treasure_num;
	private int robot_id;
	private List<String> imagePaths;

    public RecordInfo(int id, int time, int treasure_num, int robot_id, List<String> imagePaths) {
        this.id = id;
        this.time = time;
        this.treasure_num = treasure_num;
        this.robot_id = robot_id;
        this.imagePaths = imagePaths;
	}


	public RecordInfo() {
		// TODO Auto-generated constructor stub
	}


	public List<String> getImagePaths() {
		return imagePaths;
	}


	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}


	public int getId() {
		return id;
	}
	public void setId(int record_id) {
		this.id = record_id;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float string) {
		this.time = string;
	}
	public int getTreasure_num() {
		return treasure_num;
	}
	public void setTreasure_num(int treasure_num) {
		this.treasure_num = treasure_num;
	}
	public int getRobot_id() {
		return robot_id;
	}
	public void setRobot_id(int robot_id) {
		this.robot_id = robot_id;
	}

	public void addImagePath(String imagePath) {
        if (imagePaths == null) {
            imagePaths = new ArrayList<>();
        }
        imagePaths.add(imagePath);
    }

}