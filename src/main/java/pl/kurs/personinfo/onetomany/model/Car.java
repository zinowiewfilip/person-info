package pl.kurs.personinfo.onetomany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long id;

    @Column(nullable = false)
    private String producer;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String engineType;

//    @ManyToOne
//    @JoinColumn(name = "driver_id")
//    private Driver driver;

    public Car() {
    }

    public Car(String producer, String model, String engineType) {
        this.producer = producer;
        this.model = model;
        this.engineType = engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && Objects.equals(engineType, car.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producer, model, engineType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                '}';
    }

//    public void setDriver(Driver driver) {
//        this.driver = driver;
//    }
}
