package ru.innopolis.borgatin.homework2.DAO.abstr;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс предназначен для получения объектов Connection из пула,
 * описывает основную логику для работы с БД для конкретных сущностей.
 * От него необходимо наследоваться, чтобы реализовать работу с БД для сущности.
 */

public abstract class AbstractDAO<E, K> {
    private Connection connection;

    public AbstractDAO() throws SQLException {
        InitialContext initialContext = null;
        try {
            initialContext = new InitialContext();

            DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/app");
            connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public abstract List<E> getAll();

    public abstract E getEntityById(K id);

    public abstract E update(E entity);

    public abstract boolean delete(K id);

    public abstract boolean create(E entity);

    public Connection getConnection() {
        return connection;
    }

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() throws SQLException {
        connection.close();
    }


}
