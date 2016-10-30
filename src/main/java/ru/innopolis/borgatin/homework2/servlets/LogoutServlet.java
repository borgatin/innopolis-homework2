package ru.innopolis.borgatin.homework2.servlets;

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
 * Сервлет отвечает за выход из личного кабинета
 */
public class LogoutServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(LogoutServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Начало класса LogoutServlet");
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/homework/");


    }
}
