package jsf;

import dao.AbstractDAO;
import dao.DescriptionDAO;
import dao.DirectorDAO;
import entities.Description;
import entities.Director;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by win10 on 08.11.2016.
 */
@ManagedBean(name = "directorController", eager = true)
@SessionScoped
public class DirectorController {

    private final static Logger logger = Logger.getLogger(DirectorController.class);

    @EJB
    private DirectorDAO dao;
    private Director director;

    public List<Director> getAll() {
        return dao.getAll();
    }

    public String update() {
        dao.update(director);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        director = new Director();
        return "JSF//securedadd/addDirector";
    }

    public String add() {
        dao.add(director);
        return "/index?faces-redirect=true";
    }

    public String delete(Director director) {
        dao.delete(director);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Director director) {
        this.director = director;
        return "JSF/secured/update/updateDirector";
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
