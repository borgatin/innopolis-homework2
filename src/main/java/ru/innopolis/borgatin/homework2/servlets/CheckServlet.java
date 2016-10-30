package ru.innopolis.borgatin.homework2.servlets;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет отвечает за проверку авторизации пользователя
 * и перенаправление его в зависимости от результата
 * в личный кабинет или на страницу входа
 */
public class CheckServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(CheckServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Начало класса CheckServlet");
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("userID");
        if (obj != null) {
            logger.info("Пользователь был авторизован ранее. Перенаправим в личный кабинет.");
            RequestDispatcher view = req.getRequestDispatcher("personalPage.jsp");
            view.forward(req, resp);
        } else {
            logger.info("Пользователь не был авторизован ранее. Перенаправим на страницу входа.");
            RequestDispatcher view = req.getRequestDispatcher("login.jsp");
            view.forward(req, resp);
        }

    }
}
