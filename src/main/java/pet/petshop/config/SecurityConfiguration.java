package pet.petshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pet.petshop.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/"
				,"/shop"
				,"/shop-page/**"
				, "/service"
				, "/dichvu-page/**"
				, "/blog"
				, "/baiviet-page/**"
				, "/profile"
				, "/editprofile"
				, "/billhistory"
				, "/cart"
				, "/confirm"
				, "/charge"
				, "/login"
				, "/chitietbill/**"
				, "/logout").permitAll();
		
		http.authorizeRequests().antMatchers("/admin"
				, "/user"
				, "/editUser/**"
				,"/services"
				, "/service-page/**"
				, "/newservices"
				, "/editservice/**"
				, "/servicecategories"
				, "/product"
				, "/product-page/**"
				, "/newproduct"
				, "/editproduct/**"
				, "/productcategories"
				, "/editproductcategories/**"
				, "/newproductcategories"
				, "/blogindex"
				, "/blog-page/**"
				, "/newblog"
				, "/editblog/**"
				, "/adminbill"
				, "/bill-page/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers(
				 "/registration**",
				 "/**",
	                "/js/**",
	                "/css/**",
	                "/img/**",
	                "/plugins/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}

}
