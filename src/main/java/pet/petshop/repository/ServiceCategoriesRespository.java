package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Servicecategories;

public interface ServiceCategoriesRespository extends JpaRepository<Servicecategories, Integer> {

}
