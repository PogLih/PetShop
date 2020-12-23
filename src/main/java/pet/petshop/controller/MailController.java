package pet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.bytebuddy.utility.RandomString;
import pet.petshop.entity.User;
import pet.petshop.service.UsersService;

@Controller
public class MailController {
	@Autowired
    private JavaMailSender emailSender;
	@Autowired
	private UsersService us;
	@Autowired
	private BCryptPasswordEncoder encode;
 
	/*
	 * @RequestMapping("/sendSimpleEmail") public String sendSimpleEmail() {
	 * 
	 * // Create a Simple MailMessage. SimpleMailMessage message = new
	 * SimpleMailMessage();
	 * 
	 * message.setTo("tahuythinh@gmail.com"); message.setSubject("Reset Password");
	 * message.setText("random code,link-> trang reset");
	 * 
	 * // Send Message! this.emailSender.send(message);
	 * 
	 * return "redirect:/user"; }
	 */
    @RequestMapping("/forgotpassword")
    public String forgotpassword(@RequestParam(value = "email",defaultValue = "", required = false) String email) {
    	try {
    		User user= us.findbyemail(email);
        	SimpleMailMessage message = new SimpleMailMessage();
            user.setVerificationcode(RandomString.make(13));
            us.save(user);
            message.setTo(user.getEmail());
            message.setSubject("Reset Password");
            message.setText("Verification code:"+user.getVerificationcode()+"\n"
            		+ "Link: http://localhost:8080/resetpassword/"+user.getId());
     
            // Send Message!
            this.emailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return "forgotpassword";
    }
    
    @RequestMapping(value="/resetpassword/{id}",method = RequestMethod.GET)
    public String resetpassword(@PathVariable(name = "id") int id,ModelMap model) {
    	User user = us.get(id);
    		model.addAttribute("forgotuser",user);
    	return "resetpassword1";
    }
    @RequestMapping(value="/resetpassword/{id}",method = RequestMethod.POST)
    public String resetpassword(@PathVariable(name = "id") int id
    							,@RequestParam(name = "password", required = false) String password
    							,@RequestParam(name = "verificationcode", required = false) String code) {
    	User user= us.get(id);
    	if(user.getVerificationcode().equals(code))
    		user.setPassword(encode.encode(password));
    	us.save(user);
    	
    	return "redirect:/login";
    }
}
