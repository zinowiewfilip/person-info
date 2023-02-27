package pl.kurs.personinfo.manytomany.dao;

import pl.kurs.personinfo.manytomany.model.Product;

public interface IProductDao {
    void save(Product product);
    Product get(Long id);
}
