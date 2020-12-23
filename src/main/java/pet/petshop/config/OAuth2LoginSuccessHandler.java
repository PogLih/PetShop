package pet.petshop.config;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pet.petshop.dto.CustomOAuth2User;
import pet.petshop.entity.AuthenticationProvider;
import pet.petshop.entity.User;
import pet.petshop.service.UsersService;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private UsersService us;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 
		CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
		String email = oAuth2User.getEmail();
		
		System.out.println(authentication.getPrincipal().toString());
		User user = us.findbyemail(email);
		String name = oAuth2User.getName();
		

		if (user == null) {
			us.saveOauth2(email,"ROLE_USER",name,AuthenticationProvider.GOOGLE);
			System.out.println("Ok");
		} else {
			us.updateOauth2(user,name,AuthenticationProvider.GOOGLE);
			System.out.println("not Ok");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
