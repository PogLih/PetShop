package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import pet.petshop.entity.User;
import pet.petshop.service.BlogService;
import pet.petshop.service.ProductService;
import pet.petshop.service.ServiceServices;
import pet.petshop.service.UserServiceImpl;

@Controller

public class indexController {
	@Autowired
	private ProductService ps;

	@Autowired
	private ServiceServices ss;

	@Autowired
	private BlogService bs;
	
	
	

	@Autowired
	private UserServiceImpl us;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model,Principal principal,HttpSession session) {
		model.put("product", ps.listAll());
		if (principal != null) {
			User user = us.loadUserByUsername2(principal.getName());
			session.setAttribute("user",user);
		}
		return "index/index";
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop(ModelMap model) {
		model.put("product", ps.listAll());
		
		return "index/shop";
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String service(ModelMap model) {
		model.put("service", ss.listALl());
		return "index/service";
	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(ModelMap model) {
		model.put("blog", bs.listALL());
		return "index/blog";
	}
	
	

}
