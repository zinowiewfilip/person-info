package pl.kurs.personinfo.manytomany.dao;

import pl.kurs.personinfo.manytomany.model.ShoppingCart;

public interface IShoppingCartDao {
    void save(ShoppingCart shoppingCart);

    ShoppingCart get(Long id);

    void update(ShoppingCart shoppingCart);
}
