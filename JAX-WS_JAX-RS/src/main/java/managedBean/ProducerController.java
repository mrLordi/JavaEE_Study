package managedBean;

import org.apache.log4j.Logger;
import wsClient.Producer;
import wsClient.ProducerWS;
import wsClient.ProducerWSImpImplementationService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by win10 on 08.11.2016.
 */
@ManagedBean(name = "producerController", eager = true)
@SessionScoped
public class ProducerController {

    private final static Logger logger = Logger.getLogger(ProducerController.class);

    private ProducerWS dao;

    @PostConstruct
    public void init() {
        ProducerWSImpImplementationService producerWSImpImplementationService = new ProducerWSImpImplementationService();
        dao = producerWSImpImplementationService.getProducerWSImpImplementationPort();
    }

    private Producer producer;

    public List<Producer> getAll() {
        return dao.getAllProducers();
    }

    public String update() {
        dao.updateProducer(producer);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        producer = new Producer();
        return "JSF/add/addProducer";
    }

    public String add() {
        dao.addProducer(producer);
        return "/index?faces-redirect=true";
    }

    public String delete(Producer producer) {
        dao.deleteProducer(producer);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Producer producer) {
        this.producer = producer;
        return "JSF/update/updateProducer";
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

}

