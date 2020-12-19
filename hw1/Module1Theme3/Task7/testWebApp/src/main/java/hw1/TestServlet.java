package hw1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Welcome to Homework 1 Task 7</h2>");
        } finally {
            writer.close();
        }
    }
}