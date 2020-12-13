package pet.petshop.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import pet.petshop.entity.Product;



public interface ProductRespository2 extends PagingAndSortingRepository<Product, Integer> {

    Iterable<Product> getProductsByNameContains(String search);
   
}
