package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(length = 20)
	private String name = "abc";

	@Column(name = "mob_number")
	private long mobileNumber;

	@Column(length = 20, unique = true)
	private String email;
 
	@Column(length = 20, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Roles role;

	boolean isActive;

	public User() {

	}

	public User(String name, long mobileNumber, String email, String password, Roles role, boolean isActive) {

		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}

}




















//
//
//
//package com.app.pojos;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Table;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//
//@Entity
//@Table(name = "users")
//public class User extends BaseEntity {
//
//	@Column(length = 20)
//	@NotBlank(message = "Name field can't be blank!")
//	private String name = "abc";
//
//	@Column(name = "mob_number")
//	private long mobileNumber;
//
//	@Column(length = 20, unique = true)
//	@Email(message = "Invalid email address")
//	private String email;
// 
//	@Pattern(regexp = "((?=.\\d)(?=.[a-z])(?=.[#@$]).{6,20})", message = "Blank or Invalid password")
//	@Column(length = 20, nullable = false)
//	private String password;
//
//	@Enumerated(EnumType.STRING)
//	private Roles role;
//
//	boolean isActive;
//
//	public User() {
//System.out.println("in ctor of :" + getClass().getName());
//	}
//
//	public User(String name, long mobileNumber, String email, String password, Roles role, boolean isActive) {
//
//		this.name = name;
//		this.mobileNumber = mobileNumber;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//		this.isActive = isActive;
//	}
//
//	public boolean isActive() {
//		return isActive;
//	}
//
//	public void setActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public long getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(long mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Roles getRole() {
//		return role;
//	}
//
//	public void setRole(Roles role) {
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password
//				+ ", role=" + role + "]";
//	}
//
//}