package it.academy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpensesDao getExpensesDao(String url,String  user,String  password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return new ExpensesDaoImpl(connection);
    }

    public ReceiverDao getReceiverDao(String url,String  user,String  password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return new ReceiverDaoImpl(connection);
    }

    public static DaoFactory getInstance() throws ClassNotFoundException {
        daoFactory = new DaoFactory();
        return  daoFactory;
    }


}
