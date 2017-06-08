package jsf;

import dao.AbstractDAO;
import dao.DescriptionDAO;
import entities.Description;
import entities.Movie;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by win10 on 07.11.2016.
 */
@ManagedBean(name = "descriptionController", eager = true)
@SessionScoped
public class DescriptionController {

    private final static Logger logger = Logger.getLogger(DescriptionController.class);

    @EJB
    private DescriptionDAO dao;
    private Description description;

    public List<Description> getAll() {
        return dao.getAll();
    }

    public String update() {
        dao.update(description);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        description = new Description();
        return "JSF/secured/add/addDescription";
    }

    public String add() {
        dao.add(description);
        return "/index?faces-redirect=true";
    }

    public String delete(Description description) {
        dao.delete(description);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Description description) {
        this.description = description;
        return "/JSF/secured/update/updateDescription";
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}

