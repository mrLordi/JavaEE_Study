package main.java.servlets;

import main.java.dao.*;
import main.java.entities.Description;
import main.java.entities.Director;
import main.java.entities.Movie;
import main.java.entities.Producer;
import main.java.servlets.update.UpdateDescription;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 30.10.2016.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    private final static Logger logger = Logger.getLogger(MainServlet.class);

    private AbstractDAO<Movie> movieDAO;
    private AbstractDAO<Description> descriptionDAO;
    private AbstractDAO<Director> directorDAO;
    private AbstractDAO<Producer> producerDAO;

    private final String NEXT = "JSP/main.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        movieDAO = movieDAO == null ? new MovieDAO() : movieDAO;
        descriptionDAO = descriptionDAO == null ? new DescriptionDAO() : descriptionDAO;
        directorDAO = directorDAO == null ? new DirectorDAO() : directorDAO;
        producerDAO = producerDAO == null ? new ProducerDAO() : producerDAO;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", movieDAO.getAll());
        request.setAttribute("descriptors", descriptionDAO.getAll());
        request.setAttribute("directors", directorDAO.getAll());
        request.setAttribute("producers", producerDAO.getAll());

        logger.info("DataBase was displayed");
        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
