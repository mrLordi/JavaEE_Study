package wsServices;

import entities.Director;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@WebService
public interface DirectorWS {

    @WebMethod
    Director getDirectorById(int id);

    @WebMethod
    List<Director> getAllDirectors();

    @WebMethod
    void addDirector(Director director);

    @WebMethod
    void updateDirector(Director director);

    @WebMethod
    void deleteDirector(Director director);

    @WebMethod
    void deleteDirectorById(int id);

}
