package it.academy.data;

import it.academy.entities.VisitorCount;

public interface VisitorCounterDao {

    VisitorCount readCount(int id);

    int updateCount(VisitorCount count);
}
