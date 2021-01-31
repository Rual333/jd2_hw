package it.academy.services;


import it.academy.pojos.Address;
import it.academy.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import static org.junit.Assert.*;

@FixMethodOrder
public class DatabaseManagerTest {

    private SessionFactory factory;
    private final String configureHibernate = "hibernate.cfg.test.xml";

    @Before
    public void setUp() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure(configureHibernate)
                        .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void savePerson() {

        //Given
        DatabaseManager personManager = new DatabaseManager(configureHibernate);
        Session session = factory.openSession();

        //When
        Serializable id = personManager.save(new Person(null, 10, "Test", "Save",
                new Address("Djumeira", "Dubai", "24857")));

        //Then
        assertNotNull(session.get(Person.class, id));
        Person personForDelete = session.get(Person.class, id);
        session.beginTransaction();
        session.delete(personForDelete);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void loadPerson() {

        //Given
        DatabaseManager personManager = new DatabaseManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        Serializable id = session.save(new Person(null, 20, "Test", "Load",
                new Address("Djumeira", "Dubai", "24857")));
        session.getTransaction().commit();

        //When
        Person person = (Person) personManager.load(id, Person.class);

        //Then
        assertNotNull(person);
        Person personForDelete = session.get(Person.class, id);
        session.beginTransaction();
        session.delete(personForDelete);
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void removePerson() {
        //Given
        DatabaseManager personManager = new DatabaseManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        Serializable id = session.save(new Person(null, 30, "Test", "Remove",
                new Address("Djumeira", "Dubai", "24857")));
        session.getTransaction().commit();
        session.clear();

        //When
        personManager.remove(id);

        //Then
        Person person = session.get(Person.class, id);
        assertNull(person);
        session.close();
    }

    @Test
    public void refreshPerson() {
        //Given
        Person person = new Person(null, 40, "Test", "Refresh",
                new Address("Djumeira", "Dubai", "24857"));
        DatabaseManager personManager = new DatabaseManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        //When
         person.setAge(45);
         personManager.refresh(person);

        //Then
        Integer age = person.getAge();
        assertSame(40, age);

    }

    @Test
    public void saveOrUpdatePerson() {
        //Given
        Person person = new Person(null, 50, "Test", "saveOrUpdate",
                new Address("Djumeira", "Dubai", "24857"));
        DatabaseManager personManager = new DatabaseManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        //When
        person.setAge(60);
        personManager.saveOrUpdate(person);

        //Then
        Integer age = person.getAge();
        assertSame(60, age);

    }

    @After
    public void tearDown() {
        factory.close();
    }

}
