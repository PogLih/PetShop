package pet.petshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;



@Repository("billInfoRepository")
public interface BillInfoRepository extends JpaRepository<BillInfo, Integer>{
	
	List<BillInfo> findByBill(Bill bill);
	@Query(value = "SELECT  billinfo.id,billinfo.idbill,billinfo.idproduct,product.name ,SUM(billinfo.countItem) as countItem FROM billinfo INNER JOIN product ON billinfo.idproduct = product.id GROUP BY billinfo.idproduct", nativeQuery = true)
	Iterable<BillInfo> findtotoalitems ();
	
}
