package main.java.servlet.update;

import main.java.connection.ConnectionPool;
import main.java.dao.DirectorDAO;
import main.java.dao.MovieDAO;
import main.java.entity.Director;
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
@WebServlet(name = "UpdateDirector", urlPatterns = "/updateDirector")
public class UpdateDirector extends HttpServlet {
    private DirectorDAO directorDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateDirector.jsp";

    private void initDAO() {
        directorDAO = directorDAO == null ? new DirectorDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : directorDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        Director director = new Director(id, name, surname);
        directorDAO.update(director);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Director director = directorDAO.getById(id);
        request.setAttribute("director", director);

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
