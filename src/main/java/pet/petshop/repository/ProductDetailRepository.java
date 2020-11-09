package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pet.petshop.entity.Productdetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<Productdetail, Integer> {

  Productdetail getProductdetailByIdproduct(Integer id);

}
