package dao;

import entities.Director;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DirectorDAO extends AbstractDAO<Director> {

    @Override
    public   List<Director> getAll() {
        TypedQuery<Director> namedQuery = entityManager.createNamedQuery("Director.getAll", Director.class);
        List<Director> directors = namedQuery.getResultList();

        logger.info("All entity from the table 'director' were received.");

        return directors;
    }

    @Override
    public Director getById(int id) {
        Director director = entityManager.find(Director.class, id);

        logger.info("An entity(id = " + id + ") from the table 'director' was received.");

        return director;
    }

}
