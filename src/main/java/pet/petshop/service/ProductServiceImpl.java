package pet.petshop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pet.petshop.dto.ProductDto;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;
import pet.petshop.entity.Productdetail;
import pet.petshop.repository.ProductDetailRepository;
import pet.petshop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private ProductDetailRepository productDetailRepository;

  public ProductServiceImpl(ProductRepository productRepository,
      ProductDetailRepository productDetailRepository) {
    this.productRepository = productRepository;
    this.productDetailRepository = productDetailRepository;
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Override
  public Product save(ProductDto dto) {
    Product product = new Product();
    product.setName(dto.getName());
    product.setImages(dto.getImages());
    product.setBrand(dto.getBrand());
    product.setStatus(dto.getStatus().equalsIgnoreCase("true"));
    product.setPrice(dto.getPrice());
    product.setDiscount(dto.getDiscount());
    product.setProductcategoriesByCate(new Productcategories(dto.getCategory()));
    Product save = productRepository.save(product);

    Productdetail productdetail = new Productdetail();
    productdetail.setIdproduct(save.getId());
    productdetail.setHeight(dto.getHeight());
    productdetail.setWidth(dto.getWidth());
    productdetail.setLength(dto.getLength());
    productdetail.setTypeofpet(dto.getTypeOfPet());
    productdetail.setStage(dto.getStage());
    productdetail.setDescription(dto.getDescription());
    productDetailRepository.save(productdetail);

    return save;
  }

  @Override
  public Product update(ProductDto dto) {
    Product product = new Product();
    product.setId(dto.getId());
    product.setName(dto.getName());
    product.setImages(dto.getImages());
    product.setBrand(dto.getBrand());
    product.setStatus(dto.getStatus().equalsIgnoreCase("true"));
    product.setPrice(dto.getPrice());
    product.setDiscount(dto.getDiscount());
    product.setProductcategoriesByCate(new Productcategories(dto.getCategory()));
    Product save = productRepository.save(product);

    Productdetail productdetail = new Productdetail();
    productdetail.setIdproduct(dto.getId());
    productdetail.setHeight(dto.getHeight());
    productdetail.setWidth(dto.getWidth());
    productdetail.setLength(dto.getLength());
    productdetail.setTypeofpet(dto.getTypeOfPet());
    productdetail.setStage(dto.getStage());
    productdetail.setDescription(dto.getDescription());
    productDetailRepository.save(productdetail);

    return save;
  }

  @Override
  public Product getDetailById(Integer id) {
    return productRepository.getProductById(id);
  }

  @Override
  public Productdetail getInfoDetailById(Integer id) {
    return productDetailRepository.getProductdetailByIdproduct(id);
  }

  @Override
  public void delete(Integer id) {
    productDetailRepository.deleteById(id);
    productRepository.deleteById(id);
  }
}
