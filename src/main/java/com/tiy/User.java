package com.tiy;

import javax.persistence.*;

/**
 * Created by Brett on 9/15/16.
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	int id;

	@Column(nullable = false, unique = true)
	String name;

	@Column(nullable = false)
	String password;

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
