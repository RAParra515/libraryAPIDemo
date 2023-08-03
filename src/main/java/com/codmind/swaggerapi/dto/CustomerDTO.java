package com.codmind.swaggerapi.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Entity
@Table(name="CUSTOMER")
@Data
public class CustomerDTO implements Serializable{	
	
	private static final long serialVersionUID = 4668660152454841293L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	@ApiParam(name="Identificador", value="Identificador del cliente")
	@NotNull
	@NotBlank(message = "el identificador debe estar informado")
	private Integer id;
	@ApiParam(name="Nombre", value="Nombre del cliente")
	@NotNull
	@NotBlank(message = "el nombre del cliente debe estar informado")
	private String name;
	@ApiParam(name="Apellido", value="Apellido del cliente")
	@NotNull
	@NotBlank(message = "el apellido debe estar informado")
	private String lastName;	  
	@ApiParam(name="Dirección", value="Dirección del domicilio del cliente")
	@NotNull
	@NotBlank(message = "la dirección debe estar informado")
	private String address;	
	
}






