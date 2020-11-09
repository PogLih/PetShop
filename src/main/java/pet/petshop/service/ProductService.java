package pet.petshop.service;

import java.util.List;
import org.springframework.stereotype.Component;
import pet.petshop.dto.ProductDto;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productdetail;

@Component
public interface ProductService {

  List<Product> getAll();

  Product save(ProductDto dto);

  Product update(ProductDto sto);

  Productdetail getInfoDetailById(Integer id);

  Product getDetailById(Integer id);

  void delete(Integer id);

}
