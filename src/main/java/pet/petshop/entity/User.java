package pet.petshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class User {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "avatar")
	private String avatar;
	@Enumerated(EnumType.STRING)
	@Column(name= "auth_provider")
	private AuthenticationProvider authProvider;
	public User() {
		// TODO Auto-generated constructor stub
	}




	public AuthenticationProvider getAuthProvider() {
		return authProvider;
	}




	public void setAuthProvider(AuthenticationProvider authProvider) {
		this.authProvider = authProvider;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}




	public User(String email, String password, String role, String name, String phone, String address,
			AuthenticationProvider authProvider) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.authProvider = authProvider;
	}

	
}