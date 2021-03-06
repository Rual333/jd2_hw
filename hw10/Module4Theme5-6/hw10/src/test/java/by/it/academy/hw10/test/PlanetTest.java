package by.it.academy.hw10.test;

import by.it.academy.hw10.model.Planet;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(classes = TestConfigurations.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PlanetTest extends TestCase {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PlanetSaveAndReadService jobCandidateService;


    @Test
    public void planetSaveTest() {
        //Given
        Planet planet = new Planet(1L,"Mars", 64e22, 3389, 3.711);
        //When
        jobCandidateService.save(planet);
        //Then
        long id = entityManager.find(Planet.class, 1L).getId();
        assertEquals(1L, id);
    }
    @Test
    @Transactional
    public void planetReadTest() {
        //Given
        Planet planet = new Planet(1L,"Mars", 64e22, 3389, 3.711);
        entityManager.persist(planet);
        //When
        final Planet planetFromDb = jobCandidateService.read(1L);
        //Then
        long id = planetFromDb.getId();
        assertEquals(1L, id);
    }
}