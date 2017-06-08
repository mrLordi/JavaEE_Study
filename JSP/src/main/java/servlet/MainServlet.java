package main.java.servlet;

import main.java.connection.ConnectionPool;
import main.java.dao.DescriptionDAO;
import main.java.dao.DirectorDAO;
import main.java.dao.MovieDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by win10 on 11.10.2016.
 */
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    private MovieDAO movieDAO;
    private DescriptionDAO descriptionDAO;
    private DirectorDAO directorDAO;

    private final String NEXT = "JSP/main.jsp";

    private ConnectionPool connectionPool;

    private void initDAO() {
        connectionPool = connectionPool == null ? ConnectionPool.getInstance(5, getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties")) : connectionPool;

        movieDAO = movieDAO == null ? new MovieDAO(connectionPool) : movieDAO;
        descriptionDAO = descriptionDAO == null ? new DescriptionDAO(connectionPool) : descriptionDAO;
        directorDAO = directorDAO == null ? new DirectorDAO(connectionPool) : directorDAO;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        request.setAttribute("movies", movieDAO.getAll());
        request.setAttribute("descriptors", descriptionDAO.getAll());
        request.setAttribute("directors", directorDAO.getAll());

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
