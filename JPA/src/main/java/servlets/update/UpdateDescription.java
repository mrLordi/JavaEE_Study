package main.java.servlets.update;

import main.java.dao.DescriptionDAO;
import main.java.entities.Description;
import main.java.servlets.add.AddDescription;
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
@WebServlet(name = "UpdateDescription", urlPatterns = "/updateDescription")
public class UpdateDescription extends HttpServlet {
    private final static Logger logger = Logger.getLogger(UpdateDescription.class);
    private DescriptionDAO descriptionDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateDescription.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        descriptionDAO = descriptionDAO == null ? new DescriptionDAO() : descriptionDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Description description = descriptionDAO.getById(id);

        String title = request.getParameter("title");
        if (title.equals("")) {
            logger.warn("The title was missing when updating");
            Helper.sendError("the title was missed", request, response);
        }

        String content = request.getParameter("content");
        if (content.equals("")) {
            logger.warn("The content was missing when updating");
            Helper.sendError("content was missed", request, response);
        }

        description.setTitle(title);
        description.setContent(content);

        try {
            descriptionDAO.update(description);
            logger.info("The description(" + description + ") was updated");
        } catch (PersistenceException e) {
            logger.error("The title '" + title + "' exists. The title must be unique", e);
            Helper.sendError("The description with title '" + title + "' exists. The title must be unique.", request, response);
        }

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Description description = descriptionDAO.getById(id);
        request.setAttribute("description", description);

        logger.info("Form for update(description) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}
