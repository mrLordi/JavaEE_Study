package jsf;

import dao.AbstractDAO;
import dao.DescriptionDAO;
import dao.DirectorDAO;
import dao.MovieDAO;
import entities.Director;
import entities.Movie;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by win10 on 07.11.2016.
 */

@ManagedBean(name = "movieController", eager = true)
@SessionScoped
public class MovieController {

    private final static Logger logger = Logger.getLogger(MovieController.class);
    private AbstractDAO<Movie> dao;
    private Movie movie;
    private int descriptionId;
    private int directorId;

    public MovieController() {
        dao = new MovieDAO();
    }

    public List<Movie> getAll() {
        return dao.getAll();
    }

    public String update() {
        movie.setDescription(new DescriptionDAO().getById(descriptionId));
        movie.setDirector(new DirectorDAO().getById(directorId));
        dao.update(movie);
        return "index?faces-redirect=true";
    }

    public String goToAdd() {
        movie = new Movie();
        descriptionId = directorId = 0;
        return "addMovie";
    }

    public String add() {
        movie.setDescription(new DescriptionDAO().getById(descriptionId));
        movie.setDirector(new DirectorDAO().getById(directorId));
        dao.add(movie);
        return "index?faces-redirect=true";
    }

    public String delete(Movie movie) {
        dao.delete(movie);
        return "index?faces-redirect=true";
    }

    public String goToUpdate(Movie movie) {
        descriptionId = movie.getDescription().getDescriptionId();
        directorId = movie.getDirector().getDirectorId();
        this.movie = movie;
        return "updateMovie";
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }
}
