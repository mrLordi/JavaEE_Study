package managedBean.validators;

import org.apache.log4j.Logger;
import wsClient.*;

import javax.annotation.PostConstruct;
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
public class MPValidator implements Validator {
    private final static Logger LOGGER = Logger.getLogger(MPValidator.class);

    private MovieWS movieDAO;
    private ProducerWS producerDAO;

    @PostConstruct
    public void init() {
        MovieWSWSImpImplementationService movieWSWSImpImplementationService = new MovieWSWSImpImplementationService();
        movieDAO = movieWSWSImpImplementationService.getMovieWSWSImpImplementationPort();

        ProducerWSImpImplementationService producerWSImpImplementationService = new ProducerWSImpImplementationService();
        producerDAO = producerWSImpImplementationService.getProducerWSImpImplementationPort();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (uiComponent.getAttributes().get("parameter").equals("movieId")) {
            String movieIdStr = o.toString();
            int movieId = check(movieIdStr, "movieId");

            Movie movie = movieDAO.getMovieById(movieId);
            if (movie == null) {
                LOGGER.warn("The movie with id =" + movieId + " does not exist.");
                throw new ValidatorException(new FacesMessage("the movie with id =" + movieId + " does not exist"));
            }
        } else {
            String producerIdStr = o.toString();
            int producerId = check(producerIdStr, "producerId");

            Producer producer = producerDAO.getProducerById(producerId);
            if (producer == null) {
                LOGGER.warn("The producer with id =" + producerId + " does not exist.");
                throw new ValidatorException(new FacesMessage("the producer with id =" + producerId + " does not exist"));
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
