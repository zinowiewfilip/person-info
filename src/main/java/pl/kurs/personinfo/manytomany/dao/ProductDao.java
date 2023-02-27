package pl.kurs.personinfo.manytomany.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.manytomany.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao implements IProductDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product get(Long id) {
        return entityManager.find(Product.class, id);
    }
}
