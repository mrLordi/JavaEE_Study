package dao;

import entities.Description;

import javax.ejb.*;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DescriptionDAO extends AbstractDAO<Description>{

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Description> getAll() {
        TypedQuery<Description> namedQuery = entityManager.createNamedQuery("Description.getAll", Description.class);
        List<Description> descriptions = namedQuery.getResultList();

        logger.info("All entity from the table 'description' were received.");

        return descriptions;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Description getById(int id) {
        logger.info("An entity(id =" + id + ") from the table 'description' was received.");
        return entityManager.find(Description.class, id);
    }
}
