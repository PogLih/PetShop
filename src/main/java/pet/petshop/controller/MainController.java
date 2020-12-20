package pet.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pet.petshop.entity.BillInfo;
import pet.petshop.entity.Item;
import pet.petshop.entity.User;
import pet.petshop.service.BillInfoService;
import pet.petshop.service.BillService;
import pet.petshop.service.ProductService;
import pet.petshop.service.UserServiceImpl;
import pet.petshop.service.UsersService;

@Controller
public class MainController {
	
	@Autowired
	private UserServiceImpl us;
	@Autowired
	private UsersService uss;
	@Autowired
	private BillInfoService bis;
	@Autowired
	private BillService bill;
	@Autowired
	private BillService bs;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/editprofile")
	public String editprofile(ModelMap model,HttpSession session) {
		User us = (User) session.getAttribute("user");
		us.setPassword("");	
		model.addAttribute("user",session.getAttribute("user"));
		return "profile/edit_profile";
	}

	@RequestMapping("/changepassword")
	public String changePassword(ModelMap model,HttpSession session) {
		model.addAttribute("user",session.getAttribute("user"));
		return "changepassword";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user) {
		String encodepass = passwordEncoder().encode(user.getPassword());
		user.setPassword(encodepass);
	    uss.save(user);
	    return "redirect:/";
	}
	
	
	
	
	@RequestMapping("/profile")
	public String index(Model model) {
		List<User> list = uss.listAll();
		model.addAttribute("users",list);
		return "profile/profile";
	}
	@RequestMapping("billhistory")
	public String billhistory(ModelMap model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("history",bs.BillByUser(user));
		return "index/lichsumuahang";
	}
	
	@RequestMapping("/chitietbill/{id}")
	public String Chitietbill(Model model,@PathVariable(name = "id") int id) {
		List<BillInfo> billinfo = bis.BillinfoByBill(bill.get(id));
		model.addAttribute("billinfo",billinfo);
		return "index/chitietbill";
	}
	
	@GetMapping("/admin")
	public String home2() {
		return "admin/index3";
	}
	
	@RequestMapping(value="/confirm" ,method = RequestMethod.GET)
	public String confirm(ModelMap model,HttpSession session)
	{
		int total = 0;
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart!=null) {
		for(int i=0;i<cart.size();i++) {
			total+= cart.get(i).getQuantity()*cart.get(i).getProduct().getPrice();
		}
		}
		model.addAttribute("total",total);
		return("index/confirm");
	}
	
	
	
	
	
}
