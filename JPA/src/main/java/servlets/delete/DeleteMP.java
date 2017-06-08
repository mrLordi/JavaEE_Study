package main.java.servlets.delete;

import main.java.dao.AbstractDAO;
import main.java.dao.MovieDAO;
import main.java.entities.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "DeleteMP", urlPatterns = "/deleteMP")
public class DeleteMP extends HttpServlet {

    protected MovieDAO movieDAO;
    private final String NEXT = "/main";

    public void init() throws ServletException {
        super.init();

        movieDAO = movieDAO == null ? new MovieDAO() : movieDAO;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int producerId = Integer.parseInt(request.getParameter("producerId"));

        Movie movie = movieDAO.getById(movieId);
        movie.removeProducer(producerId);
        movieDAO.update(movie);

        response.sendRedirect(request.getContextPath() + NEXT);
    }
}
