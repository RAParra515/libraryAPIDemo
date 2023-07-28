package com.codmind.swaggerapi.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RENTAL")
public class RentalDto {
	

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long book_id;
	  private Date start;
	  private Date end;

	  protected RentalDto() {}

	  public RentalDto(Long id, Long book_id,Date start,Date end) {
		this.setId(id);
	    this.setBook_id(book_id);
	    this.setStart(start);
	    this.setEnd(end);
	  }

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	

}
