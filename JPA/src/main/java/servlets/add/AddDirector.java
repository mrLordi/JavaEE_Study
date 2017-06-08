package main.java.servlets.add;

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
@WebServlet(name = "AddDirector", urlPatterns = "/addDirector")
public class AddDirector extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddDirector.class);
    private DirectorDAO directorDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addDirector.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        directorDAO = directorDAO == null ? new DirectorDAO() : directorDAO;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.warn("The name of director was missing when adding");
            Helper.sendError("the name was missed", request, response);
        }

        String surname = request.getParameter("surname");
        if (surname.equals("")) {
            logger.warn("The surname of director was missing when adding");
            Helper.sendError("the surname was missed", request, response);
        }

        Director director = new Director(name, surname);
        directorDAO.add(director);
        logger.info("The director(" + director + ") was added");

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Form for add(director) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}

