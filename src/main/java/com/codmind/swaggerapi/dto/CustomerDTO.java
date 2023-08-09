package com.codmind.swaggerapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Data;


@Data
public class CustomerDTO implements Serializable{
	
	private static final long serialVersionUID = 7942618416814516305L;
	
	@ApiParam(name="Nombre", value="Nombre del cliente")
	@NotNull	
	@NotNull(message = "{customer.name.notnull}")
	private String name;
	@ApiParam(name="Apellido", value="Apellido del cliente")
	@NotNull(message = "{customer.lastname.notnull}")	
	private String lastName;	  
	@ApiParam(name="Dirección", value="Dirección del domicilio del cliente")	
	@NotNull(message ="{customer.address.notnull}")
	private String address;	
	
}






