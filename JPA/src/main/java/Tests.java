package main.java;

import main.java.dao.DescriptionDAO;
import main.java.dao.DirectorDAO;
import main.java.dao.MovieDAO;
import main.java.dao.ProducerDAO;
import main.java.entities.Description;
import main.java.entities.Director;
import main.java.entities.Movie;
import main.java.entities.Producer;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by win10 on 29.10.2016.
 */
public class Tests {
    private final static Logger logger = Logger.getLogger(Tests.class);
    public static void main(String[] args) {
        logger.info("Form for add(description) was displayed");
        MovieDAO movieDAO = new MovieDAO();
//
//       movieDAO.getById(4).addProducer(new Producer("test", "test", "test"));

        Movie movie = movieDAO.getById(9);
//        movieDAO.delete(movie);
//        movie.removeProducer(producer);
//        movie.removeProducer(3);

        movie.addProducer(new Producer("new2", "new1", "new3"));

//        movie.setProducers(new HashSet<>(Arrays.asList(new Producer("123", "234", "345"), new Producer("qwe", "sad", "zxv"))));
        movie.setDescription(new Description("12asfasf3", "1asasf23"));
        movie.setDirector(new Director("1233afasf", "asasf"));
        movieDAO.update(movie);

//        DescriptionDAO descriptionDAO = new DescriptionDAO();
//        descriptionDAO.deleteById(1);
    }

}
