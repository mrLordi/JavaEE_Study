package wsServices;

import dao.ProducerDAO;
import entities.Producer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@Stateless
@WebService(endpointInterface = "wsServices.ProducerWS")
public class ProducerWSImpImplementation implements ProducerWS{

    @EJB
    private ProducerDAO producerDAO;

    @Override
    public Producer getProducerById(int id) {
        return producerDAO.getById(id);
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerDAO.getAll();
    }

    @Override
    public void addProducer(Producer producer) {
        producerDAO.add(producer);
    }

    @Override
    public void updateProducer(Producer producer) {
        producerDAO.update(producer);
    }

    @Override
    public void deleteProducer(Producer producer) {
        producerDAO.delete(producer);
    }

    @Override
    public void deleteProducerById(int id) {
        producerDAO.deleteById(id);
    }

}
