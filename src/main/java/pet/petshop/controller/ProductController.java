package pet.petshop.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pet.petshop.dto.ProductDto;
import pet.petshop.entity.Product;
import pet.petshop.entity.Productcategories;
import pet.petshop.entity.Productdetail;
import pet.petshop.service.ProductCategoryService;
import pet.petshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

  private ProductService productService;
  private ProductCategoryService productCategoryService;

  public ProductController(
      ProductService productService,
      ProductCategoryService productCategoryService) {
    this.productService = productService;
    this.productCategoryService = productCategoryService;
  }

  @GetMapping(value = "/view")
  public ModelAndView getAll() {
    return
        new ModelAndView("product/product")
            .addObject("listProduct", productService.getAll());
  }

  @PostMapping(value = "/add")
  public String save(ProductDto productDto) {
    System.out.println(productDto.toString());
    productService.save(productDto);
    return "redirect:/product/view";
  }

  @PostMapping(value = "/update")
  public String update(ProductDto productDto) {
    System.out.println(productDto.toString());
    productService.update(productDto);
    return "redirect:/product/view";
  }

  @GetMapping(value = "/findById")
  @ResponseBody
  public Product getInfoById(@RequestParam(value = "id") Integer id) {
    return productService.getDetailById(id);
  }

  @GetMapping(value = "/findDetailById")
  @ResponseBody
  public Productdetail getDetailById(@RequestParam(value = "id") Integer id) {
    return productService.getInfoDetailById(id);
  }

  @GetMapping(value = "/delete")
  public String delete(@RequestParam(value = "id") Integer id) {
    productService.delete(id);
    return "redirect:/product/view";
  }

  @ModelAttribute(value = "listCategories")
  public List<Productcategories> getCategories() {
    return productCategoryService.getAll();
  }

  @ModelAttribute(value = "productDto")
  public ProductDto getProduct() {
    return new ProductDto();
  }

}
