package main.java.servlet.add;

import main.java.connection.ConnectionPool;
import main.java.dao.DescriptionDAO;
import main.java.entity.Description;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 12.10.2016.
 */
@WebServlet(name = "AddDescription", urlPatterns = "/addDescription")
public class AddDescription extends HttpServlet {
    private DescriptionDAO descriptionDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addDescription.jsp";

    private void initDAO() {
        descriptionDAO = descriptionDAO == null ? new DescriptionDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : descriptionDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = descriptionDAO.maxId() + 1;
        String title = request.getParameter("title");
        title = title.equals("") ? "defaultTitle" + id : title;

        String content = request.getParameter("content");
        content = content.equals("") ? "defaultContent" + id : content;

        Description description = new Description(id, title, content);
        descriptionDAO.add(description);

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
