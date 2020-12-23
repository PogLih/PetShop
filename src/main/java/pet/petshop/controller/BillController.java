package pet.petshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pet.petshop.entity.Bill;
import pet.petshop.entity.BillInfo;
import pet.petshop.entity.Item;
import pet.petshop.entity.User;
import pet.petshop.service.BillInfoService;
import pet.petshop.service.BillService;

@Controller
public class BillController {
	@Autowired
	private BillService bs;
	@Autowired
	private BillInfoService bis;
	
	

	@RequestMapping("/charge")
	public String Charge(HttpSession session,RedirectAttributes redirAttrs) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = new Date();
		String now = format.format(date);
		User user = (User) session.getAttribute("user");
		int total = 0;
		Bill bill = new Bill();
		bill.setDate(format.parse(now));
		bill.setUser(user);
		bill.setUserid(user.getId());
		bill.setTotalprice(total);
		List<BillInfo> bifs = new ArrayList<BillInfo>();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			Item item = cart.get(i);
			total += item.getQuantity() * item.getProduct().getPrice();
			BillInfo bi = new BillInfo();
			bi.setProduct(item.getProduct());
			bi.setCountItem(item.getQuantity());
			bi.setBill(bill);
			
			bifs.add(bi);
		}
		bill.setTotalprice(total);
		bs.save(bill);
		
		for (int i = 0; i < bifs.size(); i++) {
			bis.save(bifs.get(i));
			
		}
		
		
		session.removeAttribute("cart");
		redirAttrs.addFlashAttribute("success", "Mua thanh  ");
		return "index/index";
	}

}
