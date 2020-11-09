package pet.petshop.service;

import org.springframework.stereotype.Service;
import pet.petshop.entity.Productcategories;
import pet.petshop.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

  private ProductCategoryRepository categoryRepository;

  public ProductCategoryServiceImpl(ProductCategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<Productcategories> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Productcategories save(Productcategories pc) {
    return categoryRepository.save(pc);
  }

  @Override
  public Productcategories update(Productcategories pc) {
    return categoryRepository.save(pc);
  }

  @Override
  public void delete(Integer id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public Productcategories findById(Integer id) {
    return categoryRepository.getProductcategoriesById(id);
  }
}
