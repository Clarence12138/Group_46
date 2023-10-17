<%@page import="testWeb1.vo.RecordInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="testWeb1.vo.UserInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
	img {
    width: 200px; /* 设置图片宽度 */
    height: 200px; /* 设置图片高度 */
	}
	
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    
    .container {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
    }
    
    h1 {
        text-align: center;
        color: #333;
    }
    
    .user-info {
        margin-top: 20px;
        text-align: center;
    }
    
    ul {
        list-style-type: none;
        padding: 0;
        margin-top: 20px;
    }
    
    li {
        margin-bottom: 10px;
    }
    
    .record-id {
        font-weight: bold;
    }
    
    .record-time {
        color: #999;
    }
    
    .treasure-num {
        color: #00cc66;
    }
    
    .robot-id {
        color: #ff9933;
    }
    
    .button {
        display: inline-block;
        padding: 20px 20px;
        background-color: #333;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        margin-top: 50px;

   	 	margin-left: 30px; /* 设置按钮之间的间距 */
        
    }
    .button-container {
    	margin-left: 100px;
	}
    .button:hover {
        background-color: #666;
    }
    
    .hidden {
        display: none;
    }
    
    .show {
        display: block;
    }
    #robotId {
    position: absolute; /* 设置绝对定位 */
    left: 1300px; /* 设置距离左侧的偏移量 */
    top: 210px; /* 设置距离顶部的偏移量 */
	}
	    .data-table {
	    width: 100%;
	    border-collapse: collapse;
	}
	
	.data-table th,
	.data-table td {
	    padding: 10px;
	    border: 1px solid #ccc;
	}
	
	.data-table th {
	    background-color: #f0f0f0;
	}
	
	.data-table td:nth-child(1),
	.data-table td:nth-child(2),
	.data-table td:nth-child(3),
	.data-table td:nth-child(4),
	.data-table td:nth-child(5) {
	    vertical-align: top;
	}
	body {
   	background: url(https://pic2.zhimg.com/80/v2-f8f65ea301a3f2e26dbb7da902a07975_720w.webp) no-repeat center center fixed;
				/*兼容浏览器版本*/
                -webkit-background-size: cover;
				-o-background-size: cover;                
				background-size: cover;

	}
	
</style>
<script>
	function showRobot() {
	    var robotId = document.getElementById("robotId");
	    var button = document.getElementById("showRobotIdButton");
	    if (robotId.style.display === "none") {
	        robotId.style.display = "block";
	        robotId.style.left = (button.offsetLeft + button.offsetWidth) + "px";
	    } else {
	        robotId.style.display = "none";
	    }
	}

    function showRecords() {
        var records = document.getElementById("records");
        if (records.style.display === "none") {
            records.style.display = "block";
        } else {
            records.style.display = "none";
        }
    }
    
</script>
</head>
<body>
    <div class="container" >
        <h1>Welcome</h1>
        
        <div class="user-info">
            <% UserInfo user = (UserInfo)request.getAttribute("userinfo"); %>
            <p><%= user.getUsername() %></p>
            
            <p id="robotId" class="hidden">Robot: <%= user.getRobotid() %></p>
        </div>
        <div class="container button-container">
        	<a href="https://www.bilibili.com/video/BV1Sy4y157bq/?spm_id_from=333.337.search-card.all.click&vd_source=3eade7521a7cc6b6026131284cdbd0d1" class="button" target="_blank">Show Video</a>
        	<button class="button" onclick="showRecords()">Show Exploration Records</button>
    		<button class="button" onclick="showRobot()">Show Robot ID</button>
    		
		</div>
        <ul id="records" class="hidden">
		<table class="data-table">
        <thead>
            <tr>
                <th>Record ID</th>
                <th>Time</th>
                <th>Treasure Num</th>
                <th>Robot ID</th>
                <th>Image Paths</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${recordlist}" var="record">
                <tr>
                    <td>${record.id}</td>
                    <td>${record.time}</td>
                    <td>${record.treasure_num}</td>
                    <td>${record.robot_id}</td>
                    <td>
                        <c:forEach items="${record.imagePaths}" var="imagePath">
                            <img src="/upload/${imagePath}" alt="Image">
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
   	 </table>

        </ul>
    </div>

</body>
</html>