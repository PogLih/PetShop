package pet.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pet.petshop.entity.Productcategories;
import pet.petshop.service.ProductCategoryService;

@Controller
public class ProductcategoriesController {
    @Autowired
    private ProductCategoryService pds;

    @RequestMapping("/productcategories")
    public String viewHomePage(Model model, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        List<Productcategories> productcategories = null;
        if (search.isEmpty()) {
            productcategories = pds.listALL();
        } else {
            productcategories = pds.findCategoriesByName(search);
        }
        model.addAttribute("productcategories", productcategories);
        return "admin/product/index_productcategories";
    }

    @RequestMapping("/newproductcategories")
    public String newproductcategories(Model model) {
        Productcategories Productcategories = new Productcategories();
        model.addAttribute("Productcategories", Productcategories);
        return "admin/product/productcategories_add";
    }

    @RequestMapping(value = "/saveproductcategories", method = RequestMethod.POST)
    public String saveproductcategories(@ModelAttribute("productcategories") Productcategories productcategories) {
        pds.save(productcategories);
        return "redirect:/productcategories";
    }

    @RequestMapping("/editproductcategories/{id}")
    public ModelAndView showEditproductcategories(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("admin/product/productcategories_edit");
        Productcategories productcategories = pds.get(id);
        mav.addObject("productcategories", productcategories);

        return mav;
    }

    @RequestMapping("/deleteproductcategories/{id}")
    public String deleteproductcategories(@PathVariable(name = "id") Integer id) {
        pds.delete(id);
        return "redirect:/productcategories";
    }

}
