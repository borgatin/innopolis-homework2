package ru.innopolis.borgatin.homework2.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.borgatin.homework2.DAO.UserDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 * Сервлет предназначен для регистрации пользователя
 */
public class RegistrationServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("Начало класса RegistrationServlet");

        //Получим информацию с полей ввода
        String username = (String) req.getParameter("username");
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");

        User user = new User (username, password);
        user.setEmail(email);
        try {
            UserDAO userDAO = new UserDAO();
            RequestDispatcher view = null;
            if (userDAO.create(user)){
                logger.debug("Успешная регистрация для логина {}", username);
                view = req.getRequestDispatcher("regSuccess.jsp");
            } else {
                logger.debug("Неудачная попытка регистрации для логина {} - логин занят", username);
                req.setAttribute("errorMsg", "Имя пользователя уже занято. Попробуйте еще раз.");
                view = req.getRequestDispatcher("registration.jsp");
            }
            view.forward(req, resp);
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }


    }
}
