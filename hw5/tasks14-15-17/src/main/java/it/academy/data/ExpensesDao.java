package it.academy.data;

import java.sql.SQLException;
import java.util.List;

public interface ExpensesDao {

    void create(Expense expense);

    Expense read(int num);

    void update(Expense expense);

    List<Expense> readAll() throws SQLException;

    void delete(Expense expense);

}