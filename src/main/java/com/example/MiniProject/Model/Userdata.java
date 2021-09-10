package com.example.MiniProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Userdata {
	
	@Id

	private String email;
	private int id;
	private String name;
	private String password;
	private String type;
	
	
	
	public Userdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Userdata(String email, int id, String name, String password, String type) {
		this.email = email;
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Userdata [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", type="
				+ type + "]";
	}
	
	
	
}
