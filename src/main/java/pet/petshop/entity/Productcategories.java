package pet.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Productcategories {
    private Integer id;
    private String name;
    @JsonIgnore
    private Collection<Product> productsById;

    public Productcategories() {
    }

    public Productcategories(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public Productcategories setName(String name) {
        this.name = name;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productcategories that = (Productcategories) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "productcategoriesByCate", fetch = FetchType.LAZY)
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }

    @Override
    public String toString() {
        return "Productcategories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
