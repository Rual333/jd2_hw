package it.academy.data;

import java.sql.SQLException;
import java.util.List;

public interface ReceiverDao {

    void create(Receiver receiver);

    Receiver read(int num);

    List<Receiver> readAll() throws SQLException;

    void update(Receiver receiver);

    void delete(Receiver receiver);

}
