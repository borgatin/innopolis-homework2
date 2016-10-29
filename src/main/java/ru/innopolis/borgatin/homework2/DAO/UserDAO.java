package ru.innopolis.borgatin.homework2.DAO;

import ru.innopolis.borgatin.homework2.DAO.abstr.AbstractDAO;
import ru.innopolis.borgatin.homework2.entity.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс отвечает за работу с пользователями в БД
 */
public class UserDAO extends AbstractDAO<User, Integer>
{
    private final String QUERY_CHECK_LOGIN = "select count (*) logins_count from users where login = ?";
    private final String QUERY_CREATE_USER = "insert  into users (login, password, email, reg_date) values (?, ?, ?, current_date)";




    public UserDAO() throws SQLException {
        super();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityById(Integer id) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        Connection connection = getConnection();
        //TODO:нужно использовать транзакцию, иначе между проверкой наличия логина
        //и созданием логина его может создать кто-то другой!


        //Проверим, занят ли логин
        if (loginIsFree(entity.getLogin(), connection)){
            try (PreparedStatement regStatement = connection.prepareStatement(QUERY_CREATE_USER)){
                regStatement.setString(1, entity.getLogin());
                regStatement.setString(2, entity.getPassword());
                regStatement.setString(3, entity.getEmail());

                int rowCount = regStatement.executeUpdate();
                if (rowCount>0){
                    return true;
                }
            } catch (SQLException E){
                //TODO: В случае ошибки откатим транзакцию и вернем false

            }
        }

        return false;

    }

    private boolean loginIsFree(String login, Connection connection){

        try (PreparedStatement checkStatement = connection.prepareStatement(QUERY_CHECK_LOGIN)) {
            checkStatement.setString(1, login);
            try (ResultSet resultSet = checkStatement.executeQuery()) {
                if (resultSet.next()) {
                    int loginsCount = resultSet.getInt("logins_count");
                    if (loginsCount > 0) {
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
