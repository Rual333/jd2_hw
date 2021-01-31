package it.academy.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    //HibernateUtil that works with EntityManager (Persistence.xml) using static methods
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("academy");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public static void close() {
        emFactory.close();
    }

    // Hibernate util that works with Hibernate.cfg.xml
    private final StandardServiceRegistry registry;

    private final SessionFactory factory;

    public HibernateUtil() {
        this.registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        this.factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public HibernateUtil(String config) {
        this.registry = new StandardServiceRegistryBuilder()
                .configure(config)
                .build();
        this.factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
    public Session getSession() {
        return factory.openSession();
    }
}
