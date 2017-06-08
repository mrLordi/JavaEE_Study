package main.java.servlets.update;

import main.java.dao.DescriptionDAO;
import main.java.dao.DirectorDAO;
import main.java.entities.Director;
import main.java.util.Helper;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "UpdateDirector", urlPatterns = "/updateDirector")
public class UpdateDirector extends HttpServlet {
    private final static Logger logger = Logger.getLogger(UpdateDirector.class);
    private DirectorDAO directorDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateDirector.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        directorDAO = directorDAO == null ? new DirectorDAO() : directorDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Director director = directorDAO.getById(id);

        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.warn("The name of director was missing when updating");
            Helper.sendError("the name was missed", request, response);
        }

        String surname = request.getParameter("surname");
        if (surname.equals("")) {
            logger.warn("The surname of director was missing when updating");
            Helper.sendError("the surname was missed", request, response);
        }

        director.setName(name);
        director.setSurname(surname);

        directorDAO.update(director);
        logger.info("The director(" + director + ") was updated");

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Director director = directorDAO.getById(id);
        request.setAttribute("director", director);

        logger.info("Form for update(director) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}