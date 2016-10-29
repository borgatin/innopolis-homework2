<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Journal - Личный дневник</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />


</head>

<body>

<div class="parent">
    <div class="block">

<form action="${pageContext.request.contextPath}/login" method="POST">
  <p>Вход:</p>
    <div class="main">
        <div class="field">
            <label> <b>Логин:</b></label>
            <input type="text" size="20" name="username">
        </div>
        <div class="field">
            <label>  <b>Пароль:</b></label>
            <input type="password" size="20" name="password">
        </div>
        <input type="submit" value="Войти">
    </div>
</form>

<br/>
<a href="registration.jsp">Регистрация</a>
    </div>
</div>
</body>
</html>
