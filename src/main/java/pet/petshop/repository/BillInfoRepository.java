package pet.petshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;



@Repository
public interface BillInfoRepository extends JpaRepository<BillInfo, Integer>{
	
	List<BillInfo> findByBill(Bill bill);
	
	
}
