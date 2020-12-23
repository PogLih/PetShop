package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;
import pet.petshop.entity.Blog;
import pet.petshop.service.BillInfoService;
import pet.petshop.service.BillService;


@Controller
public class adminBillController {

	@Autowired
	private BillService bill;
	
	@Autowired
	private BillInfoService bis;
	
	@RequestMapping("/adminbill")
	public String viewBill(Model model) {
		List<Bill> billadmin =bill.listAll();
		model.addAttribute("billadmin",billadmin);
		return "admin/bill/showBill";
	}
	
	@RequestMapping("/billinfo")
	public String viewBillInfo(Model model) {
		List<BillInfo> billinfo = bis.listAll();
		model.addAttribute("billinfo",billinfo);
		return "admin/bill/billinfo";
	}
	
	@RequestMapping("/UpdateBillStatus/{id}")
	public String UpdateBill(@PathVariable(name = "id") int id) {
		Bill b = bill.get(id);
		switch (b.getStatus()) {
		case 0:
			b.setStatus(b.getStatus()+1);
			break;
		case 1:
			b.setStatus(b.getStatus()+1);
			break;
		case 2:
			b.setStatus(b.getStatus()+1);
			break;
		default:
			b.setStatus(0);;
		}
		bill.save(b);
		return "redirect:/adminbill";
	}
	
	@RequestMapping("/Bill/{id}")
	public String Billinfolist(Model model,@PathVariable(name = "id") int id) {
		List<BillInfo> billinfo = bis.BillinfoByBill(bill.get(id));
		model.addAttribute("billinfo",billinfo);
		return "admin/bill/billinfo";
	}

}
