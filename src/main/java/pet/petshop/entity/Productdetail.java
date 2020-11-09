package pet.petshop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Productdetail {

  private Integer idproduct;
  private Integer height;
  private Integer width;
  private Integer length;
  private String typeofpet;
  private String stage;
  private String description;
  private Product productByIdproduct;

  @Id
  @Column(name = "idproduct", nullable = false)
  public Integer getIdproduct() {
    return idproduct;
  }

  public void setIdproduct(Integer idproduct) {
    this.idproduct = idproduct;
  }

  @Basic
  @Column(name = "height", nullable = true)
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  @Basic
  @Column(name = "width", nullable = true)
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  @Basic
  @Column(name = "length", nullable = true)
  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  @Basic
  @Column(name = "typeofpet", nullable = true, length = 100)
  public String getTypeofpet() {
    return typeofpet;
  }

  public void setTypeofpet(String typeofpet) {
    this.typeofpet = typeofpet;
  }

  @Basic
  @Column(name = "stage", nullable = true, length = 100)
  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  @Basic
  @Column(name = "description", nullable = true, length = -1)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Productdetail that = (Productdetail) o;
    return Objects.equals(idproduct, that.idproduct) &&
        Objects.equals(height, that.height) &&
        Objects.equals(width, that.width) &&
        Objects.equals(length, that.length) &&
        Objects.equals(typeofpet, that.typeofpet) &&
        Objects.equals(stage, that.stage) &&
        Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idproduct, height, width, length, typeofpet, stage, description);
  }

  @OneToOne
  @JoinColumn(name = "idproduct", referencedColumnName = "id", nullable = false)
  public Product getProductByIdproduct() {
    return productByIdproduct;
  }

  public void setProductByIdproduct(Product productByIdproduct) {
    this.productByIdproduct = productByIdproduct;
  }

  @Override
  public String toString() {
    return "Productdetail{" +
        "idproduct=" + idproduct +
        ", height=" + height +
        ", width=" + width +
        ", length=" + length +
        ", typeofpet='" + typeofpet + '\'' +
        ", stage='" + stage + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
