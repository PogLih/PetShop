package pet.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Product {
    private Integer id;
    private String name;
    private String brand;
    private String images;
    private Boolean status;
    private Integer price;
    private Integer discount;
    @JsonIgnore
    private Collection<Billinfo> billinfosById;

    private Productcategories productcategoriesByCate;
    @JsonIgnore
    private Productdetail productdetailById;



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

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 50)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "images", nullable = false, length = 200)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(images, product.images) &&
                Objects.equals(status, product.status) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discount, product.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, images, status, price, discount);
    }

    @OneToMany(mappedBy = "productByIdproduct")
    public Collection<Billinfo> getBillinfosById() {
        return billinfosById;
    }

    public void setBillinfosById(Collection<Billinfo> billinfosById) {
        this.billinfosById = billinfosById;
    }

    @ManyToOne
    @JoinColumn(name = "cate", referencedColumnName = "id", nullable = false)
    public Productcategories getProductcategoriesByCate() {
        return productcategoriesByCate;
    }

    public void setProductcategoriesByCate(Productcategories productcategoriesByCate) {
        this.productcategoriesByCate = productcategoriesByCate;
    }

    @OneToOne(mappedBy = "productByIdproduct", fetch = FetchType.EAGER)
    public Productdetail getProductdetailById() {
        return productdetailById;
    }

    public void setProductdetailById(Productdetail productdetailById) {
        this.productdetailById = productdetailById;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", brand='" + brand + '\'' +
            ", images='" + images + '\'' +
            ", status=" + status +
            ", price=" + price +
            ", discount=" + discount +
            '}';
    }
}
