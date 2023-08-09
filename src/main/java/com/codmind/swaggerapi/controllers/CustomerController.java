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

import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.entity.Customer;
import com.codmind.swaggerapi.services.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@ApiOperation(value = "Get all customers", notes = "returns a list of every customer")
	@GetMapping(value = "customers")	
	public ResponseEntity<List<Customer>> findAll(){
		Iterable<Customer> source = service.findAllCustomers();
		List<Customer> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target); 
	}	
	
	@ApiOperation(value = "updates customers data", notes = "updates a specific customer data")
	@PutMapping(value = "customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO request,@PathVariable("customerId") Integer customerId){		
			Customer customer = service.updateCustomer(request,customerId);
			return ResponseEntity.ok(customer);					
	}
	
	@ApiOperation(value = "creates customer data", notes = "creates a specific customer data")
	@PostMapping(value = "customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO request){		
			Customer customer = service.addCustomer(request);
			return ResponseEntity.ok(customer);		
	}
	
	@ApiOperation(value = "deletes customer data", notes = "deletes specific customer data")
	@DeleteMapping(value = "customers/{customerId}")
	public ResponseEntity<?> deleteCustomer( @NotEmpty(message = "el identificador ha de venir informado") @PathVariable("customerId") Integer customerId) {
		service.deleteCustomer(customerId);		
		return ResponseEntity.ok().build();		
	}
}
