<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />
</head>
<body>

<div class="parent">
    <div class="block">

<form action="${pageContext.request.contextPath}/reg" method="POST">
    <p><a href="index.jsp">Войти</a></p>
    <p>Регистрация:</p>
    <div class="main">
        <div class="field">
            <label> <b>Имя пользователя:</b></label>
            <input type="text" size="20" name="username">
        </div>
        <div class="field">
            <label> <b>Электронная почта:</b></label>
            <input type="email" size="20" name="email">
        </div>
        <div class="field">
            <label> <b>Пароль:</b></label>
            <input type="password" size="20" name="password">
        </div>
        <br/>
        <p style="color:red">${errorMsg}</p>
        <input type="submit" value="Зарегистрироваться">

    </div>

</form>

    </div>
</div>
</body>
</html>
