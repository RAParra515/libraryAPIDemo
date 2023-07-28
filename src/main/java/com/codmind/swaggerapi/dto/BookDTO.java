package com.codmind.swaggerapi.dto;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="BOOK")
	public class BookDTO {

	  @Id	 
	  private Integer id;
	  public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	private String title;
	private Long copys;
	  

	  protected BookDTO() {}
	  public BookDTO(Integer id, String title,Long copys) {
	    this.setId(id);;
	    this.setTitle(title);
	    this.setCopys(copys);
	  }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCopys() {
		return copys;
	}
	public void setCopys(Long copys) {
		this.copys = copys;
	}
	
}
