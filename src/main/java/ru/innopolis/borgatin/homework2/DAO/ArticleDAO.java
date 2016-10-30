package ru.innopolis.borgatin.homework2.DAO;

import ru.innopolis.borgatin.homework2.DAO.abstr.AbstractDAO;
import ru.innopolis.borgatin.homework2.entity.Article;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс предназначен для работы со статьями в БД
 */
public class ArticleDAO extends AbstractDAO<Article, Integer> {

    public ArticleDAO() throws SQLException, NamingException {
        super();
    }

    @Override
    public List<Article> getAll() {
        return null;
    }

    @Override
    public Article getEntityById(Integer id) {
        return null;
    }

    @Override
    public Article update(Article entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Article entity) {
        return true;
    }
}
