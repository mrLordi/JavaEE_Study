package main.java.servlet.delete;

import main.java.dao.AbstractDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 11.10.2016.
 */
public abstract class Delete<T> extends HttpServlet {
    protected AbstractDAO<T> abstractDAO;
    protected abstract void initDAO();
    private final String NEXT = "/main";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        abstractDAO.deleteById(id);
        response.sendRedirect(request.getContextPath() + NEXT);
    }
}
