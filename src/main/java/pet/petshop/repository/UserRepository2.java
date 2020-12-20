package pet.petshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import pet.petshop.entity.User;

public interface UserRepository2 extends PagingAndSortingRepository<User, Integer>{

}
