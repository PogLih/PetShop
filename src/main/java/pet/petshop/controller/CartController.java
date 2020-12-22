package pet.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pet.petshop.entity.Item;
import pet.petshop.service.ProductService;




@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ProductService ps;
	
	

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model,HttpSession session) {
		int total = 0;
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if(cart!=null) {
		for(int i=0;i<cart.size();i++) {
			total+= cart.get(i).getQuantity()*cart.get(i).getProduct().getPrice();
		}
		}
		model.addAttribute("total",total);
		return "index/cart2";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id, HttpSession session,RedirectAttributes redirAttrs) {
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(ps.get(id), 1));
			session.setAttribute("cart", cart);
			redirAttrs.addFlashAttribute("success", "Đã thêm sản phẩm " + ps.get(id).getName());
			return "redirect:/shop";
		} else {
			@SuppressWarnings("unchecked")
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExists(id, cart);
			if (index == -1) {
				cart.add(new Item(ps.get(id), 1));
				redirAttrs.addFlashAttribute("success", "Đã thêm sản phẩm " + ps.get(id).getName());
				return "redirect:/shop";
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				redirAttrs.addFlashAttribute("success", "Đã thêm sản phẩm " + ps.get(id).getName() + " thành " + cart.get(index).getQuantity());
				return "redirect:/cart";
			}
		}
		
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") int id,  HttpSession session, RedirectAttributes redirAttrs) {
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExists(id, cart);
		
		if(cart.get(index).getQuantity()==1) {
			cart.remove(index);
			redirAttrs.addFlashAttribute("delete", "Đã xoá " + ps.get(id).getName());
		}else
		{
			int quantity = cart.get(index).getQuantity() - 1;
			cart.get(index).setQuantity(quantity);
			redirAttrs.addFlashAttribute("des", "Đã giảm sản phẩm " + ps.get(id).getName() + " thành " + cart.get(index).getQuantity());
		}
		session.setAttribute("cart", cart);
		return "redirect:/cart";
	}
	

	private int isExists(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
