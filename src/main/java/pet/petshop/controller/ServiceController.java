package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Blogcategories;
import pet.petshop.entity.Product;
import pet.petshop.entity.Servicecategories;
import pet.petshop.entity.Services;
import pet.petshop.service.ServiceCategoriesService;
import pet.petshop.service.ServiceServices;
import pet.petshop.utils.FileUploadUtil;

@Controller
public class ServiceController {
	@Autowired
	private ServiceServices abc;
	
	@Autowired
	private ServiceCategoriesService svc;

	@RequestMapping("/services")
	public String viewHomePage(Model model) {
		
		return listByPageAdminServices(model, 1, "id", "desc");
	}

	@GetMapping("/service-page/{pageNumber}")
	public String listByPageAdminServices(Model model,
			@PathVariable("pageNumber") int currentpage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		Page<Services> page = abc.listAllPageAdminService(currentpage, sortField, sortDir);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Services> listServices = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("listServices", listServices);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "admin/service/index1";
		
	}
	
	public String viewHomePage(Model model,
			@RequestParam(value = "search", required = false, defaultValue = "") String search) {
		List<Services> listServices = null;
		if (search.isEmpty()) {
			listServices = abc.listALl();
		} else {
			listServices = abc.name(search);
		}
		model.addAttribute("listServices", listServices);
		return "admin/service/index1";
	}

	@RequestMapping("/newservices")
	public String showNewServiceForm(Model model) {
		Services services = new Services();
		List<Servicecategories> cate = svc.listAll();
		model.addAttribute("cate", cate);
		model.addAttribute("services", services);
		return "admin/service/new_service1";
	}

	

	@RequestMapping(value = "/saveservice", method = RequestMethod.POST)
	public String saveService(@ModelAttribute("services") @Valid Services services,
			@RequestParam("image") MultipartFile multipartFile, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors() == true) {
			return "service/new_service1";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		services.setImages(fileName);
		Services saveServices = abc.save(services);
		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/img/";

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		System.out.println(uploadDir);
		return "redirect:/services";
	}

	@RequestMapping("/editservice/{id}")
	public ModelAndView showEditServiceForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("admin/service/edit_services1");
		List<Servicecategories> cate = svc.listAll();
		Services services = abc.get(id);
		mav.addObject("services", services);
		mav.addObject("cate", cate);

		return mav;
	}

	@RequestMapping("/deleteservice/{id}")
	public String delteteServices(@PathVariable(name = "id") Integer id) {
		abc.delete(id);
		return "redirect:/services";
	}
}
