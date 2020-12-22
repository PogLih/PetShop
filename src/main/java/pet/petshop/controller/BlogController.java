package pet.petshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import pet.petshop.entity.Blog;
import pet.petshop.entity.Blogcategories;
import pet.petshop.entity.User;
import pet.petshop.entity.Blog;
import pet.petshop.service.BlogCategoriesService;
import pet.petshop.service.BlogService;
import pet.petshop.utils.FileUploadUtil;

@Controller

public class BlogController {
	@Autowired
	private BlogService bs;
	
	@Autowired
	private BlogCategoriesService bcs;
	@RequestMapping("/blogindex")
	public String viewHomePage(Model model) {
		return listByPageAdminBlog(model, 1, "id", "desc");
	}
	
	@GetMapping("/blog-page/{pageNumber}")
	public String listByPageAdminBlog(Model model,
			@PathVariable("pageNumber") int currentpage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		Page<Blog> page = bs.listAllPageAdminBlog(currentpage, sortField, sortDir);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		int totalItemsInpage = page.getNumberOfElements();
		
		List<Blog> listblog = page.getContent();
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("listblog", listblog);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("totalItemsInpage",totalItemsInpage);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc"  : "asc" ;
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "admin/blog/blog_index";
		
	}
	
	@RequestMapping("/newblog")
	public String showNewBlogForm(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Blog blog = new Blog();
		List<Blogcategories> cate = bcs.listALL();
		model.addAttribute("user",user);
		model.addAttribute("cate", cate);
		model.addAttribute("blog",blog);
		return "admin/blog/blog_add";
	}
	
	
	
	@RequestMapping(value = "/saveblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") Blog blog,HttpSession session, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		blog.setImages(fileName);
		User user = (User) session.getAttribute("user");
//		String id= String.valueOf((user.getId()));
		blog.setUserid(user.getId());
		Blog saveBlog = bs.save(blog);
		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/img/";

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		System.out.println(uploadDir);
		return "redirect:/blogindex";
	}
	
	@RequestMapping("/editblog/{id}")
	public ModelAndView showEditBlog(ModelMap model,@PathVariable(name = "id")Integer id) {
		ModelAndView mav = new ModelAndView("admin/blog/blog_edit");
		Blog blog = bs.get(id);
		List<Blogcategories> cate = bcs.listALL();
		model.addAttribute("cate", cate);
		mav.addObject("blog", blog);
		return mav;
	}
	
	@RequestMapping("/deleteblog/{id}")
	public String deleteBlog(@PathVariable(name = "id")Integer id) {
		bs.delete(id);
		return "redirect:/blogindex";
	}
}
