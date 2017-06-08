package main.java.servlets.update;

import main.java.dao.DescriptionDAO;
import main.java.dao.DirectorDAO;
import main.java.dao.MovieDAO;
import main.java.dao.ProducerDAO;
import main.java.entities.Description;
import main.java.entities.Director;
import main.java.entities.Movie;
import main.java.util.Helper;
import org.apache.log4j.Logger;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "UpdateMovie", urlPatterns = "/updateMovie")
public class UpdateMovie extends HttpServlet {
    private final static Logger logger = Logger.getLogger(UpdateMovie.class);
    private MovieDAO movieDAO;
    private DescriptionDAO descriptionDAO;
    private DirectorDAO directorDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateMovie.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        movieDAO = movieDAO == null ? new MovieDAO() : movieDAO;
        descriptionDAO = descriptionDAO == null ? new DescriptionDAO() : descriptionDAO;
        directorDAO = directorDAO == null ? new DirectorDAO() : directorDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieDAO.getById(id);

        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.warn("The name of movie was missing when updating");
            Helper.sendError("the name was missed", request, response);
        }

        int duration = Helper.readData(request.getParameter("duration"));
        if (duration == -1) {
            logger.warn("The wrong value of duration");
            Helper.sendError("the duration must be greater than zero", request, response);
        }

        int year = Helper.readData(request.getParameter("year"));
        if (year == -1) {
            logger.warn("The wrong value of year");
            Helper.sendError("the duration must be greater than 1888", request, response);
        }

        int descriptionId = Helper.readData(request.getParameter("descriptionId"));
        if (descriptionId == -1) {
            logger.warn("The descriptionID was missing when updating");
            Helper.sendError("the descriptionID was missed", request, response);
        }

        int directorId = Helper.readData(request.getParameter("directorId"));
        if (directorId == -1) {
            logger.warn("The directorID was missing when updating");
            Helper.sendError("the directorID was missed", request, response);
        }

        Description description = descriptionDAO.getById(descriptionId);
        if (description == null) {
            logger.warn("The description with id =" + descriptionId + " does not exist.");
            Helper.sendError("the description with id =" + descriptionId + " does not exist", request, response);
        }

        Director director = directorDAO.getById(directorId);
        if (description == null) {
            logger.warn("The director with id =" + directorId + " does not exist.");
            Helper.sendError("the director with id =" + directorId + " does not exist", request, response);
        }

        movie.setName(name);
        movie.setDuration(duration);
        movie.setYear(year);
        movie.setDescription(description);
        movie.setDirector(director);

        try {
            movieDAO.update(movie);
            logger.info("The movie(" + movie + ") was updated");
        } catch (PersistenceException e) {
            logger.error("The movie with description(" + description + ") exists. The description must be unique", e);
            Helper.sendError("The movie with this description exists. The description must be unique.", request, response);
        }

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieDAO.getById(id);
        request.setAttribute("movie", movie);

        logger.info("Form for update(movie) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}

