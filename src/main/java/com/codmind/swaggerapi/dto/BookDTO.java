package com.codmind.swaggerapi.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import lombok.Data;



	@Entity
	@Table(name="BOOK")
	@Data	
	public class BookDTO implements Serializable {		
	 
		private static final long serialVersionUID = -4799572182426202594L;

		@Id		
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@ApiParam(name="Identificador",value="Identificador del libro")
		@NotEmpty(message = "El identificador debe estar informado")	
		  
		private Integer id;
		  
		@ApiParam(name="Titulo", value="Titulo del libro")	  
		@NotEmpty(message = "El titulo del libro debe estar informado")	  
		private String title;	
		  
		@ApiParam(name="Copias", value="Número de copias del libro")
		@NotEmpty(message = "El número de copias debe estar informado")	  
		private Long copys;	  
		  	
}
