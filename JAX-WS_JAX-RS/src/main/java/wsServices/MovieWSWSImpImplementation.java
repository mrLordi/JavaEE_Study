package wsServices;

import dao.MovieDAO;
import entities.Movie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@Stateless
@WebService(endpointInterface = "wsServices.MovieWS")
public class MovieWSWSImpImplementation implements MovieWS{

    @EJB
    private MovieDAO movieDAO;

    @Override
    public Movie getMovieById(int id) {
        return movieDAO.getById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAll();
    }

    @Override
    public void addMovie(Movie movie) {
        movieDAO.add(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDAO.update(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieDAO.delete(movie);
    }

    @Override
    public void deleteMovieById(int id) {
        movieDAO.deleteById(id);
    }

}
