package managedBean;

import org.apache.log4j.Logger;
import wsClient.Description;
import wsClient.DescriptionWS;
import wsClient.DescriptionWSImpImplementationService;

import javax.annotation.PostConstruct;
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

    private DescriptionWS dao;
    private Description description;

    @PostConstruct
    public void init() {
        DescriptionWSImpImplementationService descriptionWSImpImplementationService
                = new DescriptionWSImpImplementationService();
        dao = descriptionWSImpImplementationService.getDescriptionWSImpImplementationPort();
    }

    public List<Description> getAll() {
        return dao.getAllDescriptions();
    }

    public String update() {
        dao.updateDescription(description);
        return "/index?faces-redirect=true";
    }

    public String goToAdd() {
        description = new Description();
        return "JSF/add/addDescription";
    }

    public String add() {
        dao.addDescription(description);
        return "/index?faces-redirect=true";
    }

    public String delete(Description description) {
        dao.deleteDescription(description);
        return "/index?faces-redirect=true";
    }

    public String goToUpdate(Description description) {
        this.description = description;
        return "/JSF/update/updateDescription";
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}

