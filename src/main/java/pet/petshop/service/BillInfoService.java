package pet.petshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.dto.BillinfoDTO;
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
	public List<BillinfoDTO> listBillDTO(){
		List<BillinfoDTO> list = new ArrayList<BillinfoDTO>();
		for (BillInfo bi : bir.findtotoalitems()) {
			BillinfoDTO dto = new BillinfoDTO();
			dto.setId(bi.getId());
			dto.setIdproduct(bi.getProduct().getName());
			dto.setIdbill(bi.getBill().getId());
			dto.setCountitem(bi.getCountItem());
			list.add(dto);
		}
		return list;
	}

}
