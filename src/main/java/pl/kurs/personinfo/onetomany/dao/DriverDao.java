package pl.kurs.personinfo.onetomany.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.onetomany.model.Driver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DriverDao implements IDriverDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(Driver driver) {

        entityManager.persist(driver);
    }

    @Override
    public Driver get(Long id) {
        return entityManager.find(Driver.class, id);

    }

    @Override
    public Driver getWithCars(Long id) {
        TypedQuery<Driver> tq = entityManager.createQuery("SELECT d FROM Driver d LEFT JOIN FETCH d.cars WHERE d.id = :id", Driver.class);
        tq.setParameter("id", id);
        return tq.getSingleResult();
    }

    @Override
    public void update(Driver driver) {
    }

    @Override
    public void delete(Driver driver) {
        driver = entityManager.merge(driver);
        entityManager.remove(driver);

    }

    //TODO update do domu i delete w wersji dwukierunkowej
}
