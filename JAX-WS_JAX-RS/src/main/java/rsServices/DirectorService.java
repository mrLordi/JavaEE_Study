package rsServices;

import dao.DirectorDAO;
import entities.Director;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by win10 on 21.12.2016.
 */
@Path("/director")
public class DirectorService {

    @EJB
    private DirectorDAO directorDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Director> getDirectors() {
        return  directorDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Director getDirector(@PathParam("id") int id) {
        return directorDAO.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDirector(Director director) {
        directorDAO.update(director);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDirector(@PathParam("id") int id) {
        directorDAO.deleteById(id);
    }

}
