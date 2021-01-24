package it.academy.services;

import it.academy.pojos.Person;
import it.academy.utils.HibernateUtil;
import org.hibernate.Session;
import java.io.Serializable;


public class PersonManager {

    private final HibernateUtil sessionFactoryFromHibernateUtil;

    public PersonManager() {
        this.sessionFactoryFromHibernateUtil = new HibernateUtil();
    }

    public PersonManager(String config) {
        this.sessionFactoryFromHibernateUtil = new HibernateUtil(config);
    }

    public Serializable savePerson(Person person) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        Serializable id = session.save(person);
        session.getTransaction().commit();

        session.close();

        return id;
    }

    public Person loadPerson(Serializable id) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        Person loadedPerson = session.get(Person.class, id);
        session.close();

        return loadedPerson;

    }

    public void removePerson(Serializable id) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        Person personForDelete = session.get(Person.class, id);
        session.delete(personForDelete);
        session.getTransaction().commit();

        session.close();
    }
     public void refreshPerson(Person person) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        session.refresh(person);
        session.getTransaction().commit();

        session.close();
     }

    public void saveOrUpdate(Person person) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();

        session.close();
    }
}
