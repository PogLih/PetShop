package pet.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Bill;
import pet.petshop.entity.User;
import pet.petshop.service.UsersService;

@Controller
//@RequestMapping("/User")
public class UserController {
	@Autowired
	private UsersService us;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	
	@RequestMapping("/user")
	public String index(Model model) {
		return listByPageAdminUser(model, 1, "role", "asc");
	}
	
	@GetMapping("/user-page/{pageNumber}")
	public String listByPageAdminUser(Model model,
			@PathVariable("pageNumber") int currentpage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		Page<User> page = us.listAllPageAdminUser(currentpage, sortField, sortDir);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<User> list = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("users",list);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "admin/user/index";
		
	}
	
	@RequestMapping("/new")
	public String showNewUserPage(Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	     
	    return "admin/user/new";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
	    us.save(user);
	     
	    return "redirect:/user";
	}
	
	@RequestMapping("/editUser/{id}")
	public String showEditUserPage(@PathVariable(name = "id") int id,ModelMap model) {
	    User user = us.get(id);
	    if(user.getRole().contains("ROLE_STAFF"))
	    	user.setRole("ROLE_USER");
	    else
	    if(user.getRole().contains("ROLE_USER"))
	    	user.setRole("ROLE_STAFF");
	    us.save(user);
	    return "redirect:/user";
	}
	
	
	@RequestMapping(value = "/Updatepass/{id}")
	public String resetUser(@PathVariable(name = "id") int id) {
		User user = us.get(id);
		String encodepass = passwordEncoder().encode("555");
		user.setPassword(encodepass);
	    us.save(user);
	    return "redirect:/user";
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteProduct(HttpSession session,@PathVariable(name = "id") int id) {
		User user = (User) session.getAttribute("user");
		if(user.getId()!=id)
	    us.delete(id);
	    return "redirect:/user";       
	}
	
	
}
