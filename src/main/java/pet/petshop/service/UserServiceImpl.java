package pet.petshop.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pet.petshop.dto.UserRegistrationDto;
import pet.petshop.entity.AuthenticationProvider;
import pet.petshop.entity.User;
import pet.petshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User Regis(User registrationDto) {
		User user = new User(registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				"ROLE_USER",registrationDto.getName(),registrationDto.getPhone(),registrationDto.getAddress(),AuthenticationProvider.LOCAL);

		return userRepository.save(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				Arrays.asList(authority));
	}

	public User loadUserByUsername2(String name) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(name);
		return user;
	}

	
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	public boolean userExist(String email) {
		return findUserByEmail(email).isPresent();
	}
}