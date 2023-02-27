package pl.kurs.personinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.personinfo.manytomany.dao.IProductDao;
import pl.kurs.personinfo.manytomany.dao.IShoppingCartDao;
import pl.kurs.personinfo.manytomany.model.Product;
import pl.kurs.personinfo.manytomany.model.ShoppingCart;
import pl.kurs.personinfo.onetomany.dao.IDriverDao;
import pl.kurs.personinfo.onetomany.model.Car;
import pl.kurs.personinfo.onetomany.model.Driver;
import pl.kurs.personinfo.onetoone.dao.IPersonDao;
import pl.kurs.personinfo.onetoone.model.Person;
import pl.kurs.personinfo.onetoone.model.PersonDetails;

@SpringBootApplication
public class PersonInfoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PersonInfoApplication.class, args);
        IPersonDao personDao = ctx.getBean(IPersonDao.class);


        //Relacja OneToOne
//        PersonDetails personDetails1 = new PersonDetails(
//                "12345678901",
//                "programista@gmail.com",
//                "666777888");
//
//        Person person = new Person(
//                "Kamil",
//                "Nowak",
//                personDetails1);
//        personDao.save(person);
//
//        System.out.println("//////////////////////////////////////");
//
//        Person loadedPerson = personDao.get(1l);
//        System.out.println("//////////////////////////////////////");
//
//        loadedPerson.setFirstName("Zenek");
//        loadedPerson.getPersonDetails().setEmail("sexeducator@onet.pl");
//        personDao.update(loadedPerson);
//
//        //Ponowne wczytanie aktualnej osoby
//        System.out.println("////////////////////////////////////////");
//        loadedPerson = personDao.get(1l);
//        System.out.println(loadedPerson);
//
//        System.out.println("///////////////////////////////////");
//        personDao.delete(loadedPerson);

        // ---------------------------------------------------------------------------------------------------

        //Relacja OneToMany
        IDriverDao driverDao = ctx.getBean(IDriverDao.class);

        Driver driver1 = new Driver("Kamil", "Kowalski");
        Car car1 = new Car("BMW", "M4", "R6");
        Car car2 = new Car("Skoda", "Superb", "R4");
        driver1.getCars().add(car1);
        driver1.getCars().add(car2);
//        driver1.addCar(car1);
//        driver1.addCar(car2);
        driverDao.save(driver1);

        System.out.println("//////////////////////////////////////////////////////////////");

        Driver loadedDriver = driverDao.get(1l);

        System.out.println("//////////////////////////////////////////////////////////////////////");

        Driver loadedDriverWithCars = driverDao.getWithCars(1l);

        System.out.println("//////////////////////////////////////////////////////////////////////");

        driverDao.delete(driver1);


        //-------------------------------------------------------------------------------------------------------

        //Relacja ManyToMany
        IShoppingCartDao shoppingCartDao = ctx.getBean(IShoppingCartDao.class);
        IProductDao productDao = ctx.getBean(IProductDao.class);

        ShoppingCart shoppingCart1 = new ShoppingCart("Kamil");
        shoppingCartDao.save(shoppingCart1);

        Product product1 = new Product("Mleko", 3.0, "mleko normalne");
        Product product2 = new Product("Kurczak", 12.0, "kurczak bio");

        productDao.save(product1);
        productDao.save(product2);
        System.out.println("//////////////////////////////////////////////////////////////////////");

        ShoppingCart loadedShoppingCart = shoppingCartDao.get(1l);
        System.out.println("//////////////////////////////////////////////////////////////////////");

        Product loadedProduct1 = productDao.get(1l);
        System.out.println("//////////////////////////////////////////////////////////////////////");

        Product loadedProduct2 = productDao.get(2l);

        System.out.println("//////////////////////////////////////////////////////////////////////");

        loadedShoppingCart.getProducts().add(loadedProduct1);
        loadedShoppingCart.getProducts().add(loadedProduct2);

        shoppingCartDao.update(loadedShoppingCart);

        //TODO manyToMany dwukierunkowa







    }

}
