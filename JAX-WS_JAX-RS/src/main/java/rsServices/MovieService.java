package rsServices;

import dao.MovieDAO;
import entities.Movie;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by win10 on 21.12.2016.
 */

@Path("/movie")
public class MovieService {

    @EJB
    private MovieDAO movieDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        return  movieDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovie(@PathParam("id") int id) {
        return movieDAO.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMovie(Movie movie) {
        movieDAO.update(movie);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMovie(@PathParam("id") int id) {
        movieDAO.deleteById(id);
    }

}
