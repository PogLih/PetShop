package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;

import pet.petshop.service.ProductCategoryService;

import pet.petshop.service.ProductService;

@Controller
public class sanphamController {
	@Autowired
    private ProductService ps;
	
	
	
	
	
	 @RequestMapping("/sanpham/{id}")
	    public ModelAndView xemsanpham(@PathVariable(name = "id") Integer id) {
	        ModelAndView mav = new ModelAndView("shop/thongtinsanpham");
	        Product product = ps.get(id);
	        mav.addObject("product", product);
	        return mav;
	    }
}
