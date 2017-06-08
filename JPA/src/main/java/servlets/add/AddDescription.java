package main.java.servlets.add;

import main.java.dao.DescriptionDAO;
import main.java.entities.Description;
import main.java.util.Helper;
import org.apache.log4j.Logger;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "AddDescription", urlPatterns = "/addDescription")
public class AddDescription extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddDescription.class);
    private DescriptionDAO descriptionDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addDescription.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        descriptionDAO = descriptionDAO == null ? new DescriptionDAO() : descriptionDAO;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        if (title.equals("")) {
            logger.warn("The title was missing when adding");
            Helper.sendError("the title was missed", request, response);
        }

        String content = request.getParameter("content");
        if (content.equals("")) {
            logger.warn("The content was missing when adding");
            Helper.sendError("content was missed", request, response);
        }

        Description description = new Description(title, content);

        try {
            descriptionDAO.add(description);
            logger.info("The description(" + description + ") was added");
        } catch (PersistenceException e) {
            logger.error("The title '" + title + "' exists. The title must be unique", e);
            Helper.sendError("The title '" + title + "' exists. The title must be unique", request, response);
        }

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Form for add(description) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
