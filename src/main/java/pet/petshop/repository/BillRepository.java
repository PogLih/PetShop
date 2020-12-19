package pet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.Bill;
import pet.petshop.entity.User;



@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
	List<Bill> findByUser(User user);
	
}
