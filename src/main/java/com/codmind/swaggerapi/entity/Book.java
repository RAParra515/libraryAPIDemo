package com.codmind.swaggerapi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Data;



	@Entity	
	@Table(name="BOOK")
	@Data	
	public class Book implements Serializable {
	 
		private static final long serialVersionUID = -4799572182426202594L;

		@Id		
		@GeneratedValue(strategy=GenerationType.SEQUENCE)		
		@ApiParam(name="Identificador",value="Identificador del libro")
		@NotNull(message="The book id must be entered")
		private Integer id;
		  
		@ApiParam(name="Titulo", value="Titulo del libro")
		@NotNull(message = "The book title must be specified")
		private String title;	
		  
		@ApiParam(name="Copias", value="Número de copias del libro")
		@NotNull(message = "Book copyes must not be null")		
		private Integer copys;	  
		  	
}
