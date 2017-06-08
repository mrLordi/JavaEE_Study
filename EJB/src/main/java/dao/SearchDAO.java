package dao;

import entities.Director;
import entities.Movie;
import org.apache.log4j.Logger;

import javax.ejb.*;
import java.util.List;
import java.util.Random;

/**
 * Created by win10 on 14.11.2016.
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchDAO {

    private final static Logger logger = Logger.getLogger(SearchDAO.class);

    @EJB
    private DirectorDAO directorDAO;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void searchDirector(Movie movie) {
        Director director = movie.getDirector();

        try {
            offer(director);
        } catch (RuntimeException e) {
            logger.error("SEARCH:: Transaction error! Director (" + director + ") did not agree.");

            List<Director> directors = directorDAO.getAll();

            for (Director director1 : directors) {
                if (!director1.equals(director)) {
                    try {
                        offer(director1);
                        logger.info("Director (" + director1 + ") agreed");
                    } catch (RuntimeException e1) {
                        logger.error("SEARCH:: Transaction error! Director (" + director1 + ") did not agree.");
                    }
                }
            }


        }

        logger.info("SEARCH:: Transaction finished.");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean offer(Director director) {
        Random random = new Random();
        boolean result = random.nextInt(10) > 5;
        if (!result) {
            logger.error("OFFER:: Transaction error! Director (" + director + ") did not agree");
            throw new RuntimeException("Director (" + director + ") did not agree");
        }
        logger.error("OFFER:: Director (" + director + ") agreed.");
        return result;
    }


}
