package pl.kurs.personinfo.onetoone.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.onetoone.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao implements IPersonDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person get(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void update(Person person) {
       entityManager.merge(person);


    }

    @Override
    public void delete(Person person) {
        person = entityManager.merge(person);
        entityManager.remove(person);
    }
}
