package pl.kurs.personinfo.manytomany.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.manytomany.model.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ShoppingCartDao implements IShoppingCartDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(ShoppingCart shoppingCart) {
        entityManager.persist(shoppingCart);
    }

    @Override
    public ShoppingCart get(Long id) {
        return entityManager.find(ShoppingCart.class, id);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        entityManager.merge(shoppingCart);
    }


}
