
import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTask9 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WorkerWithCountFile.createCountFile(getServletContext().getRealPath(""));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        int count = WorkerWithCountFile.getCountAndIncrement();
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>This is the visit counter page</title></head>");
        out.println("<body><h1> The number of visits to this page: " + count + "</h1>");
        out.println("</body></html>");
    }

}