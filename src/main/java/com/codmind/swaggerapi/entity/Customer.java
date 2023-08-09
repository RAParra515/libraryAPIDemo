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
@Table(name="CUSTOMER")
@Data
public class Customer implements Serializable{	
	
	private static final long serialVersionUID = 4668660152454841293L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	@ApiParam(name="Identificador", value="Identificador del cliente")	
	@NotNull(message="The customer id must be entered")
	private Integer id;
	@ApiParam(name="Nombre", value="Nombre del cliente")
	@NotNull	
	@NotNull(message = "Name has to be entered")
	private String name;
	@ApiParam(name="Apellido", value="Apellido del cliente")
	@NotNull(message = "Surname has to be entered")	
	private String lastName;	  
	@ApiParam(name="Dirección", value="Dirección del domicilio del cliente")	
	@NotNull(message = "Adress has to be entered")
	private String address;	
	
}






