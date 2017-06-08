package main.java.servlet.update;

import main.java.connection.ConnectionPool;
import main.java.dao.DescriptionDAO;
import main.java.dao.MovieDAO;
import main.java.entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 12.10.2016.
 */
@WebServlet(name = "UpdateMovie", urlPatterns = "/updateMovie")
public class UpdateMovie extends HttpServlet {
    private MovieDAO movieDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateMovie.jsp";

    private void initDAO() {
        movieDAO = movieDAO == null ? new MovieDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : movieDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int year = Integer.parseInt(request.getParameter("year"));
        int descriptionId = Integer.parseInt(request.getParameter("descriptionId"));
        int directorId = Integer.parseInt(request.getParameter("directorId"));

        Movie movie = new Movie(id, name, duration, year, descriptionId, directorId);
        movieDAO.update(movie);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieDAO.getById(id);
        request.setAttribute("movie", movie);

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
