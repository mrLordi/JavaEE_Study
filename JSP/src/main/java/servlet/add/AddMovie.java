package main.java.servlet.add;

import main.java.connection.ConnectionPool;
import main.java.dao.DirectorDAO;
import main.java.dao.MovieDAO;
import main.java.entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 12.10.2016.
 */
@WebServlet(name = "AddMovie", urlPatterns = "/addMovie")
public class AddMovie extends HttpServlet {
    private MovieDAO movieDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addMovie.jsp";

    private void initDAO() {
        movieDAO = movieDAO == null ? new MovieDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : movieDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        name = name.equals("") ? "defaultName" : name;

        int id = movieDAO.maxId() + 1;

        int duration = readData(request.getParameter("duration"), 7200);
        int year = readData(request.getParameter("year"), 2016);

        int descriptionId =  readData(request.getParameter("descriptionId"),
                new DirectorDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))).maxId());


        int directorId =  readData(request.getParameter("directorId"),
                new DirectorDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))).maxId());

        Movie movie = new Movie(id, name, duration, year, descriptionId, directorId);
        movieDAO.add(movie);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        request.getRequestDispatcher(NEXT).forward(request, response);
    }

    private int readData(String s, int expected) {
        int result;
        if (s.equals("")) {
            result = expected;
        } else {
            result = Integer.parseInt(s);
        }
        result = result <= 0 ? expected : result;
        return result;
    }
}
