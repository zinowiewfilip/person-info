package pl.kurs.personinfo.onetomany.dao;

import pl.kurs.personinfo.onetomany.model.Driver;

public interface IDriverDao {
    void save(Driver driver);
    Driver get(Long id);
    Driver getWithCars(Long id);
    void update(Driver driver);
    void delete(Driver driver);
}
