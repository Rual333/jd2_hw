package it.academy.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReceiverDaoImpl implements ReceiverDao{

    private final Connection connection;

    ReceiverDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Receiver receiver) {

    }

    @Override
    public Receiver read(int num) {
        return null;
    }

    @Override
    public List<Receiver> readAll() throws SQLException {
        List<Receiver> receivers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from receivers;")) {
                while (resultSet.next()) {
                    Receiver receiver = new Receiver();
                    receiver.setNum(resultSet.getInt("num"));
                    receiver.setName(resultSet.getString("name"));
                    receivers.add(receiver);
                }
            }
        }
        return receivers;
    }

    @Override
    public void update(Receiver receiver) {

    }

    @Override
    public void delete(Receiver receiver) {

    }
}
