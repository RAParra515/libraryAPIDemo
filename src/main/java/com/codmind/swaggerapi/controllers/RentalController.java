package com.codmind.swaggerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codmind.swaggerapi.dto.RentalDTO;
import com.codmind.swaggerapi.entity.Rental;
import com.codmind.swaggerapi.request.dto.RentalRequestDTO;
import com.codmind.swaggerapi.services.RentalService;

import io.swagger.annotations.ApiOperation;

@RestController
public class RentalController {

	@Autowired
	RentalService service;

	@ApiOperation(value = "retrieves a list of al rentals", notes = "retrieves a list of al rentals")
	@GetMapping(value = "rentals")
	public ResponseEntity<List<Rental>> findAll(){
		
		Iterable<Rental> source = service.findAllRentals();
		List<Rental> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target);
		
	}	
	
	@ApiOperation(value = "updates rental data", notes = "updates specific rental data")
	@PutMapping(value = "rentals/{rentalsId}")
	public ResponseEntity<Rental> updateRental( @RequestBody RentalDTO request,@PathVariable("rentalsId") Integer rentalId){	
		
		Rental rental = service.updateRental(request,rentalId);
		return ResponseEntity.ok(rental);
			
	}
	
	@ApiOperation(value = "checks id there are copys available of the requested book creates rental data", notes = "creates rental data")
	@PostMapping(value = "rentals")
	public ResponseEntity<Rental> createRental( @RequestBody RentalDTO request) {
		
		
		Rental rental = service.addRental(request);
		return ResponseEntity.ok(rental);
		
	}
	
	@ApiOperation(value = "deletes rental data and add a copy of the rental book to the library", notes = "deletes specific rental data")
	@DeleteMapping(value = "rentals/{rentalsId}")
	public ResponseEntity<?> deleteRental( @NotEmpty(message = "el identificador ha de venir informado") @PathVariable("rentalsId") Integer rentalId) {
		
		service.deleteRental(rentalId);		
		return ResponseEntity.ok().build();
		
	}
}