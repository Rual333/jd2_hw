package it.academy.service;

import it.academy.data.VisitorCounterDao;
import it.academy.entities.VisitorCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class VisitorCounterService {

    @Autowired
    private VisitorCounterDao visitorCounterDao;



    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int readCount() {
        VisitorCount visitorCount = visitorCounterDao.readCount(1);
        return visitorCount == null ? 0 : visitorCount.getVisitorCount();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateCount() {
        VisitorCount visitorCount = visitorCounterDao.readCount(1);
        if (visitorCount == null) {
            visitorCount = new VisitorCount(1, 1);
            return visitorCounterDao.updateCount(visitorCount);
        }
        int count = visitorCount.getVisitorCount();
        count++;
        visitorCount.setVisitorCount(count);
        return visitorCounterDao.updateCount(visitorCount);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int setCount(int id, int count) {
        VisitorCount visitorCount = visitorCounterDao.readCount(id);
        if (visitorCount == null) {
            visitorCount = new VisitorCount(id, count);
            return visitorCounterDao.updateCount(visitorCount);
        }
        visitorCount.setVisitorCount(count);
        return visitorCounterDao.updateCount(visitorCount);
    }



}
