package jsf;

import dao.AbstractDAO;
import dao.MovieDAO;
import dao.ProducerDAO;
import entities.Movie;
import entities.Producer;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by win10 on 08.11.2016.
 */
@ManagedBean(name = "MPController", eager = true)
@SessionScoped
public class MPController {
    protected final static Logger LOGGER = Logger.getLogger(MPController.class);
    private AbstractDAO<Movie> movieDAO;
    private AbstractDAO<Producer> producerDAO;
    private int movieId;
    private int producerId;

    public MPController() {
        movieDAO = new MovieDAO();
        producerDAO = new ProducerDAO();
    }

    public String goToAdd() {
        movieId = 0;
        producerId = 0;
        return "addMP";
    }

    public String delete(Movie movie, Producer producer){
        movie.removeProducer(producer);
        movieDAO.update(movie);
        return "index?faces-redirect=true";
    }

    public String add() {
        Movie movie = movieDAO.getById(movieId);
        Producer producer = producerDAO.getById(producerId);
        movie.addProducer(producer);
        movieDAO.update(movie);
        return "index?faces-redirect=true";
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }
}
