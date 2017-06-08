package wsServices;

import entities.Description;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@WebService
public interface DescriptionWS {

    @WebMethod
    Description getDescriptionById(int id);

    @WebMethod
    List<Description> getAllDescriptions();

    @WebMethod
    void addDescription(Description description);

    @WebMethod
    void updateDescription(Description description);

    @WebMethod
    void deleteDescription(Description description);

    @WebMethod
    void deleteDescriptionById(int id);
}
