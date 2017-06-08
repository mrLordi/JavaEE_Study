package main.java.servlet.add;

import main.java.connection.ConnectionPool;
import main.java.dao.DirectorDAO;
import main.java.entity.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 12.10.2016.
 */
@WebServlet(name = "AddDirector", urlPatterns = "/addDirector")
public class AddDirector extends HttpServlet {
    private DirectorDAO directorDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addDirector.jsp";

    private void initDAO() {
        directorDAO = directorDAO == null ? new DirectorDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : directorDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        name = name.equals("") ? "defaultName" : name;

        String surname = request.getParameter("surname");
        surname = surname.equals("") ? "defaultSurname" : surname;

        Director director = new Director(directorDAO.maxId() + 1, name, surname);
        directorDAO.add(director);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
