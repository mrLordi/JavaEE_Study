package dao;

import entities.Movie;
import entities.Producer;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public class MovieDAO extends AbstractDAO<Movie>{

    @Override
    protected List<Movie> getAllEntities() {
        TypedQuery<Movie> namedQuery = entityManager.createNamedQuery("Movie.getAll", Movie.class);
        List<Movie> movies = namedQuery.getResultList();

        logger.info("All entity from the table 'movie' were received.");

        return movies;
    }

    @Override
    public Movie getById(int id) {
        Movie movie = entityManager.find(Movie.class, id);

        logger.info("An entity(id = " + id + ") from the table 'movie' was received.");

        return movie;
    }

}
