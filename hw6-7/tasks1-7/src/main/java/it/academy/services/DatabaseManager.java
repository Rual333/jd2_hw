package it.academy.services;

import it.academy.pojos.Person;
import it.academy.utils.HibernateUtil;
import org.hibernate.Session;
import java.io.Serializable;


public class DatabaseManager {

    private final HibernateUtil sessionFactoryFromHibernateUtil;

    public DatabaseManager() {
        this.sessionFactoryFromHibernateUtil = new HibernateUtil();
    }

    public DatabaseManager(String config) {
        this.sessionFactoryFromHibernateUtil = new HibernateUtil(config);
    }

    public Serializable save(Object object) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        Serializable id = session.save(object);
        session.getTransaction().commit();

        session.close();

        return id;
    }

    public Object load(Serializable id, Class clazz) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        Object loaded = session.get(clazz, id);
        session.close();

        return loaded;

    }

    public void remove(Serializable id) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        Person personForDelete = session.get(Person.class, id);
        session.delete(personForDelete);
        session.getTransaction().commit();

        session.close();
    }
     public void refresh(Object object) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        session.refresh(object);
        session.getTransaction().commit();

        session.close();
     }

    public void saveOrUpdate(Object object) {

        Session session = sessionFactoryFromHibernateUtil.getSession();

        session.beginTransaction();
        session.saveOrUpdate(object);
        session.getTransaction().commit();

        session.close();
    }
}
