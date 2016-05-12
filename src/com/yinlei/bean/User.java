package com.yinlei.bean;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {

	private String username;
	private String[] password;
	private String gander;
	private String[] loves;
	private String country;
	private String description;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String[] getPassword() {
		return password;
	}

	public void setPassword(String[] password) {
		this.password = password;
	}

	public String getGander() {
		return gander;
	}

	public void setGander(String gander) {
		this.gander = gander;
	}

	public String[] getLoves() {
		return loves;
	}

	public void setLoves(String[] loves) {
		this.loves = loves;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User(String username, String[] password, String gander, String[] loves, String country, String description) {
		super();
		this.username = username;
		this.password = password;
		this.gander = gander;
		this.loves = loves;
		this.country = country;
		this.description = description;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + Arrays.toString(password) + ", gander=" + gander
				+ ", loves=" + Arrays.toString(loves) + ", country=" + country + ", description=" + description + "]";
	}

}
