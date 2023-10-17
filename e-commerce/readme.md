Project overview
This project is a web page, used to achieve user login, registration functions and display robot exploration record information.

Instructions for use
The running environment of this project is windows10.
Jdk17.0.8.1,
The server environment is Tomcat v8.5.
The compilation environment is eclipse-jee-2023-06
The database version is mysql-8.0.33-winx64
The database operation management tool is MySQL Workbench 8.0 CE
Before you start running, make sure that the database table javawebdb has been imported into the database, that the code for connecting to the database is changed to the user name and password of the machine (mentioned below), that the mysql service is running, that tomcat is started, and that run as testWeb1 is performed.

File structure
The project structure is divided into java project and webapp file.
In the Java project, the dao folder contains the implementation files related to the data access object, the db folder contains the files related to the database connection to implement the database connection, the vo folder contains the files related to the value object, RecordInfo and UserInfo represent the discovery record information and the user information respectively.
It should be noted that RecordDao.java and DBConnect.java contain parts of the database connection and need to correct the user name and password to the local correct user name and password.
jsp file in Webapp is used to display the web page, error.jsp is the page that prompts the user name or password input error, register.jsp is the user registration page,userinterface.jsp is the userinterface welcome.jsp is the userinterface after login
lib contains the jar packages required for the project
It should be noted that, server.xml adds <Context crossContext="true" docBase="C:\Users\12975\Pictures\" path="/upload" reloadable="true"></Context> is used to read pictures in the local folder, which needs to be changed to the correct folder on the running machine, consistent with the folder where the Internet of Things students store pictures.

Contact way:
zhangjiaxiang36@bupt.edu.cn
