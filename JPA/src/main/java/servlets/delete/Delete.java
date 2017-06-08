package main.java.servlets.delete;

import main.java.dao.AbstractDAO;
import main.java.servlets.add.AddDescription;
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
public abstract class Delete<T> extends HttpServlet {
    protected static Logger logger = Logger.getLogger(Delete.class);
    protected AbstractDAO<T> abstractDAO;
    private final String NEXT = "/main";

    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        logger.info("in " + abstractDAO.getClass().getSimpleName() + ": An entity with id = " + id + " was deleted");

        abstractDAO.deleteById(id);
        response.sendRedirect(request.getContextPath() + NEXT);
    }
}

