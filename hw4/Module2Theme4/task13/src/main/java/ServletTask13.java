
import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTask13 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String myPath = getServletContext().getRealPath("");
        WorkerWithCountFile.createCountFile(myPath);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int count = -1;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitControl".equals(cookie.getName())) {
                    count = WorkerWithCountFile.getCount();
                }
            }
        }
        if (count == -1) {
            Cookie controlCookie = new Cookie("visitControl", "beenHereInTheLast24Hours");
            controlCookie.setMaxAge(24 * 60 * 60);
            response.addCookie(controlCookie);
            count = WorkerWithCountFile.getCountAndIncrement();
        }
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>This is the visit counter page</title></head>");
        out.println("<body><h1> The number of unique visits to this page per day: " + count + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}