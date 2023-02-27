package pl.kurs.personinfo.onetoone.dao;

import pl.kurs.personinfo.onetoone.model.Person;

public interface IPersonDao {

    void save(Person person); //create

    Person get(Long id); //read

    void update(Person person); //update

    void delete(Person person); //delete

}
