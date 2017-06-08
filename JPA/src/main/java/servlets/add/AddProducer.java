package main.java.servlets.add;

import main.java.dao.DirectorDAO;
import main.java.dao.ProducerDAO;
import main.java.entities.Director;
import main.java.entities.Producer;
import main.java.util.Helper;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "AddProducer", urlPatterns = "/addProducer")
public class AddProducer extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddProducer.class);

    private ProducerDAO producerDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/add/addProducer.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        producerDAO = producerDAO == null ? new ProducerDAO() : producerDAO;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.warn("The name was missing when adding");
            Helper.sendError("the name was missed", request, response);
        }

        String surname = request.getParameter("surname");
        if (surname.equals("")) {
            logger.warn("The surname was missing when adding");
            Helper.sendError("the surname was missed", request, response);
        }

        String type = request.getParameter("type");
        if (type.equals("")) {
            logger.warn("The type was missing when adding");
            Helper.sendError("the type was missed", request, response);
        }

        Producer producer = new Producer(name, surname, type);
        producerDAO.add(producer);
        logger.info("The producer(" + producer + ") was added");

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Form for add(producer) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }
}

