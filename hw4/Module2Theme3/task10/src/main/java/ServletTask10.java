
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "servletTask10", urlPatterns = "/task10")
public class ServletTask10 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        try {
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            if (name == "" || (phone == "" && email == "")) {
                writer.println("Please make sure that you entered name and phone or email");
                return;
            }
            if ((Validator.validateEmail(email) || email == "")  && (Validator.validatePhone(phone)) || phone == "") {
                writer.println("Name: " + name);
                writer.println("Phone number: " + phone);
                writer.println("Email: " + email);
            } else {
                writer.println("Please enter phone number and email in appropriate format:");
                writer.println("Phone number: +375 (29/33/44) XXX-XX-XX");
                writer.println("Email: local_part@domen");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
            writer.println("Error: " + e.getMessage());
        }
    }
}