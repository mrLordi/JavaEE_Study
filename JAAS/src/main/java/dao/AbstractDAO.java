package dao;

import org.apache.log4j.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public abstract class AbstractDAO<T> {

    protected final static Logger logger = Logger.getLogger(AbstractDAO.class);

    @PersistenceContext(unitName = "movies")
    protected EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public abstract List<T> getAll();

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public abstract T getById(int id);

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(T entity) {

        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            logger.error("An error occurred while adding an entity(" + entity + "). Error: " + e.getMessage());
            throw e;
        }
        logger.info("An entity(" + entity + ") was added.");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void update(T entity) {
         try {
            entityManager.merge(entity);
        } catch (Exception e) {
            logger.error("An error occurred while updating an entity(" + entity + "). Error: " + e.getMessage());
             throw e;
        }

        logger.info("Entity(" + entity + ") was updated.");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));

        logger.info("An entity(" + entity + ") was deleted.");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteById(int id) {
        entityManager.remove(getById(id));

        logger.info("An entity(id =" + id + ") was deleted.");
    }

}

