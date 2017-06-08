package managedBean;

import dao.SearchDAO;
import entities.Movie;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by win10 on 14.11.2016.
 */

@ManagedBean(name = "sequelController", eager = true)
@SessionScoped
public class SequelController {

    @EJB
    private SearchDAO searchDAO;

    public void searchDirector(Movie movie) {
        searchDAO.searchDirector(movie);
    }

}
