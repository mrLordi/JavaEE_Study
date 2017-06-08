package main.java.servlets.update;

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
@WebServlet(name = "UpdateProducer", urlPatterns = "/updateProducer")
public class UpdateProducer extends HttpServlet {
    private final static Logger logger = Logger.getLogger(UpdateProducer.class);
    private ProducerDAO producerDAO;

    private final String MAIN = "/main";
    private final String NEXT = "/JSP/update/updateProducer.jsp";

    @Override
    public void init() throws ServletException {
        super.init();

        producerDAO = producerDAO == null ? new ProducerDAO() : producerDAO;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Producer producer = producerDAO.getById(id);

        String name = request.getParameter("name");
        if (name.equals("")) {
            logger.warn("The name of producer was missing when updating");
            Helper.sendError("the name was missed", request, response);
        }

        String surname = request.getParameter("surname");
        if (surname.equals("")) {
            logger.warn("The surname of producer was missing when updating");
            Helper.sendError("the surname was missed", request, response);
        }

        String type = request.getParameter("type");
        if (type.equals("")) {
            logger.warn("The type was missing when updating");
            Helper.sendError("the type was missed", request, response);
        }

        producer.setName(name);
        producer.setSurname(surname);
        producer.setType(type);

        producerDAO.update(producer);
        logger.info("The producer(" + producer + ") was updated");

        response.sendRedirect(request.getContextPath() + MAIN);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Producer producer = producerDAO.getById(id);
        request.setAttribute("producer", producer);

        logger.info("Form for update(producer) was displayed");

        request.getRequestDispatcher(NEXT).forward(request, response);
    }

}
