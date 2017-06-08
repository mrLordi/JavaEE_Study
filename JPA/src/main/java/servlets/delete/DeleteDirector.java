package main.java.servlets.delete;

import main.java.dao.DirectorDAO;
import main.java.entities.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 31.10.2016.
 */
@WebServlet(name = "DeleteDirector", urlPatterns = "/deleteDirector")
public class DeleteDirector extends Delete<Director> {

    @Override
    public void init() throws ServletException {
        super.init();
        abstractDAO = abstractDAO == null ? new DirectorDAO() : abstractDAO;
    }
}
