package pet.petshop.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Services;
import pet.petshop.service.ServiceServices;

@Controller
public class ServiceController {
	@Autowired
	private ServiceServices abc;
	@RequestMapping("/services")
	public String viewHomePage(Model model) {
		List<Services> listServices = abc.listALl();
		model.addAttribute("listServices",listServices);
		return "service/index";
	}
	
	@RequestMapping("/newservices")
	public String showNewServiceForm(Model model) {
		Services services = new Services();
		model.addAttribute("services",services);
		return "service/new_service";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
		public String saveService(@ModelAttribute("services") Services services)
		{
		abc.save(services);
		return "redirect:/services";
}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditServiceForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("service/edit_services");
		Services services= abc.get(id);
		mav.addObject("services",services);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String delteteServices(@PathVariable(name="id") Integer id) {
		abc.delete(id);
		return "redirect:/";
	}
}
