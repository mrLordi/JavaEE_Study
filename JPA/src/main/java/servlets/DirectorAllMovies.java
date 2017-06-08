package main.java.servlets;

import main.java.dao.DirectorDAO;
import main.java.entities.Director;
import main.java.servlets.add.AddDirector;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 02.11.2016.
 */
@WebServlet(name = "DirectorAllMovies", urlPatterns = "/getAllMovies")
public class DirectorAllMovies extends HttpServlet {

    private final static Logger logger = Logger.getLogger(DirectorAllMovies.class);
    private DirectorDAO directorDAO;

    private final String NEXT = "/JSP/directorAllMovies.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        directorDAO = directorDAO == null ? new DirectorDAO() : directorDAO;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("movies", directorDAO.getById(id).getMovies());

        logger.info("All the movies director with id = " + id + " was displayed");
        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
