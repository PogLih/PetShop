package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Blogcategories;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;
import pet.petshop.service.ProductCategoryService;
import pet.petshop.service.ProductService;
import pet.petshop.utils.FileUploadUtil;

@Controller
public class ProductController {
    @Autowired
    private ProductService ps;
    
    @Autowired
    private ProductCategoryService pcs;
    
    
    @RequestMapping("/test")
	public String index111(ModelMap model) {
		model.put("product",ps.listAll());
		return "index6";
	}

    @RequestMapping("/product")
    public String viewHomePage(Model model, @RequestParam(value = "search", defaultValue = "", required = false) String search) {
        
    	Iterable<Product> product = null;
        if (search.isEmpty()) {
            return listByPageAdminProduct(model, 1, "id", "desc");
        } else {
            product = ps.searchByName(search);
            
        }
        model.addAttribute("product", product);
        return "admin/product/index_product";
    }
    
    @GetMapping("/product-page/{pageNumber}")
	public String listByPageAdminProduct(Model model,
			@PathVariable("pageNumber") int currentpage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		Page<Product> page = ps.listAllPageAdminProduct(currentpage, sortField, sortDir);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Product> product = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("product", product);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "admin/product/index_product";
		
	}
    
    @RequestMapping("/newproduct")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        List<Productcategories> cate = pcs.listALL();
        model.addAttribute("product", product);
        model.addAttribute("cate", cate);
        return "admin/product/product_add";
    }

   
    
    @RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product")@Valid Product product, @RequestParam("image")MultipartFile multipartFile,BindingResult bindingResult
    		) throws IOException {
    	if(bindingResult.hasErrors()==true)
    	{
    		return "product/product_add";
    	}
    	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setImages(fileName);
        Product saveProduct=ps.save(product);
        String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/assets/img/";
        
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        System.out.println(uploadDir);
        return "redirect:/product";
    }

    @RequestMapping("/editproduct/{id}")
    public ModelAndView showEditProduct(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("admin/product/product_edit");
        List<Productcategories> cate = pcs.listALL();
        Product product = ps.get(id);
        mav.addObject("product", product);
        mav.addObject("cate", cate);

        return mav;
    }

    @RequestMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        ps.delete(id);
        return "redirect:/product";
    }
}

