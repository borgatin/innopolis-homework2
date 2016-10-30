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

/**
 * Created by avborg on 30.10.2016.
 */
public class ProfileViewServlet extends HttpServlet {
    private final String GENDER_MEN = "мужской";
    private final String GENDER_WOMEN = "женский";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        username
        HttpSession session = req.getSession();
        int userID = (Integer) session.getAttribute("userID");
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getEntityById(userID);
            req.setAttribute("user", user);
//            if (GENDER_MEN.equals(user.getGender())){
//                req.setAttribute("genderMen", "selected");
//            } else if(GENDER_WOMEN.equals(user.getGender())){
//                req.setAttribute("genderWomen", "selected");
//            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthday = new Date(user.getBirthday().getTime());

            String birthdayStr = simpleDateFormat.format(birthday);

            req.setAttribute("birthday", birthdayStr);
            RequestDispatcher view = req.getRequestDispatcher("profile.jsp");
            view.forward(req, resp);
    } catch (SQLException e) {
            //TODO: logger
        }

    }
}
