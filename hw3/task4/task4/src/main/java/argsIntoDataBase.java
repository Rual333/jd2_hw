
import java.sql.*;

public class argsIntoDataBase {
    public static void main(String[] args) {

        validateArgsParameters(args);

        insertIntoDataBase(args);

        printTable();

    }

    private static void printHelpMessage() {
        System.out.println("Help message:");
        System.out.println("Please use 3 parameters when you launch this program exactly " +
                "in the same order as below: \n");
        System.out.println("date value receiver \n");
        System.out.println("Date must be entered in that format: 'YYYY-MM-DD' ");
        System.out.println("Make sure that you entered the right decimal point");
        System.exit(1);
    }

    private static void validateArgsParameters(String[] args) {
        if (args.length != 3) {
            printHelpMessage();
        }
        try {
            Date.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Invalid date \n");
            printHelpMessage();
        }
        try {
            Double.parseDouble(args[1]);
            Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("\nInvalid value and receiver parameters " +
                    "its must be double and integer respectively\n");
            printHelpMessage();
        }
    }


    private static void insertIntoDataBase(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/listexpenses?serverTimezone=Europe/Moscow", "root", "root");
            final Statement statement = connection.createStatement();
            ResultSet idSet = statement.executeQuery("SELECT max(num) FROM listexpenses.expenses;");
            idSet.next();
            int id = idSet.getInt(1) + 1;
            statement.executeUpdate("insert into listexpenses.expenses (num, paydate, value, receiver) " +
                    "values (" + id + ", '" + Date.valueOf(args[0]) + "', " + Double.parseDouble(args[1]) + ", " + Integer.parseInt(args[2]) + ");");

            idSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/listexpenses?serverTimezone=Europe/Moscow", "root", "root");
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM listexpenses.expenses;");
            while (resultSet.next()) {
                int num = resultSet.getInt(1);
                String date = resultSet.getString(2);
                int receiver = resultSet.getInt(3);
                float value = resultSet.getFloat(4);

                System.out.println("num=" + num + " date=" + date + " receiver=" + receiver + " value=" + value);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
