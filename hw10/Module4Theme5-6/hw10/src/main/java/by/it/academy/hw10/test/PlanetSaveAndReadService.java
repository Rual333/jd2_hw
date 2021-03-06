package by.it.academy.hw10.test;

import by.it.academy.hw10.data.PlanetDao;
import by.it.academy.hw10.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class PlanetSaveAndReadService {

    @Autowired
    private PlanetDao planetDao;

    TransactionTemplate transactionTemplate;

    @Autowired
    public PlanetSaveAndReadService(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public Long save(Planet planet) {
        return transactionTemplate.execute(transactionStatus -> {
            try {
                System.out.println("записал по Id");
                planetDao.save(planet);
            } catch (Exception e) {
                transactionStatus.hasSavepoint();
            }
            return planet.getId();
        });

    }

    public Planet read(long id) {
        return transactionTemplate.execute(transactionStatus -> {
            try {
                System.out.println("прочитал по Id");
                return planetDao.read(id);

            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
            }
            return null;
        });
    }

}
