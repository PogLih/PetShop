package pet.petshop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Billinfo {
    private Integer id;
    private Integer countItem;
    private Integer price;
    private Product productByIdproduct;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CountItem", nullable = false)
    public Integer getCountItem() {
        return countItem;
    }

    public void setCountItem(Integer countItem) {
        this.countItem = countItem;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billinfo billinfo = (Billinfo) o;
        return Objects.equals(id, billinfo.id) &&
                Objects.equals(countItem, billinfo.countItem) &&
                Objects.equals(price, billinfo.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countItem, price);
    }

    @ManyToOne
    @JoinColumn(name = "idproduct", referencedColumnName = "id", nullable = false)
    public Product getProductByIdproduct() {
        return productByIdproduct;
    }

    public void setProductByIdproduct(Product productByIdproduct) {
        this.productByIdproduct = productByIdproduct;
    }
}
