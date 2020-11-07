package pet.petshop.service;

import org.springframework.stereotype.Component;
import pet.petshop.entity.Productcategories;

import java.util.List;

@Component
public interface ProductCategoryService {

    List<Productcategories> getAll();

    Productcategories save(Productcategories pc);

    Productcategories update(Productcategories pc);

    void delete(Integer id);

}
