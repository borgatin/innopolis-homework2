<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Личный кабинет Personal Journal!</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />

</head>
<body>
<div class="parent">
    <div class="blockMain">
        <table class="maintable" >
            <tr>
                <td colspan="2" width="90%"><p>Добро пожаловать в Personal Journal, ${user.login}</p></td>
                <td><a href="${pageContext.request.contextPath}/logout">Выход</a> </td>
            </tr>
            <tr >

                <td class="leftcol">
                    <a href="${pageContext.request.contextPath}/editProfile">Редактировать профиль</a>
                    <br/>
                    <%--<a href="personalPage.jsp">Все посты</a>--%>
                </td>
                <td colspan="2" class="rigthcol">
                    <p>Мои статьи</p>
                    <table border="black">
                        <tr>
                            <th width="50%">Тема</th>
                            <th width="15%">Область видимости</th>
                            <th width="15%">Дата создание</th>
                            <th width="20%">Действия</th>
                        </tr>
                        <tr>
                            <td>тест</td>
                            <td>тест</td>
                            <td>тест</td>
                            <td>тест</td>
                        </tr>

                    </table>

                </td>
            </tr>
        </table>
    </div>
</div>
</body>

</html>
