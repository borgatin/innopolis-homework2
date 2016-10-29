package ru.innopolis.borgatin.homework2.servlets;

import ru.innopolis.borgatin.homework2.DAO.UserDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by avborg on 28.10.2016.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Считаем информацию с полей ввода
        String username = (String) req.getParameter("username");
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");

        User user = new User (username, password);
        user.setEmail(email);
        try {
            UserDAO userDAO = new UserDAO();
            RequestDispatcher view = null;
            if (userDAO.create(user)){
                view = req.getRequestDispatcher("regSuccess.jsp");
            } else {
                view = req.getRequestDispatcher("regFailed.jsp");
            }
            view.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
}
