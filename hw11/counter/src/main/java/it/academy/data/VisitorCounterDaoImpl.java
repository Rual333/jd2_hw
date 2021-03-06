package it.academy.data;

import it.academy.entities.VisitorCount;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VisitorCounterDaoImpl implements  VisitorCounterDao {

    private SessionFactory sessionFactory;


    @Autowired
    public VisitorCounterDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public VisitorCount readCount(int id) {
        final Session currentSession = sessionFactory.getCurrentSession();
        VisitorCount visitorCount =
                currentSession.get(VisitorCount.class, id, LockMode.PESSIMISTIC_WRITE);
        return visitorCount;
    }


    public int updateCount(VisitorCount count) {
        Session session = sessionFactory
                .getCurrentSession();
        session.saveOrUpdate(count);

        return count.getVisitorCount();

    }
}
