package com.chandan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column(name = "username", length = 50, nullable = false)
	private String userName;

	@Column(name = "password", length = 800, nullable = false)
	private String password;

	@Column(name = "role", length = 50)
	private String role;

	@Column(name = "full_name", length = 100)
	private String fullName;

	@Column(name = "country", length = 30)
	private String country;

	@Column(name = "enabled")
	private String enabled;

	@Column(name = "email")
	private String email;

	public UserInfo() {
		super();
	}

	public UserInfo(int id, String userName, String password, String role, String fullName, String country,
			String enabled, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.country = country;
		this.enabled = enabled;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
