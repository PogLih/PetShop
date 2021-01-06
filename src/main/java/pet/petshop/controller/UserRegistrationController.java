package pet.petshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public String registerUserAccount(@ModelAttribute("user")@Valid User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()==true) {
			return "registration2";
		}
		else if(userService.userExist(user.getEmail())==true) {
			bindingResult.addError(new FieldError("user", "email", "Địa chỉ email đã được sử dụng"));
			return "registration2";
		}
		else {
				userService.Regis(user);
					return "redirect:/login?success";
		}
	}
}
