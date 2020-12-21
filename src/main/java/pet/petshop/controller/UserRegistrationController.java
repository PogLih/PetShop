package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.petshop.dto.UserRegistrationDto;
import pet.petshop.entity.User;
import pet.petshop.service.UserService;
import pet.petshop.service.UserServiceImpl;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	@Autowired
	private UserServiceImpl userService;
//	private pet.petshop.service.UserService userService;
//
//	public UserRegistrationController(UserService userService) {
//		super();
//		this.userService = userService;
//	}
	
	@ModelAttribute("user")
    public User userRegistrationDto() {
        return new User();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration2";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") User user) {
		userService.Regis(user);
		return "redirect:/registration?success";
	}
}
