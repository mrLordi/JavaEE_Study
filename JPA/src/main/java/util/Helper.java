package main.java.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win10 on 01.11.2016.
 */
public class Helper {
    private final static String ERROR = "/JSP/error.jsp";

    public static void sendError(String message, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("error", message);
        request.getRequestDispatcher(ERROR).forward(request, response);
    }

    public static int readData(String s) {
        int result;
        if (s.equals("")) {
            result = -1;
        } else {
            result = Integer.parseInt(s);
        }
        return result;
    }

}
