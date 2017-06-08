package main.java.servlet.update;

import main.java.connection.ConnectionPool;
import main.java.dao.DescriptionDAO;
import main.java.dao.MovieDAO;
import main.java.entity.Description;
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
@WebServlet(name = "UpdateDescription", urlPatterns = "/updateDescription")
public class UpdateDescription extends HttpServlet {
    private DescriptionDAO descriptionDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateDescription.jsp";

    private void initDAO() {
        descriptionDAO = descriptionDAO == null ? new DescriptionDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : descriptionDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Description description = new Description(id, title, content);
        descriptionDAO.update(description);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Description description = descriptionDAO.getById(id);
        request.setAttribute("description", description);

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
