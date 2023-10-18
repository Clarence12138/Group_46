- [Telecom](#telecom)
  - [Introduction](#introduction)
  - [Features](#features)
  - [System Architecture](#system-architecture)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
  - [Deployment](#deployment)
    - [Setting up the Arduino Mega 2560](#setting-up-the-arduino-mega-2560)
    - [Setting up the ESP32-CAM](#setting-up-the-esp32-cam)
    - [Operating the Vehicle](#operating-the-vehicle)
  - [Video tranformation](#video-tranformation)
- [IoT](#iot)
  - [Introduction](#introduction-1)
  - [Features](#features-1)
  - [Getting Started](#getting-started-1)
    - [Prerequisites](#prerequisites-1)
  - [Usage](#usage)
- [E-commerce](#e-commerce)


## Telecom

### Introduction

The Telecom subsystem of the Group_46 project establishes a sophisticated communication layer for a smart, autonomous vehicle navigating through a maze. This subsystem handles live video streaming over Wi-Fi, enabling real-time monitoring of the vehicle's maneuvers, and manages the vehicle's movements using ultrasonic sensors.

### Features

- Real-Time Streaming Protocol (RTSP) server for live video streaming
- Wi-Fi communication for remote monitoring and control
- Autonomous navigation using ultrasonic sensors
- Dual-part control system utilizing both Arduino Mega 2560 and ESP32-CAM

### System Architecture

The vehicle's control logic is split between two main components: the Arduino Mega 2560 and the ESP32-CAM.

- **Arduino Mega 2560**: Responsible for the vehicle's movement logic, it processes input from three ultrasonic sensors to navigate through the maze and controls the motors to steer the vehicle.
- **ESP32-CAM**: Manages the Wi-Fi connectivity and video streaming, it broadcasts the live feed from the vehicle and communicates over the channels set up for data transmission.

### Getting Started

These instructions will guide you through setting up the project on your local machine for development, testing, and deployment purposes.

#### Prerequisites

- Arduino IDE or compatible software
- ESP32-CAM module and Arduino Mega 2560 board
- Access to a Wi-Fi network
- Python environment (for running the RTSP server script)

### Deployment

#### Setting up the Arduino Mega 2560

1. Open the `CarMovingFinal.ino` script with the Arduino IDE.
2. Upload the script to your Arduino Mega 2560 board.
3. Ensure the ultrasonic sensors and motors are connected as per the script's documentation.
4. Power up the Arduino board; the vehicle should now be capable of autonomous movement within the maze.

#### Setting up the ESP32-CAM

1. Configure the ESP32-CAM module with the provided scripts to establish the Wi-Fi connection and set up the video stream.
2. Verify the Wi-Fi name, connection method, and data transmission channel as per the script's output.
3. Ensure the camera is operational and streaming data over the configured Wi-Fi network.

#### Operating the Vehicle

Once both systems are up and running:

1. Place the vehicle at the maze's entrance.
2. Power up the system; the camera will initiate automatically, and the vehicle will start navigating through the maze.
3. Monitor the vehicle's progress through the live video feed streaming over Wi-Fi.


### Video tranformation
`rtsp_video_server_wlan_1.py`

- **Functionality**: This script sets up an RTSP server to stream video over WLAN, allowing for real-time monitoring of the vehicle's environment.
- **How it works**: 
  1. Configures the network interface for video streaming.
  2. Establishes an RTSP server to handle the video stream.
  3. Manages the capture and transmission of video frames, utilizing callback functions for different stages of the RTSP session.
- **Usage**: 
  ```
  python rtsp_video_server_wlan_1.py
  ```



## IoT

### Introduction

The IoT subsystem of the Group_46 project is dedicated to real-time object detection and data handling for a smart, autonomous vehicle capable of navigating through a maze. This subsystem processes video streams, performs object detection, trains detection models, and handles the transfer of image data, contributing to the vehicle's decision-making process.

### Features

- Real-time object detection with YOLO (You Only Look Once)
- GUI for result display and comparison
- Model training capabilities
- Data transfer and storage functionalities

### Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

#### Prerequisites

Before you begin, ensure you have met the following requirements:

- Python 3.8 or later
- Libraries and dependencies as listed in `requirements.txt`
- YOLOv3 or other compatible models
- Adequate hardware (GPU recommended) for running deep learning models

### Usage

`real_time_detect.py`

- **Functionality**: This script uses the YOLO algorithm for real-time object detection in video frames.

- **Usage**: 

  ```
  python real_time_detect.py
  ```

- **Details**: The script initializes the YOLO model, accesses a video feed, processes the video frames to detect objects, and displays the video stream with bounding boxes and labels around the detected objects.

`result_gui.py`

- **Functionality**: Provides a GUI for comparing and viewing images before and after object detection.

- **Usage**: 

  ```
  python result_gui.py
  ```

- **Details**: The script loads images from specified directories and displays them side-by-side in a simple GUI, allowing for easy comparison. Users can navigate through the images using the provided buttons.

`train_model.py`

- **Functionality**: Used for training the YOLO model with a specific dataset.

- **Usage**: 

  ```
  python train_model.py
  ```

- **Details**: The script loads a pre-trained YOLO model and trains it on a specified dataset to improve its accuracy. The trained model is saved for future use in object detection tasks.

`transfer_data.py`

- **Functionality**: Receive video streams in RTSP format from Telecom group cameras, and insert the detected paths of treasure images and exploration times into the database.

- **Usage**: 

  ```
  python transfer_data.py
  ```

- **Details**: The script captures video frames, performs object detection on each, saves annotated frames to a directory, and inserts relevant records into a database.


## E-commerce
