package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;
import pet.petshop.repository.BillInfoRepository;

@Service
@Transactional
public class BillInfoService {
	@Autowired
	private BillInfoRepository bir;
	
	public List<BillInfo> listAll(){
		return bir.findAll();
	}
	
	public void save(BillInfo bill) {
		bir.save(bill);
	}
	
	public BillInfo get(int id) {
		return bir.findById(id).get();
	}
	
	public void delete(int id) {
		bir.deleteById(id);
	}
	public List<BillInfo> BillinfoByBill(Bill bill){
		return bir.findByBill(bill);
	}

}
