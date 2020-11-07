package pet.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pet.petshop.entity.Productcategories;
import pet.petshop.service.ProductCategoryService;

@Controller
@RequestMapping(value = "/productcategory")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping(value = "/")
    public ModelAndView getAll(){
        return
                new ModelAndView("product_category")
                        .addObject("listCategories", productCategoryService.getAll());
    }

    @PostMapping(value = "/")
    public String insert(@ModelAttribute(value = "productcategory") Productcategories productcategories){
        Productcategories save = productCategoryService.save(productcategories);
        System.out.println(save.toString());
        return "redirect:/productcategory/";
    }



}
