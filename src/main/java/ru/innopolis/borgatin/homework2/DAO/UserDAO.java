package ru.innopolis.borgatin.homework2.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.borgatin.homework2.DAO.abstr.AbstractDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import java.sql.*;
import java.util.List;

/**
 * Класс предназначен для работы с пользователями в БД
 */
public class UserDAO extends AbstractDAO<User, Integer>
{
    private final String QUERY_CHECK_LOGIN = "select count (*) logins_count from users where login = ?";
    private final String QUERY_CREATE_USER =
            "insert  into users (login, password, email, reg_date) values (?, ?, ?, current_date)";
    private final String QUERY_GET_USER_BY_LOGIN = "select * from users where login = ?";
    private final String QUERY_GET_USER_BY_ID = "select * from users where id = ?";
    private final String QUERY_UPDATE_USER_BY_ID =
            "update users set lastname = ?, firstname = ?, middlename = ?, city = ?, birthdate = ?,gender = ? where id = ?";

    private static Logger logger = LoggerFactory.getLogger(UserDAO.class);


    public UserDAO() throws SQLException {
        super();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityById(Integer id) {
        try(Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_GET_USER_BY_ID)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        User user = getUserByResultSet(resultSet);
                        return user;
                    }
                }
            } catch (SQLException e) {
                logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }
        return null;
    }


    @Override
    public User update(User entity) {
        try(Connection connection = getConnection()) {
            try (PreparedStatement regStatement = connection.prepareStatement(QUERY_UPDATE_USER_BY_ID)) {
                regStatement.setString(1, entity.getLastname());
                regStatement.setString(2, entity.getFirstname());
                regStatement.setString(3, entity.getMiddlename());
                regStatement.setString(4, entity.getCity());
                regStatement.setDate(5, new Date(entity.getBirthday().getTime()));
                regStatement.setString(6, null);//TODO: передавать пол
                regStatement.setInt(7, entity.getId());


                int rowCount = regStatement.executeUpdate();
                if (rowCount > 0) {
                    return entity;
                }
            } catch (SQLException e) {
                logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        try (Connection connection = getConnection()) {
            //Проверим, занят ли логин
            if (loginIsFree(entity.getLogin(), connection)) {
                try (PreparedStatement regStatement = connection.prepareStatement(QUERY_CREATE_USER)) {
                    regStatement.setString(1, entity.getLogin());
                    regStatement.setString(2, entity.getPassword());
                    regStatement.setString(3, entity.getEmail());

                    int rowCount = regStatement.executeUpdate();
                    if (rowCount > 0) {
                        return true;
                    }
                } catch (SQLException e) {
                    logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
                }
            }
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }
        return false;
    }

    private boolean loginIsFree(String login, Connection connection){

        try (PreparedStatement checkStatement = connection.prepareStatement(QUERY_CHECK_LOGIN)) {
            checkStatement.setString(1, login);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    int loginsCount = resultSet.getInt("logins_count");
                    return loginsCount <= 0;
                }
            }
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }
        return false;
    }

    public User getUserByLogin(String login) {
        try(Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_GET_USER_BY_LOGIN)) {
                statement.setString(1, login);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return getUserByResultSet(resultSet);
                    }
                }
            } catch (SQLException e) {
                logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
            }
        } catch (SQLException e) {
            logger.error("Произошла ошибка при работе с БД: {}", e.getMessage());
        }
        return null;
    }

    private User getUserByResultSet(ResultSet resultSet) throws SQLException {
        User user = new User ();
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setLastname(resultSet.getString("lastname"));
        user.setFirstname(resultSet.getString("firstname"));
        user.setMiddlename(resultSet.getString("middlename"));
        user.setCity(resultSet.getString("city"));
        user.setBirthday(resultSet.getDate("birthdate"));
        user.setRegistrationDay(resultSet.getDate("reg_date"));
        user.setGender(resultSet.getString("gender"));
        return user;
    }


}
