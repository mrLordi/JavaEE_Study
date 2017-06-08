package managedBean;

import org.apache.log4j.Logger;
import wsClient.*;

import javax.annotation.PostConstruct;
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

    private MovieWS dao;

    private DescriptionWS descriptionDAO;

    private DirectorWS directorDAO;

    @PostConstruct
    public void init() {
        DescriptionWSImpImplementationService descriptionWSImpImplementationService
                = new DescriptionWSImpImplementationService();
        descriptionDAO = descriptionWSImpImplementationService.getDescriptionWSImpImplementationPort();

        DirectorWSImpImplementationService directorWSImpImplementationService
                = new DirectorWSImpImplementationService();
        directorDAO = directorWSImpImplementationService.getDirectorWSImpImplementationPort();

        MovieWSWSImpImplementationService movieWSWSImpImplementationService
                = new MovieWSWSImpImplementationService();
        dao = movieWSWSImpImplementationService.getMovieWSWSImpImplementationPort();
    }

    private Movie movie;

    private String durationStr;
    private String yearStr;

    private String descriptionIdStr;
    private String directorIdStr;

    public List<Movie> getAll() {
        return dao.getAllMovies();
    }

    public String update() {
        movie.setYear(Integer.parseInt(yearStr));
        movie.setDuration(Integer.parseInt(durationStr));

        movie.setDescription(descriptionDAO.getDescriptionById(Integer.parseInt(descriptionIdStr)));
        movie.setDirector(directorDAO.getDirectorById(Integer.parseInt(directorIdStr)));
        dao.updateMovie(movie);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        movie = new Movie();
        yearStr = durationStr = descriptionIdStr = directorIdStr = null;
        return "JSF/add/addMovie";
    }

    public String add() {
        movie.setYear(Integer.parseInt(yearStr));
        movie.setDuration(Integer.parseInt(durationStr));

        movie.setDescription(descriptionDAO.getDescriptionById(Integer.parseInt(descriptionIdStr)));
        movie.setDirector(directorDAO.getDirectorById(Integer.parseInt(directorIdStr)));
        dao.addMovie(movie);
        return "/index?faces-redirect=true";
    }

    public String delete(Movie movie) {
        dao.deleteMovie(movie);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Movie movie) {
        yearStr = "" + movie.getYear();
        durationStr = "" + movie.getDuration();
        descriptionIdStr = "" + movie.getDescription().getDescriptionId();
        directorIdStr = "" + movie.getDirector().getDirectorId();
        this.movie = movie;
        return "JSF/update/updateMovie";
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDescriptionIdStr() {
        return descriptionIdStr;
    }

    public void setDescriptionIdStr(String descriptionIdStr) {
        this.descriptionIdStr = descriptionIdStr;
    }

    public String getDirectorIdStr() {
        return directorIdStr;
    }

    public void setDirectorIdStr(String directorIdStr) {
        this.directorIdStr = directorIdStr;
    }

    public String getDurationStr() {
        return durationStr;
    }

    public void setDurationStr(String durationStr) {
        this.durationStr = durationStr;
    }

    public String getYearStr() {
        return yearStr;
    }

    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }
}
