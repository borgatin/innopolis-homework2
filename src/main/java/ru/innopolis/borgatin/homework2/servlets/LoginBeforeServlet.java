package ru.innopolis.borgatin.homework2.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by avborg on 30.10.2016.
 */
public class LoginBeforeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("userID");
        if (obj != null) {
            RequestDispatcher view = req.getRequestDispatcher("personalPage.jsp");
            view.forward(req, resp);
        } else {
            RequestDispatcher view = req.getRequestDispatcher("index.jsp");
            view.forward(req, resp);
        }

    }
}
