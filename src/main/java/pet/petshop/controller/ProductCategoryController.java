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

  @GetMapping(value = "/view")
  public ModelAndView getAll() {
    return
        new ModelAndView("product/product_category")
            .addObject("listCategories", productCategoryService.getAll());
  }

  @PostMapping(value = "/add")
  public String insert(@ModelAttribute(value = "category") Productcategories cate) {
    cate.setId(null);
    productCategoryService.save(cate);
    return "redirect:/productcategory/view";
  }

  @PostMapping(value = "/update")
  public String update(@ModelAttribute(value = "category") Productcategories cate) {
    productCategoryService.save(cate);
    return "redirect:/productcategory/view";
  }

  @GetMapping(value = "/findById")
  @ResponseBody
  public Productcategories findOne(@RequestParam(value = "id") Integer id) {
    return productCategoryService.findById(id);
  }

  @GetMapping(value = "/delete")
  public String delete(@RequestParam(value = "id") Integer id) {
    productCategoryService.delete(id);
    return "redirect:/productcategory/view";
  }

  @ModelAttribute(value = "category")
  public Productcategories model() {
    return new Productcategories();
  }

}
