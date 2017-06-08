package managedBean;

import dao.MovieDAO;
import dao.ProducerDAO;
import entities.Movie;
import entities.Producer;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by win10 on 08.11.2016.
 */
@ManagedBean(name = "MPController", eager = true)
@SessionScoped
public class MPController {
    protected final static Logger LOGGER = Logger.getLogger(MPController.class);

    @EJB
    private MovieDAO movieDAO;

    @EJB
    private ProducerDAO producerDAO;

    private String movieIdStr;
    private String producerIdStr;

    public String goToAdd() {
        movieIdStr = producerIdStr = null;
        return "JSF/add/addMP";
    }

    public String delete(Movie movie, Producer producer){
        movie.removeProducer(producer);
        movieDAO.update(movie);
        return "/index?faces-redirect=true";
    }

    public String add() {
        Movie movie = movieDAO.getById(Integer.parseInt(movieIdStr));
        Producer producer = producerDAO.getById(Integer.parseInt(producerIdStr));
        movie.addProducer(producer);
        movieDAO.update(movie);
        return "/index?faces-redirect=true";
    }

    public String getMovieIdStr() {
        return movieIdStr;
    }

    public void setMovieIdStr(String movieIdStr) {
        this.movieIdStr = movieIdStr;
    }

    public String getProducerIdStr() {
        return producerIdStr;
    }

    public void setProducerIdStr(String producerIdStr) {
        this.producerIdStr = producerIdStr;
    }
}
