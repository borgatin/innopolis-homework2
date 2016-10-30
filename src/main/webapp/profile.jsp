<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <link rel="stylesheet" href="CSS/style.css" type="text/css" />
    <link rel="stylesheet" href="CSS/tcal.css" type="text/css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/validate.messages_ru.js"></script>
    <script src="js/homework2.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#profileForm").validate({
                errorPlacement: function (error, element) {
                    validPlaceError(error,element);
                },
                success: function (label, element) {
                    validPlaceSuccess(label, element);
                }
            });
        })
    </script>
</head>
<body>

<div class="parent">
    <div class="block">
        <table class="maintable" >
            <tr>
                <td colspan="2" width="90%"><p>Добро пожаловать в Personal Journal, ${user.login}</p></td>
                <td><a href="${pageContext.request.contextPath}/logout">Выход</a> </td>
            </tr>
            <tr >

                <td class="leftcol">
                    <a href="${pageContext.request.contextPath}/personalPage.jsp">Личный кабинет</a>
                    <br/>
                    <%--<a href="personalPage.jsp">Все посты</a>--%>
                </td>
                <td colspan="2" class="rigthcol">
                    <form id="profileForm" action="${pageContext.request.contextPath}/updateProfile" method="POST">
                        <p>Профиль пользователя ${user.login}:</p>
                        <div class="main">
                            <div class="field">
                                <label> <b>Фамилия:</b></label>
                                <input type="text" size="20" name="lastname" class="required" value=${user.lastname}>
                                <p></p>
                            </div>
                            <div class="field">
                                <label> <b>Имя:</b></label>
                                <input type="text" size="20" name="firstname" class="required"  value=${user.firstname}>
                                <p></p>
                            </div>
                            <div class="field">
                                <label> <b>Отчество:</b></label>
                                <input type="text" size="20" name="middlename" value=${user.middlename}>
                                <p></p>
                            </div>
                            <div class="field">
                                <label> <b>Город:</b></label>
                                <input type="text" size="20" name="city" value=${user.city}>
                                <p></p>
                            </div>
                            <div class="field">
                                <label> <b>Дата рождения:</b></label>
                                <input type="text" size="20"  name="birthdate"  class="anyDate" value=${birthday}>
                                <p></p>
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
                        <div class="field">
                            <input type="submit" value="Сохранить">
                        </div>
                    </form>
                </td>
            </tr>
        </table>



        <p style="color:${resultMessageColor}">${resultMessage}</p>
    </div>
</div>
</body>
</html>
