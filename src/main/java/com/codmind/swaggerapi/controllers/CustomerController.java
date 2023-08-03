package com.codmind.swaggerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
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

import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.services.CustomerService;

import io.swagger.annotations.ApiOperation;
import lombok.Data;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@ApiOperation(value = "Get all customers", notes = "returns a list of every customer")
	@GetMapping(value = "customers")	
	public ResponseEntity<List<CustomerDTO>> findAll(){
		Iterable<CustomerDTO> source = service.findAllCustomers();
		List<CustomerDTO> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target); 
	}	
	
	@ApiOperation(value = "updates customers data", notes = "updates a specific customer data")
	@PutMapping(value = "customers")
	public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO request){		
			CustomerDTO customer = service.updateCustomer(request);
			return ResponseEntity.ok(customer);					
	}
	
	@ApiOperation(value = "creates customer data", notes = "creates a specific customer data")
	@PostMapping(value = "customers")
	public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO request){		
			CustomerDTO customer = service.addCustomer(request);
			return ResponseEntity.ok(customer);		
	}
	
	@ApiOperation(value = "deletes customer data", notes = "deletes specific customer data")
	@DeleteMapping(value = "customers/{customerId}")
	public ResponseEntity<?> deleteCustomer( @NotEmpty(message = "el identificador ha de venir informado") @PathVariable("customerId") Integer customerId) {
		service.deleteCustomer(customerId);		
		return ResponseEntity.ok().build();		
	}
}
