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
                view = req.getRequestDispatcher("regSuccess.jsp");
            }
            view.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

/*

        //Запишем пользователя в БД. в случае успеха переведем его на страницу входа
        //Иначе - переведем его на страницу повторной регистрации с соответсвующим сообщением
        try {
            Class.forName("org.postgresql.Driver");
            try(Connection connection = DriverManager.getConnection(
                    , "postgres", "1Qwerty")) {

                //Проверим, занят ли логин
                String QueryCheckLogin =
                        "select count (*) logins_count from users where login = ?";
                try (PreparedStatement checkStatement = connection.prepareStatement(QueryCheckLogin)) {
                    checkStatement.setString(1, username);
                    try (ResultSet resultSet = checkStatement.executeQuery()) {
                        if (resultSet.next()) {
                            int loginsCount = resultSet.getInt("logins_count");
                            if (loginsCount > 0) {
                                //TODO: как-то нужно выдать уведомление user`у о занятом логине
                                //
                                RequestDispatcher indexView = req.getRequestDispatcher("registration.jsp");
                                indexView.forward(req, resp);
                            }

                        }
                    }
                }

                String Query =
                        "insert  into users (login, password, email, reg_date) values (?, ?, ?, current_date)";
                PreparedStatement regStatement = connection.prepareStatement(Query);

                regStatement.setString(1, username);
                regStatement.setString(2, password);
                regStatement.setString(3, email);

                int rowCount = regStatement.executeUpdate();

                RequestDispatcher view = req.getRequestDispatcher("regSuccess.jsp");
                view.forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgerSQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/


    }
}
