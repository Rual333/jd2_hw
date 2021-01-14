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

public class ServletTasksHw5 extends HttpServlet {
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
                writer.println("Something goes wrong when querying the expenses table. Please check your connection");
            }

            request.setAttribute("expenses", expenses);

            ReceiverDao receiverDao = daoFactory.getReceiverDao(url, user, password);
            List<Receiver> receivers = null;
            try {
                receivers = receiverDao.readAll();
            } catch (SQLException e ) {
                writer.println("Something goes wrong when querying the receiver table. Please check your connection");
            }

            request.setAttribute("receivers", receivers);

            request.getRequestDispatcher("/jsp/tables.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            writer.println("Something went wrong while connecting to database! Please check your connection to database");
        } catch (ServletException e) {
            e.printStackTrace();
                writer.println("Something wrong with server!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}