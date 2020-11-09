package pet.petshop.dto;

public class ProductDto {

  private Integer id;
  private String name;
  private String brand;
  private String images;
  private String status;
  private Integer price;
  private Integer discount;
  private Integer category;
  private Integer height;
  private Integer width;
  private Integer length;
  private String typeOfPet;
  private String stage;
  private String description;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public String getTypeOfPet() {
    return typeOfPet;
  }

  public void setTypeOfPet(String typeOfPet) {
    this.typeOfPet = typeOfPet;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "ProductDto{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", brand='" + brand + '\'' +
        ", images='" + images + '\'' +
        ", status=" + status +
        ", price=" + price +
        ", discount=" + discount +
        ", height=" + height +
        ", width=" + width +
        ", length=" + length +
        ", typeOfPet='" + typeOfPet + '\'' +
        ", stage='" + stage + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
