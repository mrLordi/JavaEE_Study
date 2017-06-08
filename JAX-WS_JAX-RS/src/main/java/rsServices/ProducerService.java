package rsServices;

import dao.ProducerDAO;
import entities.Producer;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by win10 on 21.12.2016.
 */

@Path("/producer")
public class ProducerService {

    @EJB
    private ProducerDAO producerDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producer> getProducers() {
        return  producerDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("id") int id) {
        return producerDAO.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProducer(Producer producer) {
        producerDAO.update(producer);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteProducer(@PathParam("id") int id) {
        producerDAO.deleteById(id);
    }

}
