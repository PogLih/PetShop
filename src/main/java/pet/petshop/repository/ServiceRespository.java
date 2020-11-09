package pet.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.petshop.entity.Services;

public interface ServiceRespository extends JpaRepository<Services, Integer> {

}
