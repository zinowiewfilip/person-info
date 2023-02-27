package pl.kurs.personinfo.manytomany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart")
    private Long id;

    private String ownerName;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "shopping_carts_products",

            joinColumns = {@JoinColumn(name="shopping_cart_id",
                    referencedColumnName="id_shopping_cart")},

            inverseJoinColumns = {@JoinColumn(name="product_id",
                    referencedColumnName="id_product")}
    )
    private Set<Product> products = new HashSet<>();

    public ShoppingCart() {
    }

    public ShoppingCart(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(ownerName, that.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerName);
    }

    public Set<Product> getProducts() {
        return products;
    }
}
