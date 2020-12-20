package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pet.petshop.custom_repo.ProductCustomRepo;
import pet.petshop.entity.Product;

import java.util.List;


public interface ProductRespository extends JpaRepository<Product, Integer>, ProductCustomRepo {

    List<Product> getProductsByNameContains(String search);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name% AND p.cate = :category AND p.status = :status")
    List<Product> getProductsByNameContainsAndBrand(
            @Param("name") String search,
            @Param("category") Integer category,
            @Param("status") Boolean status);


    @Query("SELECT DISTINCT p.brand FROM Product p")
    List<String> getListBranch();
}
