<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <style type="text/css">
        .parent {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            overflow: auto;
        }

        .block {
            width: 350px;
            height: 350px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;}

        .field {clear:both; text-align:right; line-height:25px;}
        label {float:left; padding-right:10px;}
        .main {float:left}

    </style>
</head>
<body>

<div class="parent">
    <div class="block">

<form action="${pageContext.request.contextPath}/reg" method="POST">
    <p>Профиль:</p>
    <div class="main">
        <div class="field">
            <label> <b>Фамилия:</b></label>
            <input type="text" size="20" name="lastname">
        </div>
        <div class="field">
            <label> <b>Имя:</b></label>
            <input type="text" size="20" name="firstname">
        </div>
        <div class="field">
            <label> <b>Отчество:</b></label>
            <input type="text" size="20" name="middlename">
        </div>
        <div class="field">
            <label> <b>Город:</b></label>
            <input type="text" size="20" name="city">
        </div>
        <div class="field">
            <label> <b>Дата рождения:</b></label>
            <input type="text" size="20" name="birthdate">
        </div>
        <div class="field">
            <label> <b>Пол:</b></label>
            <input type="text" size="20" name="gender">
        </div>


    </div>

    <input type="submit" value="Сохранить">
</form>

    </div>
</div>
</body>
</html>
