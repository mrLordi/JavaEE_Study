package main.java.servlet.delete;

import main.java.connection.ConnectionPool;
import main.java.dao.DescriptionDAO;
import main.java.dao.DirectorDAO;
import main.java.entity.Description;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 11.10.2016.
 */
@WebServlet(name = "DeleteDescription", urlPatterns = "/deleteDescription")
public class DeleteDescription extends Delete<Description> {
    @Override
    protected void initDAO() {
        abstractDAO = abstractDAO == null ? new DescriptionDAO(ConnectionPool.getInstance(getServletContext()
                .getResourceAsStream("/WEB-INF/config.properties"))) : abstractDAO;
    }
}
