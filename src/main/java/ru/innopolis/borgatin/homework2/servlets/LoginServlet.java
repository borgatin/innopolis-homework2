package ru.innopolis.borgatin.homework2.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.borgatin.homework2.DAO.UserDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Сервлет отвечает за авторизацию пользователя
 */
public class LoginServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Начало класса LoginServlet");
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(username);
            String passwordFromDB = null;

            if (user!=null) {
                passwordFromDB = user.getPassword();
            }

            if (passwordFromDB!=null&&passwordFromDB.equals(password)){
                logger.debug("Результат авторизации - успешно");
                HttpSession session = req.getSession(true);
                session.setAttribute("userID", user.getId());
                session.setAttribute("user", user);
                resp.sendRedirect("personalPage.jsp");
            } else {
                logger.debug("Результат авторизации - отказ: неверное имя пользователя или пароль");
                req.setAttribute("errorMsg", "Неверное имя пользователя или пароль");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            logger.error("Ошибка при получении данных из БД при аутентификации: {}", e.getMessage());

        }
    }
}
