package com.leo.rest.ws.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	
	private Integer id;
	
	@Size(min=2)
	private String name;
	
	@Past
	private Date bithdate;
	
	public User(Integer id, String name, Date bithdate) {
		super();
		this.id = id;
		this.name = name;
		this.bithdate = bithdate;
	}
	
	protected User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBithdate() {
		return bithdate;
	}
	public void setBithdate(Date bithdate) {
		this.bithdate = bithdate;
	}
	
	
}
