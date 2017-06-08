package managedBean.validators;

import org.apache.log4j.Logger;

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
public class ProducerValidator implements Validator {

    private final static Logger LOGGER = Logger.getLogger(ProducerValidator.class);

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String operation = (String) uiComponent.getAttributes().get("parameter");

        String name = o.toString();

        if (name.length() < 1 || name.length() > 45) {
            if (operation.equals("name")) {
                LOGGER.warn("The name must be in the range [1;45]!");
                throw new ValidatorException(new FacesMessage("The name must be in the range [1;45]!"));
            } else if (operation.equals("surname")){
                LOGGER.warn("The surname must be in the range [1;45]!");
                throw new ValidatorException(new FacesMessage("The surname must be in the range [1;45]!"));
            } else {
                LOGGER.warn("The type must be in the range [1;45]!");
                throw new ValidatorException(new FacesMessage("The type must be in the range [1;45]!"));
            }
        }

    }

}
