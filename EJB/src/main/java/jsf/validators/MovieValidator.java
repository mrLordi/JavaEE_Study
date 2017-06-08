package jsf.validators;

import dao.DescriptionDAO;
import dao.DirectorDAO;
import entities.Description;
import entities.Director;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by win10 on 08.11.2016.
 */
@ManagedBean
@RequestScoped
public class MovieValidator implements Validator {

    private final static Logger LOGGER = Logger.getLogger(MovieValidator.class);

    @EJB
    private DescriptionDAO descriptionDAO;

    @EJB
    private DirectorDAO directorDAO;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String parameter = (String)uiComponent.getAttributes().get("parameter");

        if (parameter.equals("name")) {
            String name = o.toString();

            if (name.length() < 1 || name.length() > 100) {
                LOGGER.warn("The name must be in the range [1;100]!");
                throw new ValidatorException(new FacesMessage("The name must be in the range [1;100]!"));
            }
        } else if (parameter.equals("duration")) {
            String durationStr = o.toString();
            check(durationStr, "duration");
        } else if (parameter.equals("year")) {
            String yearStr = o.toString();
            check(yearStr, "year");
        } else if (parameter.equals("descriptionId")) {
            String descriptionStr = o.toString();
            int descriptionId = check(descriptionStr, "descriptionId");

            Description description = descriptionDAO.getById(descriptionId);
            if (description == null) {
                LOGGER.warn("The description with id =" + descriptionId + " does not exist.");
                throw new ValidatorException(new FacesMessage("the description with id =" + descriptionId + " does not exist"));
            }
        } else if (parameter.equals("directorId")) {
            String directorStr = o.toString();
            int directorId = check(directorStr, "descriptionId");

            Director director = directorDAO.getById(directorId);
            if (director == null) {
                LOGGER.warn("The director with id =" + directorId + " does not exist.");
                throw new ValidatorException(new FacesMessage("the director with id =" + directorId + " does not exist"));
            }
        }

    }

    private int  check(String parameter, String name) {
        int number;
        try {
            number = Integer.parseInt(parameter);
        } catch (Exception e) {
            LOGGER.warn("The wrong value of " + name + "!", e);
            throw new ValidatorException(new FacesMessage("The wrong value of " + name + "!"));
        }
        if (number < 1) {
            LOGGER.warn("The wrong value of " + name + "!");
            throw new ValidatorException(new FacesMessage("The wrong value of " + name + "!"));
        }

        return number;
    }
}

