package dao;

import entities.Director;
import entities.Movie;
import entities.Producer;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProducerDAO {

    protected final static Logger logger = Logger.getLogger(ProducerDAO.class);

    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext(unitName = "movies")
    protected EntityManager entityManager;

    public void add(Producer entity) {

        try {
            userTransaction.begin();
            entityManager.merge(entity);
            userTransaction.commit();
        } catch (Exception e) {
            logger.error("An error occurred while adding a producer(" + entity + "). Error: " + e.getMessage());
            return;
        }
        logger.info("A producer(" + entity + ") was added.");
    }

    public void update(Producer entity) {
        try {
            userTransaction.begin();
            entityManager.merge(entity);
            userTransaction.commit();
        } catch (Exception e) {
            logger.error("An error occurred while updating a producer(" + entity + "). Error: " + e.getMessage());
            return;
        }

        logger.info("A producer(" + entity + ") was updated.");
    }

    public void delete(Producer entity) {
        try {
            userTransaction.begin();
            entityManager.remove(entityManager.merge(entity));
            userTransaction.commit();
        } catch (Exception e) {
            logger.error("An error occurred while deleting a producer(" + entity + "). Error: " + e.getMessage());
            return;
        }

        logger.info("An entity(" + entity + ") was deleted.");
    }

    public void deleteById(int id) {

        try {
            userTransaction.begin();
            entityManager.remove(getById(id));
            userTransaction.commit();
        } catch (Exception e) {
            logger.error("An error occurred while deleting a producer(id = " + id + "). Error: " + e.getMessage());
            return;
        }

        logger.info("An entity(id =" + id + ") was deleted.");
    }

    public List<Producer> getAll() {
        TypedQuery<Producer> namedQuery = entityManager.createNamedQuery("Producer.getAll", Producer.class);
        List<Producer> producers = namedQuery.getResultList();

        logger.info("All entity from the table 'producer' were received.");

        return producers;
    }

    public Producer getById(int id) {
        Producer producer = entityManager.find(Producer.class, id);

        logger.info("An entity(id = " + id + ") from the table 'producer' was received.");

        return producer;
    }

}
