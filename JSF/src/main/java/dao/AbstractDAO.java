package dao;

import org.apache.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public abstract class AbstractDAO<T> {

    protected final static Logger logger = Logger.getLogger(AbstractDAO.class);
    protected EntityManager entityManager;

    public AbstractDAO() {
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }

    protected abstract List<T> getAllEntities();
    public abstract T getById(int id);

    public List<T> getAll() {
        List<T> entities = getAllEntities();
        for (T entity : entities) {
            entityManager.refresh(entity);
        }

        return entities;
    }

    public void add(T entity) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.info("An error occurred while adding an entity(" + entity + "). Error: " + e.getMessage());
        }
        logger.info("An entity(" + entity + ") was added.");
    }

    public void update(T entity) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            entityManager.merge(entity);
            entityManager.flush();
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.info("An error occurred while updating an entity(" + entity + "). Error: " + e.getMessage());
        }

        logger.info("Entity(" + entity + ") was updated.");
    }

    public void delete(T entity) {
        logger.info("An entity(" + entity + ") was deleted.");

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        entityTransaction.commit();
    }

    public void deleteById(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(getById(id));
        entityManager.flush();
        entityTransaction.commit();

        logger.info("An entity(id =" + id + ") was deleted.");
    }

}

