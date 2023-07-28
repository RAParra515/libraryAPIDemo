package com.codmind.swaggerapi.dto;


public class UserDTO {

	private long id;
	private String name;
	private String lastName;
	private String address;

	public UserDTO() {	}
	
	public UserDTO(long id, String name,String lastName, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	


	
	

	
	
	
	
}
