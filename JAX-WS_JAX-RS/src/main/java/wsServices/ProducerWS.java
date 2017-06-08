package wsServices;

import entities.Producer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@WebService
public interface ProducerWS {

    @WebMethod
    Producer getProducerById(int id);

    @WebMethod
    List<Producer> getAllProducers();

    @WebMethod
    void addProducer(Producer producer);

    @WebMethod
    void updateProducer(Producer producer);

    @WebMethod
    void deleteProducer(Producer producer);

    @WebMethod
    void deleteProducerById(int id);

}
