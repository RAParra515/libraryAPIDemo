package com.codmind.swaggerapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiParam;
import lombok.Data;	
	
	@Data	
	public class BookDTO implements Serializable {
	
		private static final long serialVersionUID = -6343055759648843235L;
		
		@ApiParam(name="Titulo", value="Titulo del libro")
		@NotNull(message = "{book.title.notnull}")
		private String title;	
		  
		@ApiParam(name="Copias", value="Número de copias del libro")
		@NotNull(message = "{book.copy.notnull}")		
		private Integer copys;	  
		  	
}
