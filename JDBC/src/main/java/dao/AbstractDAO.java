package dao;

import connection.ConnectionPool;

import java.util.List;

/**
 * Created by win10 on 07.10.2016.
 */
public abstract class AbstractDAO<T> {

    protected ConnectionPool connectionPool;

    public AbstractDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract boolean add(T entity);
    public abstract boolean update(T entity);
    public abstract boolean deleteById(int id);
    public abstract int maxId();

}
