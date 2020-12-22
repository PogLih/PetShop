package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import pet.petshop.dto.CustomOAuth2User;
import pet.petshop.entity.Blog;
import pet.petshop.entity.Product;
import pet.petshop.entity.Services;
import pet.petshop.entity.User;
import pet.petshop.service.BlogService;
import pet.petshop.service.ProductCategoryService;
import pet.petshop.service.ProductService;
import pet.petshop.service.ServiceServices;
import pet.petshop.service.UserServiceImpl;

@Controller

public class indexController {
	@Autowired
	private ProductService ps;
	
	@Autowired
	private ProductCategoryService pcs;

	@Autowired
	private ServiceServices ss;

	@Autowired
	private BlogService bs;
	
	
	

	@Autowired
	private UserServiceImpl us;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model,Authentication authentication,HttpSession session) {
		model.put("product", ps.listAll());
		if (authentication != null) {
			User user = us.loadUserByUsername2(authentication.getName());
			if(user==null) {
				CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
				user = us.loadUserByUsername2(oAuth2User.getEmail());
			}
			session.setAttribute("user",user);
		}
		return "index/index";
	}

	@RequestMapping("/shop")
	public String shop(Model model,ModelMap modelmap) {
		modelmap.put("productcate", pcs.listALL());
		return listByPage(model, 1);
	}
	
	@GetMapping("/shop-page/{pageNumber}")
	public String listByPage(Model model,
			@PathVariable("pageNumber") int currentpage) {
		
		Page<Product> page = ps.listAllPage(currentpage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Product> product = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("product", product);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		return "index/shop";
		
	}
	
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String service(Model model) {
//		model.put("service", ss.listALl());
		return listByPageService(model, 1);
	}
	@GetMapping("/dichvu-page/{pageNumber}")
	public String listByPageService(Model model,
			@PathVariable("pageNumber") int currentpage) {
		
		Page<Services> page = ss.listAllPageService(currentpage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Services> service = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("service", service);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		return "index/service";
		
	}
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Model model) {
		return listByPageBlog(model, 1);
	}
	@GetMapping("/baiviet-page/{pageNumber}")
	public String listByPageBlog(Model model,
			@PathVariable("pageNumber") int currentpage) {
		
		Page<Blog> page = bs.listAllPageBlog(currentpage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Blog> blog = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("blog", blog);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		return "index/blog";
		
	}
	

}
