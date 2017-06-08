package rsServices;

import dao.DescriptionDAO;
import entities.Description;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by win10 on 21.12.2016.
 */

@Path("/description")
public class DescriptionService {

    @EJB
    private DescriptionDAO descriptionDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Description> getDescriptions() {
        return  descriptionDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Description getDescription(@PathParam("id") int id) {
        return descriptionDAO.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDescription(Description description) {
        descriptionDAO.update(description);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDescription(@PathParam("id") int id) {
        descriptionDAO.deleteById(id);
    }

}
