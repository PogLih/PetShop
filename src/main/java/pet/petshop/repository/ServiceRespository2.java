package pet.petshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;


import pet.petshop.entity.Services;

public interface ServiceRespository2 extends PagingAndSortingRepository<Services, Integer> {
	Iterable<Services> getProductsByNameContains(String search);
}
