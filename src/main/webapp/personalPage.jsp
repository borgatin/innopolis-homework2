<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Профиль Personal Journal!</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />

</head>
<body>
<div class="parent">
    <div class="blockMain">
        <table class="maintable" >
            <tr >

                <td class="leftcol">
                    <a href="${pageContext.request.contextPath}/editProfile">Редактировать профиль</a>
                    <br/>
                    <a href="personalPage.jsp">Все посты</a>
                </td>
                <td class="rigthcol">
                    Добро пожаловать в Personal Journal
                    Здесь будут мои статьи

                </td>
            </tr>
        </table>
    </div>
</div>
</body>

</html>
