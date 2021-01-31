package it.academy.main;

import it.academy.pojos.Address;
import it.academy.pojos.Person;
import it.academy.pojos.Planet;
import it.academy.pojos.PlanetSystem;
import it.academy.services.DatabaseManager;
import it.academy.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        executeTask1();
        executeTask2();
        executeTask3();
        executeTask4();
        executeTask6();
    }

    public static void executeTask1() {
        //Task 1 add Person using EntityManager
        Person person = new Person(null, 35, "Yuli", "Slabko",
                new Address("7th Avenue", "New York", "10450"));

        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        HibernateUtil.close();
    }

    public static void executeTask2() {
        // Task 2 add, load and remove Person using Session
        Person person = new Person(null, 35, "Yuli", "Slabko",
                new Address("International", "St. Petersburg", "190000"));
        DatabaseManager databaseManager = new DatabaseManager();

        //Task 2 save
        Serializable id = databaseManager.save(person);

        //Task 2 load saved person
        person = (Person) databaseManager.load(id, Person.class);
        System.out.println("Loaded person: " + person);

        //Task 2 remove saved person
        databaseManager.remove(id);
        person = (Person) databaseManager.load(id, Person.class);
        System.out.println("Removed person: " + person);
    }

    public static void executeTask3() {
        // Task 3  refresh and update Person using Session
        Person person = new Person(null, 35, "Yuli", "Slabko",
                new Address("Djumeira", "Dubai", "24857"));
        DatabaseManager personManager = new DatabaseManager();

        //Task 3 update
        Serializable id = personManager.save(person);
        person.setAge(100);
        System.out.println("Changed person for update: " + person);
        personManager.saveOrUpdate(person);
        person =(Person) personManager.load(id, Person.class);
        System.out.println("Updated person: " + person);

        //Task 3 refresh
        person.setAge(55);
        System.out.println("Changed person for refresh: " + person);
        personManager.refresh(person);
        System.out.println("Refreshed person: " + person);
    }

    public static void executeTask4() {
        //save planet in Database for checking hibernate request
        Planet planet = new Planet(null, "Mars", 64e22, 3389, 3.711);
        DatabaseManager planetManager = new DatabaseManager();

        planetManager.save(planet);
    }

    public static void executeTask6() {
        HibernateUtil sessionFactory = new HibernateUtil();
        DatabaseManager databaseManager = new DatabaseManager();
        Planet pluton = new Planet(null, "Pluton", 130e20, 1188, 0.617);
        Planet neptun = new Planet(null, "Neptun", 102e23, 24622, 11.15);
        databaseManager.save(pluton);
        databaseManager.save(neptun);
        databaseManager.save(new PlanetSystem(null, List.of(pluton, neptun), "solar",
                "sun", 27170L, 2));

        sessionFactory
                .getSession()
                .createQuery("from Person", Person.class)
                .list()
                .forEach(person -> System.out.println("Person id: "+ person.getId()));
        sessionFactory
                .getSession()
                .createQuery("from Planet", Planet.class)
                .list()
                .forEach(planet -> System.out.println("Planet id: "+ planet.getId()));
        sessionFactory
                .getSession()
                .createQuery("from PlanetSystem", PlanetSystem.class)
                .list()
                .forEach(planetSystem -> System.out.println("PlanetSystem id: "+ planetSystem.getId()));
    }

}
