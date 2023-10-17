<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
body {
   background: url(https://ts1.cn.mm.bing.net/th/id/R-C.7de8df86d7d3233fa1f940b33dcbba8b?rik=iZxxV31rxXIkNA&riu=http%3a%2f%2fpic.bizhi360.com%2fbbpic%2f32%2f5432.jpg&ehk=asRYwnQVMTFuGgWdpEICRtoeRqicjB6hKuyd9l%2byW04%3d&risl=&pid=ImgRaw&r=0) no-repeat center center fixed;
				/*兼容浏览器版本*/
                -webkit-background-size: cover;
				-o-background-size: cover;                
				background-size: cover;

}

#loginDiv {
    width: 400px; /* 将方框宽度调整为400px */
    margin: 0 auto; /* 居中显示方框 */
    margin-top: 300px; /* 调整方框与页面顶部的距离 */
    padding: 20px;
    background-color: #BCEBEA;
    border: 1px solid #ccc;
    border-radius: 5px;
}

#loginMsg {
    text-align: center;
    font-size: 24px;
    margin-bottom: 20px;
}

input[type="text"],
input[type="password"] {
    width: 90%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.button {
    padding: 10px 20px;
    background-color: #88B9F0;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.button:hover {
    background-color: #45a049;
}

#subDiv {
    text-align: center;
}

a {
    color: #666;
    text-decoration: none;
}

a:hover {
    color: #001;
}
</style>
</head>
<body>
    <div id="loginDiv">
        <form action="${pageContext.request.contextPath}/userLogin" id="form" method="post">
            <h1 id="loginMsg">LOG IN</h1>
            <p>Username:<input id="username" name="username" type="text"></p>

            <p>Password:<input id="password" name="password" type="password"></p>

            <div id="subDiv">
                <input type="submit" class="button" value="login">
                <input type="reset" class="button" value="reset">
                <a href="./register.jsp">Register an account</a> <!-- 不换行 -->
            </div>
        </form>
    </div>
</body>
</html>
