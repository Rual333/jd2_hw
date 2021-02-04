
import eu.bitwalker.useragentutils.UserAgent;

import java.io.*;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTask11 extends HttpServlet {
    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        writer.println("Hello " + userAgent.getBrowser().getName() + " user");

    }

}