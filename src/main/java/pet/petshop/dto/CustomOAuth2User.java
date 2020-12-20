package pet.petshop.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User{

	private OAuth2User oauth2user;
	public Map<String, Object> getDetails() {
		return oauth2user.getAttributes();
	}
	public CustomOAuth2User(OAuth2User oauth2user) {
		this.oauth2user = oauth2user;
	}
	public String getPhone() {
		// TODO Auto-generated method stub
		return oauth2user.getAttribute("PhoneNumber");
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return oauth2user.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return oauth2user.getAuthorities();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return oauth2user.getAttribute("name");
	}
	
	
	
	public String getEmail() {
		return oauth2user.getAttribute("email");
	}
	
	
}
