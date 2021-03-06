package jsf;

import dao.ProducerDAO;
import entities.Producer;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
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

    @EJB
    private ProducerDAO dao;

    private Producer producer;

    public List<Producer> getAll() {
        return dao.getAll();
    }

    public String update() {
        dao.update(producer);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        producer = new Producer();
        return "JSF/add/addProducer";
    }

    public String add() {
        dao.add(producer);
        return "/index?faces-redirect=true";
    }

    public String delete(Producer producer) {
        dao.delete(producer);
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

