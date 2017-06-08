package main.java.servlets.delete;

import main.java.dao.DescriptionDAO;
import main.java.dao.MovieDAO;
import main.java.entities.Description;
import main.java.entities.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "DeleteDescription", urlPatterns = "/deleteDescription")
public class DeleteDescription extends Delete<Description> {

    @Override
    public void init() throws ServletException {
        super.init();
        abstractDAO = abstractDAO == null ? new DescriptionDAO() : abstractDAO;
    }
}
