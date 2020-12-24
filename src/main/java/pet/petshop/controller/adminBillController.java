package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;
import pet.petshop.entity.Blog;
import pet.petshop.entity.Product;
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
		return listByPageAdminBill(model, 1, "id", "desc");
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
	  @GetMapping("/bill-page/{pageNumber}")
		public String listByPageAdminBill(Model model,
				@PathVariable("pageNumber") int currentpage,
				@Param("sortField") String sortField,
				@Param("sortDir") String sortDir) {
			
			Page<Bill> page = bill.listAllPageAdminBill(currentpage, sortField, sortDir);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages();
			int totalItemsInpage = page.getNumberOfElements();
			
			List<Bill> billadmin = page.getContent();
			model.addAttribute("currentpage", currentpage);
			model.addAttribute("billadmin", billadmin);
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("totalItems",totalItems);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("totalItemsInpage",totalItemsInpage);
			
			String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
			model.addAttribute("reverseSortDir",reverseSortDir);
			return "admin/bill/showBill";
			
		}
	@RequestMapping("/Bill/{id}")
	public String Billinfolist(Model model,@PathVariable(name = "id") int id) {
		List<BillInfo> billinfo = bis.BillinfoByBill(bill.get(id));
		model.addAttribute("billinfo",billinfo);
		return "admin/bill/billinfo";
	}

}
