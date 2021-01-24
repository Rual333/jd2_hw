package it.academy.main;

import it.academy.pojos.Person;
import it.academy.services.PersonManager;
import it.academy.utils.HibernateUtil;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) {

        //Task 1 add Person using EntityManager
        Person person = new Person(null, 35, "Yuli", "Slabko");

        EntityManager em = HibernateUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        HibernateUtil.close();

        // Task 2-3 add, load, refresh, update and remove Person using Session
        PersonManager personManager = new PersonManager();

        //Task 2 save
        Serializable id = personManager.savePerson(new Person(null, 43, "Igor", "Summer"));

        //Task 2 load saved person
        person = personManager.loadPerson(id);
        System.out.println("Loaded person: " + person);

        //Task 3 update
        person.setAge(100);
        System.out.println("Changed person for update: " + person);
        personManager.saveOrUpdate(person);
        person = personManager.loadPerson(id);
        System.out.println("Updated person: " + person);

        //Task 3 refresh
        person.setAge(55);
        System.out.println("Changed person for refresh: " + person);
        personManager.refreshPerson(person);
        System.out.println("Refreshed person: " + person);

        //Task 2 remove saved person
        personManager.removePerson(id);
        person = personManager.loadPerson(id);
        System.out.println("Removed person: " + person);
    }
}
