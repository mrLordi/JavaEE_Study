package wsServices;

import entities.Movie;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@WebService
public interface MovieWS {

    @WebMethod
    Movie getMovieById(int id);

    @WebMethod
    List<Movie> getAllMovies();

    @WebMethod
    void addMovie(Movie movie);

    @WebMethod
    void updateMovie(Movie movie);

    @WebMethod
    void deleteMovie(Movie movie);

    @WebMethod
    void deleteMovieById(int id);

}
