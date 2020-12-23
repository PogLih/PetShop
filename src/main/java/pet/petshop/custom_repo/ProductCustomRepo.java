package pet.petshop.custom_repo;

import pet.petshop.entity.Product;

import java.util.List;

public interface ProductCustomRepo {

    List<Product> filter(String price, String category, String brand);

}
