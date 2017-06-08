package dao;

import entities.Description;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public class DescriptionDAO extends AbstractDAO<Description>{

    @Override
    protected List<Description> getAllEntities() {
        TypedQuery<Description> namedQuery = entityManager.createNamedQuery("Description.getAll", Description.class);
        List<Description> descriptions = namedQuery.getResultList();

        logger.info("All entity from the table 'description' were received.");

        return descriptions;
    }

    @Override
    public Description getById(int id) {
        Description description = entityManager.find(Description.class, id);

        logger.info("An entity(id =" + id + ") from the table 'description' was received.");

        return description;
    }
}
