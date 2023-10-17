<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<style>
body {
  background: url(https://pic3.zhimg.com/v2-fc0a76a30a3eed8c7569adc62bb3c31e_r.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.container {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 100vh;
}

.form-div {
  background-color: rgba(255, 255, 255, 0.8);
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.form-div h1 {
  text-align: center;
  margin-bottom: 20px;
}

.form-div form {
  display: flex;
  flex-direction: column;
}

.form-div label {
  margin-bottom: 10px;
}

.form-div input,
.form-div select {
  padding: 10px;
  margin-bottom: 10px;
}

.form-div textarea {
  padding: 10px;
  margin-bottom: 10px;
  resize: vertical;
}

.form-div .buttons {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.form-div .buttons a {
  text-decoration: none;
}

.clear {
  clear: both;
}
</style>
</head>
<body>

<div class="container">
  <div class="form-div">
    <h1>Welcome to register</h1>
    <form id="reg-form" action="${pageContext.request.contextPath}/register" method="post">
      <label for="username">username:</label>
      <input name="username" type="text" id="username">

      <label for="password">password:</label>
      <input name="password" type="password" id="password">

      <label for="password1">confirm:</label>
      <input name="password1" type="password" id="password1">

	 
		<input type="radio" id="male" name="gender" value="男">
		<label for="male">male</label>
		
		<label for="female"></label>
		<input type="radio" id="female" name="gender" value="女">
		<label for="female">female</label>

      <label>profession:</label>
      <select id="group" name="profession">
        <option value="测试">test</option>
        <option value="前端">front-end</option>
        <option value="后端">back-end</option>
        <option value="经理">manager</option>
      </select>

      <label>favor:</label>
      <select name="favor" id="favor">
        <option value="音乐">music</option>
        <option value="舞蹈">dancing</option>
        <option value="绘画">painting</option>
        <option value="写作">writing</option>
      </select>

      <label>description:</label>
      <textarea name="description" rows="10" cols="20">Please enter</textarea>

      <div class="buttons">
        <input value="submit" type="submit" id="reg_btn">
        <a href="userinterface.jsp">Already have an account? Go log in</a>
      </div>
    </form>
  </div>
</div>

</body>
</html>
