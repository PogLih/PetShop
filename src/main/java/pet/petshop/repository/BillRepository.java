package pet.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pet.petshop.entity.Bill;
import pet.petshop.entity.User;



@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
	List<Bill> findByUser(User user);
	
	@Query(value = "SELECT bill.id,bill.date AS date,bill.userid,bill.status,SUM(bill.totalprice) as totalprice FROM bill WHERE bill.status = 2 GROUP BY Month(date)", nativeQuery = true)
	Iterable<Bill> followmoth();
	
	@Query(value = "SELECT COUNT(id) AS id,bill.date AS date, bill.userid as userid, bill.status as status, bill.totalprice as totalprice FROM bill GROUP BY status", nativeQuery = true)
	Iterable<Bill> countstatus();
}
