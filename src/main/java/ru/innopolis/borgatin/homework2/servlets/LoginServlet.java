package ru.innopolis.borgatin.homework2.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by avborg on 28.10.2016.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");


        //плучим пароль пользователя по логину

        try {
            Class.forName("org.postgresql.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/PersonalJournal"
                    , "postgres", "1Qwerty")) {
                //Получим пароль из БД
                String QueryCheckLogin =
                        "select password from users where login = ?";
                try (PreparedStatement checkStatement = connection.prepareStatement(QueryCheckLogin)) {
                    checkStatement.setString(1, username);
                    try (ResultSet resultSet = checkStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String password1 = resultSet.getString("password");
                            //сверим пароль в БД с паролем пользователя
                            RequestDispatcher view;
                            if (password1.equals(password)) {
                                //если пароль верный
                                //1. TODO: создадим сессию

                                //2. перейдем в личный кабинет
                                view = req.getRequestDispatcher("personalPage.jsp");


                            } else {
                                //если пароль неверный
                                view = req.getRequestDispatcher("Error.jsp");

                            }
                            view.forward(req, resp);

                        }
                    }
                }









            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
