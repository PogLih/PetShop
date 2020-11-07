package pet.petshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "username")
    private String Username;
    @Column(name = "password")
    private String Password;
    @Column(name = "role")
    private boolean Role;
    @Column(name = "fullname")
    private String Fullname;
    @Column(name = "address")
    private String Address;
    @Column(name = "phone")
    private String Phone;
    @Column(name = "email")
    private String Email;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean role) {
        Role = role;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
