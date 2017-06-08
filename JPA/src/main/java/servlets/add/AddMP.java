package main.java.servlets.add;

import main.java.dao.MovieDAO;
import main.java.dao.ProducerDAO;
import main.java.entities.Description;
import main.java.entities.Director;
import main.java.entities.Movie;
import main.java.entities.Producer;
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
@WebServlet(name = "AddMP", urlPatterns = "/addMP")
public class AddMP extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddMP.class);

    private MovieDAO movieDAO;
    private ProducerDAO producerDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addMP.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        movieDAO = movieDAO == null ? new MovieDAO() : movieDAO;
        producerDAO = producerDAO == null ? new ProducerDAO() : producerDAO;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int movieId = Helper.readData(request.getParameter("movieId"));
        if (movieId == -1) {
            logger.warn("The movieID was missing when adding");
            Helper.sendError("the movieId was missed", request, response);
        }

        int producerId = Helper.readData(request.getParameter("producerId"));
        if (producerId == -1) {
            logger.warn("The producerID was missing when adding");
            Helper.sendError("the producerId was missed", request, response);
        }

        Movie movie = movieDAO.getById(movieId);
        if (movie == null) {
            logger.warn("The movie with id " + movieId + " does not exist");
            Helper.sendError("the movie does not exist", request, response);
        }

        Producer producer = producerDAO.getById(producerId);
        if (producer == null) {
            logger.warn("The producer with id " + producerId + " does not exist");
            Helper.sendError("the producer does not exist", request, response);
        }

        if (movie.getProducers().contains(producer)) {
            logger.warn("The connection with producer(id = " + producerId + ") and movie(id = "
                    + movieId + ") already exists");
            Helper.sendError("the connection exists", request, response);
        }

        movie.addProducer(producer);
        movieDAO.update(movie);
        logger.info("The connection with producer(id = " + producerId + ") and movie(id = "
                + movieId + ") was added");

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Form for add(movie - producer) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
