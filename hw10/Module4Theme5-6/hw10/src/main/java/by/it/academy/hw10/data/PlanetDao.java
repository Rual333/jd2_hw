package by.it.academy.hw10.data;

import by.it.academy.hw10.model.Planet;

public interface PlanetDao {

    void save(Planet planet);

    Planet read(long id);
}
