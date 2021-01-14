package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao{

    private final Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expense expense) {

    }

    @Override
    public Expense read(int num) {
        return null;
    }

    @Override
    public void update(Expense expense) {

    }

    @Override
    public List<Expense> readAll() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from expenses;")) {
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setNum(resultSet.getInt("num"));
                expense.setPayDate(resultSet.getDate("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getFloat("value"));
                expenses.add(expense);
            }
        }
        return expenses;
    }

    @Override
    public void delete(Expense expense) {

    }
}
