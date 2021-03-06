package by.it.academy.hw10.data;

import by.it.academy.hw10.model.Planet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlanetDaoImpl implements PlanetDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Planet planet) {
        em.persist(planet);
    }

    @Override
    public Planet read(long id) {
        return em.find(Planet.class, id);
    }
}
