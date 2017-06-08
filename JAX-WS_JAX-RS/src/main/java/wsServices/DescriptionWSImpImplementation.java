package wsServices;

import dao.DescriptionDAO;
import entities.Description;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "wsServices.DescriptionWS")
public class DescriptionWSImpImplementation implements DescriptionWS {

    @EJB private DescriptionDAO descriptionDAO;

    @Override
    public Description getDescriptionById(int id) {
        return descriptionDAO.getById(id);
    }

    @Override
    public List<Description> getAllDescriptions() {
        return descriptionDAO.getAll();
    }

    @Override
    public void addDescription(Description description) {
        descriptionDAO.add(description);
    }

    @Override
    public void updateDescription(Description description) {
        descriptionDAO.update(description);
    }

    @Override
    public void deleteDescription(Description description) {
        descriptionDAO.delete(description);
    }

    @Override
    public void deleteDescriptionById(int id) {
        descriptionDAO.deleteById(id);
    }
}
