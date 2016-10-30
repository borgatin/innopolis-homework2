<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />
    <link rel="stylesheet" href="CSS/tcal.css" type="text/css" />
    <script src="js/cal/tcal.js"></script>
</head>
<body>

<div class="parent">
    <div class="block">

        <form action="${pageContext.request.contextPath}/updateProfile" method="POST">
            <p>Профиль пользователя ${user.login}:</p>
            <div class="main">
                <div class="field">
                    <label> <b>Фамилия:</b></label>
                    <input type="text" size="20" name="lastname" value=${user.lastname}>
                </div>
                <div class="field">
                    <label> <b>Имя:</b></label>
                    <input type="text" size="20" name="firstname" value=${user.firstname}>
                </div>
                <div class="field">
                    <label> <b>Отчество:</b></label>
                    <input type="text" size="20" name="middlename" value=${user.middlename}>
                </div>
                <div class="field">
                    <label> <b>Город:</b></label>
                    <input type="text" size="20" name="city" value=${user.city}>
                </div>
                <div class="field">
                    <label> <b>Дата рождения:</b></label>
                    <input type="text" size="17"  name="birthdate" class="tcal" value=${birthday}>
                </div>
                <%--<div class="field">--%>
                    <%--<label> <b>Пол:</b></label>--%>
                    <%--<select name="gender">--%>
                        <%--<option ${genderMen} >Мужской</option>--%>
                        <%--<option ${genderWomen}>Женский</option>--%>
                    <%--</select>--%>
                    <%--&lt;%&ndash;<input type="text" size="20" name="gender" value=${user.gender}>&ndash;%&gt;--%>
                <%--</div>--%>


            </div>

            <input type="submit" value="Сохранить">
        </form>
        <p style="color:${resultMessageColor}">${resultMessage}</p>
    </div>
</div>
</body>
</html>
