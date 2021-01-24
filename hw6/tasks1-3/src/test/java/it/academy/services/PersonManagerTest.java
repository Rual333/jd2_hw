package it.academy.services;


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
public class PersonManagerTest {

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
        PersonManager personManager = new PersonManager(configureHibernate);
        Session session = factory.openSession();

        //When
        Serializable id = personManager.savePerson(new Person(null, 10, "Test", "Save"));

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
        PersonManager personManager = new PersonManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        Serializable id = session.save(new Person(null, 20, "Test", "Load"));
        session.getTransaction().commit();

        //When
        Person person = personManager.loadPerson(id);

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
        PersonManager personManager = new PersonManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        Serializable id = session.save(new Person(null, 30, "Test", "Remove"));
        session.getTransaction().commit();
        session.clear();

        //When
        personManager.removePerson(id);

        //Then
        Person person = session.get(Person.class, id);
        assertNull(person);
        session.close();
    }

    @Test
    public void refreshPerson() {
        //Given
        Person person = new Person(null, 40, "Test", "Refresh");
        PersonManager personManager = new PersonManager(configureHibernate);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        //When
         person.setAge(45);
         personManager.refreshPerson(person);

        //Then
        Integer age = person.getAge();
        assertSame(40, age);

    }

    @Test
    public void saveOrUpdatePerson() {
        //Given
        Person person = new Person(null, 50, "Test", "saveOrUpdate");
        PersonManager personManager = new PersonManager(configureHibernate);
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
