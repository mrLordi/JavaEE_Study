package jsf.validators;

import dao.DescriptionDAO;
import entities.Description;
import org.apache.log4j.Logger;
import sun.security.krb5.internal.crypto.Des;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.List;


/**
 * Created by win10 on 08.11.2016.
 */
@FacesValidator("validators.DescriptionValidator")
public class DescriptionValidator implements Validator {

    private final static Logger LOGGER = Logger.getLogger(DescriptionValidator.class);
    private List<Description> descriptions;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String operation = (String)uiComponent.getAttributes().get("parameter");

        if (operation.equals("title")) {
            String title = o.toString();

            if (title.length() < 1 || title.length() > 100) {
                LOGGER.warn("The title must be in the range [1;100]!");
                throw new ValidatorException(new FacesMessage("The title must be in the range [1;100]!"));
            }

            descriptions = new DescriptionDAO().getAll();
            if (descriptions != null) {
                if (uiComponent.getAttributes().get("update").equals("no")) {
                    for (Description description : descriptions) {
                        if (description.getTitle().equals(title)) {
                            LOGGER.warn("The title '" + title + "' exists. The title must be unique");
                            throw new ValidatorException(new FacesMessage("The title '"
                                    + title + "' exists. The title must be unique"));
                        }
                    }
                }
            }

        } else {
            String content = o.toString();

            if (content.length() < 1) {
                LOGGER.warn("The content was missing!");
                throw new ValidatorException(new FacesMessage("The content was missing!"));
            }
        }

    }
}
