package com.codmind.swaggerapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class CustomerDTO {	

	  @Id
	  //@GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  private String name;
	  private String lastName;
	  private String address;

	  protected CustomerDTO() {}

	  public CustomerDTO(String name, String lastName,String address) {
	    this.setName(name);
	    this.setLastName(lastName);
	    this.setAddress(address);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	 
	
}






