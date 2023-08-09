package com.codmind.swaggerapi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Entity
@Data
@Table(name="RENTAL")
public class Rental implements Serializable {
	
	private static final long serialVersionUID = -1328448104681778785L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiParam(name="Identificador", value="Idefinticador del Prestamo")
	@NotNull(message="The rental id must be entered")
	private Integer id;
	@ApiParam(name="Identificador del Libro", value="Identificador del Libro prestado")
	@NotNull( message = "Book id has to be entered")	
	private Integer book_id;
	@ApiParam(name="Fecha Inicio Prestamo (yyyy-mm-dd)", value="Fecha de comienzo del prestamo (yyyy-mm-dd)")	
	private LocalDate start;
	@ApiParam(name="Fecha Fin Prestamo (yyyy-mm-dd)", value="Fecha finalizacion prestamo (yyyy-mm-dd)")
	@NotNull( message = "Retrieval date has to be entered")	
	private LocalDate end;

}
