package ru.innopolis.borgatin.homework2.servlets;

import ru.innopolis.borgatin.homework2.DAO.UserDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 * Сервлет для обновления профиля пользователя
 */
public class ProfileUpdateServlet extends HttpServlet {
    private final String RESULT_MESSAGE_SUCCESS = "Профиль успешно обновлен.";
    private final String RESULT_MESSAGE_ERROR = "Произошла ошибка при обновлении профиля, обратитесь к администратору.";
    private final String RESULT_MESSAGE_SUCCESS_COLOR = "green";
    private final String RESULT_MESSAGE_ERROR_COLOR = "red";
    private final String LASTNAME_PARAM = "lastname";
    private final String FIRSTNAME_PARAM = "firstname";
    private final String MIDDLENAME_PARAM = "middlename";
    private final String CITY_PARAM = "city";
    private final String BIRTHDATE_PARAM = "birthdate";
    private final String GENDER_PARAM = "gender";



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text / html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String lastname = (String) req.getParameter(LASTNAME_PARAM);
        String firstname = (String) req.getParameter(FIRSTNAME_PARAM);
        String middlename = (String) req.getParameter(MIDDLENAME_PARAM);
        String city = (String) req.getParameter(CITY_PARAM);
        String birthdate = (String) req.getParameter(BIRTHDATE_PARAM);
        String gender = (String) req.getParameter(GENDER_PARAM);

        HttpSession session = req.getSession();
        int userID = (Integer)session.getAttribute("userID");

        User user = new User();
        user.setId(userID);
        user.setLastname(lastname);
        user.setFirstname(firstname);
        user.setMiddlename(middlename);
        user.setCity(city);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = formatter.parse(birthdate);
            user.setBirthday(date);
        } catch (ParseException e) {
            //Не удалось распознать строку даты
            //TODO: log
        }
        try {
            UserDAO userDAO = new UserDAO();
            user = userDAO.update(user);
            if (user!=null){
                req.setAttribute("user", user);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date birthday = new Date(user.getBirthday().getTime());

                String birthdayStr = simpleDateFormat.format(birthday);

                req.setAttribute("birthday", birthdayStr);
                req.setAttribute("resultMessage",RESULT_MESSAGE_SUCCESS );
                req.setAttribute("resultMessageColor",RESULT_MESSAGE_SUCCESS_COLOR );
            } else {
                req.setAttribute("resultMessage",RESULT_MESSAGE_ERROR );
                req.setAttribute("resultMessageColor",RESULT_MESSAGE_ERROR_COLOR );
            }
            RequestDispatcher view = req.getRequestDispatcher("profile.jsp");
            view.forward(req, resp);
        } catch (SQLException e) {
            //TODO: log
        }


    }
}
