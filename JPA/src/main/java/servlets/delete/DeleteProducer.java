package main.java.servlets.delete;

import main.java.dao.DescriptionDAO;
import main.java.dao.ProducerDAO;
import main.java.entities.Description;
import main.java.entities.Producer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "DeleteProducer", urlPatterns = "/deleteProducer")
public class DeleteProducer extends Delete<Producer> {

    @Override
    public void init() throws ServletException {
        super.init();
        abstractDAO = abstractDAO == null ? new ProducerDAO() : abstractDAO;
    }
}
