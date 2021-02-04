package servlet;

import data.*;

import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTask14 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            daoFactory = DaoFactory.getInstance();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletConfig conf = getServletConfig();
        String url = conf.getInitParameter("dbURL");
        String user = conf.getInitParameter("user");
        String password = conf.getInitParameter("password");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter writer = response.getWriter();

        try {

            ExpensesDao expensesDao = daoFactory.getExpensesDao(url, user,password);
            List<Expense> expenses = null;
            try {
                expenses = expensesDao.readAll();
            } catch (SQLException e ) {
                writer.println("Something goes wrong when querying the expenses table");
            }


            if (expenses != null) {
                writer.println(" Expenses table: <br>");
                for (Expense expense:expenses) {
                    writer.println("num= " + expense.getNum() + " date=" + expense.getPayDate() +
                            " receiver=" + expense.getReceiver() + " value=" + expense.getValue() + "<br>");
                }
            }

            ReceiverDao receiverDao = daoFactory.getReceiverDao(url, user, password);
            List<Receiver> receivers = null;
            try {
                receivers = receiverDao.readAll();
            } catch (SQLException e ) {
                writer.println("Something goes wrong when querying the receiver table");
            }


            if (receivers != null) {
                writer.println("<br> Receiver table: <br>");
                for (Receiver receiver:receivers) {
                    writer.println("num= " + receiver.getNum() + " receiver=" + receiver.getName() + "<br>");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            writer.println("Something goes wrong! Please check your connection to database");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visit counter page</title></head>");
        out.println("<body><h1> Post method is not implemented </h1>");
        out.println("</body></html>");
    }

}