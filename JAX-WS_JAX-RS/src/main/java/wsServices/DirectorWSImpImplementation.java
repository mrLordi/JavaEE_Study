package wsServices;

import dao.DirectorDAO;
import entities.Director;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by win10 on 20.12.2016.
 */

@Stateless
@WebService(endpointInterface = "wsServices.DirectorWS")
public class DirectorWSImpImplementation implements DirectorWS{

    @EJB
    private DirectorDAO directorDAO;

    @Override
    public Director getDirectorById(int id) {
        return directorDAO.getById(id);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorDAO.getAll();
    }

    @Override
    public void addDirector(Director director) {
        directorDAO.add(director);
    }

    @Override
    public void updateDirector(Director director) {
        directorDAO.update(director);
    }

    @Override
    public void deleteDirector(Director director) {
        directorDAO.delete(director);
    }

    @Override
    public void deleteDirectorById(int id) {
        directorDAO.deleteById(id);
    }

}
