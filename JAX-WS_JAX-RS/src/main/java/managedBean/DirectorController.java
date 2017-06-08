package managedBean;

import org.apache.log4j.Logger;
import wsClient.Director;
import wsClient.DirectorWS;
import wsClient.DirectorWSImpImplementationService;

import javax.annotation.PostConstruct;
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

    private DirectorWS dao;
    private Director director;

    @PostConstruct
    public void init() {
        DirectorWSImpImplementationService directorWSImpImplementationService
                = new DirectorWSImpImplementationService();
        dao = directorWSImpImplementationService.getDirectorWSImpImplementationPort();
    }

    public List<Director> getAll() {
        return dao.getAllDirectors();
    }

    public String update() {
        dao.updateDirector(director);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        director = new Director();
        return "JSF/add/addDirector";
    }

    public String add() {
        dao.addDirector(director);
        return "/index?faces-redirect=true";
    }

    public String delete(Director director) {
        dao.deleteDirector(director);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Director director) {
        this.director = director;
        return "JSF/update/updateDirector";
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
