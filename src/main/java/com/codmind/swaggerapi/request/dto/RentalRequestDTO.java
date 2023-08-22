package com.codmind.swaggerapi.request.dto;

import lombok.Data;

@Data
public class RentalRequestDTO {
	
	 private Integer id;
	 private Integer book_id;
	 private String start;
	 private String end;

}
