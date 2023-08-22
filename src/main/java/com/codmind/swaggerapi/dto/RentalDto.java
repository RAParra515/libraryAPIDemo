package com.codmind.swaggerapi.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Data;


@Data
public class RentalDTO implements Serializable {
	
	private static final long serialVersionUID = -1328448104681778785L;
	
	@ApiParam(name="Identificador del Libro", value="Identificador del Libro prestado")
	@NotNull( message = "{rental.bookid.notnull}")	
	private Integer book_id;	
	@ApiParam(name="Fecha Fin Prestamo (yyyy-mm-dd)", value="Fecha finalizacion prestamo (yyyy-mm-dd)")
	@NotNull( message = "{rental.end.notnull}")	
	private String end;

}
