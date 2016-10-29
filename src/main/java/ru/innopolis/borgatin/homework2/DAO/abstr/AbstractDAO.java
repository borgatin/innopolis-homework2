package ru.innopolis.borgatin.homework2.DAO.abstr;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by avborg on 29.10.2016.
 */

public abstract class AbstractDAO<E, K> {
    private Connection connection;

    public AbstractDAO() throws SQLException, NamingException {
        InitialContext initialContext = new InitialContext();
        DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/dbconnect");
        connection = ds.getConnection();
    }


    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    public Connection getConnection(){
        return connection;
    }

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() throws SQLException {
        connection.close();
    }


}