package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Productcategories, Integer> {

  Productcategories getProductcategoriesById(Integer id);



}
