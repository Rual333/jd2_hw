package servlet;

import data.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
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
            e.printStackTrace();
            throw new ServletException();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            request.setAttribute("expenses", getExpensesTable());
            request.setAttribute("receivers", getReceiverTable());
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/jsp/errors.jsp").forward(request, response);
        }
            request.getRequestDispatcher("/jsp/tables.jsp").forward(request, response);

    }

    private List<Expense> getExpensesTable() throws SQLException {

            List<String> initParameters = getInitParam();
            ExpensesDao expensesDao = daoFactory.getExpensesDao(initParameters.get(0), initParameters.get(1), initParameters.get(2));

        return expensesDao.readAll();
    }

    private List<Receiver> getReceiverTable() throws SQLException {

        List<String> initParameters = getInitParam();
        ReceiverDao receiverDao = daoFactory.getReceiverDao(initParameters.get(0), initParameters.get(1), initParameters.get(2));

        return receiverDao.readAll();
    }

    private List<String> getInitParam() {
        List<String> initParameters = new ArrayList<>();

        ServletConfig conf = getServletConfig();
        initParameters.add(conf.getInitParameter("dbURL"));
        initParameters.add(conf.getInitParameter("user"));
        initParameters.add(conf.getInitParameter("password"));

        return initParameters;
    }

}