package dao;

import entities.Director;
import entities.Movie;
import entities.Producer;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public class ProducerDAO extends AbstractDAO<Producer> {

    @Override
    protected List<Producer> getAllEntities() {
        TypedQuery<Producer> namedQuery = entityManager.createNamedQuery("Producer.getAll", Producer.class);
        List<Producer> producers = namedQuery.getResultList();

        logger.info("All entity from the table 'producer' were received.");

        return producers;
    }

    @Override
    public Producer getById(int id) {
        Producer producer = entityManager.find(Producer.class, id);

        logger.info("An entity(id = " + id + ") from the table 'producer' was received.");

        return producer;
    }

}
