package pet.petshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pet.petshop.service.UserService;
import pet.petshop.service.CustomOauth2UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	@Autowired
	private DataSource dataSource;
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
//		http.authorizeRequests().antMatchers("/"
//				,"/oauth2/"
//				,"/shop"
//				,"/shop-page/**"
//				, "/service"
//				, "/dichvu-page/**"
//				, "/blog"
//				, "/baiviet-page/**"
//				, "/profile"
//				, "/editprofile"
//				, "/billhistory"
//				, "/cart"
//				, "/confirm"
//				, "/charge"
//				, "/login"
//				, "/chitietbill/**"
//				, "/logout").permitAll();
//		
//		http.authorizeRequests().antMatchers("/admin"
//				,"/services"
//				, "/service-page/**"
//				, "/newservices"
//				, "/editservice/**"
//				, "/servicecategories"
//				, "/product"
//				, "/product-page/**"
//				, "/newproduct"
//				, "/editproduct/**"
//				, "/productcategories"
//				, "/editproductcategories/**"
//				, "/newproductcategories"
//				, "/blogindex"
//				, "/blog-page/**"
//				, "/newblog"
//				, "/editblog/**"
//				, "/adminbill"
//				, "/bill-page/**").access("hasAnyRole('ROLE_ADMIN','ROLE_STAFF')");
//
//		http.authorizeRequests().antMatchers("/user","/edituser/**").access("hasRole('ROLE_ADMIN')");
//		http.authorizeRequests().antMatchers(
//				 "/registration**",
//				 "/**",
//	                "/js/**",
//	                "/css/**",
//	                "/img/**",
//	                "/plugins/**").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//			.loginPage("/login")
//			.usernameParameter("email")
//			.passwordParameter("password")
//			.defaultSuccessUrl("/")
//			.permitAll()
//		.and()
//		.oauth2Login()
//        .loginPage("/login")
//        .userInfoEndpoint().userService(oauth2UserService)
//        	.and()
//        	.successHandler(oAuth2LoginSuccessHandler)
//        .and()
//		.logout()
//		.invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/login?logout")
//		.permitAll()
//		.and()
//		.rememberMe().tokenRepository(PersistentTokenRepository());
	
		
		http.authorizeRequests()
		.antMatchers("/"
				,"/oauth2/**"
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
				, "/logout").permitAll()
		.antMatchers("/admin"
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
				, "/bill-page/**").access("hasAnyRole('ROLE_ADMIN','ROLE_STAFF')")
		.antMatchers("/user","/edituser/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers(
				 "/registration**",
				 "/**",
	                "/js/**",
	                "/css/**",
	                "/img/**",
	                "/plugins/**").permitAll()
		.anyRequest().permitAll()
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/")
		.and()
		.oauth2Login()
			.loginPage("/login")
			.userInfoEndpoint().userService(oauth2UserService)
			.and()
			.successHandler(oAuth2LoginSuccessHandler)
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout")
		.permitAll()
		.and()
		.rememberMe().tokenRepository(PersistentTokenRepository());
	}
	private PersistentTokenRepository PersistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return null;
	}
	@Autowired
	private CustomOauth2UserService oauth2UserService; 
	
	@Autowired
	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
}
