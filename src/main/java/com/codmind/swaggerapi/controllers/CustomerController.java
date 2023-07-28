package com.codmind.swaggerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@GetMapping(value = "customers")	
	public ResponseEntity<List<CustomerDTO>> findAll(){
		Iterable<CustomerDTO> source = service.findAllCustomers();
		List<CustomerDTO> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target); 
	}	
	
	@PutMapping(value = "customers")
	public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO request){		
			CustomerDTO customer = service.updateCustomer(request);
			return ResponseEntity.ok(customer);					
	}
	
	@PostMapping(value = "customers")
	public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO request){		
			CustomerDTO customer = service.addCustomer(request);
			return ResponseEntity.ok(customer);		
	}
	
	@DeleteMapping(value = "customers/{customerId}")
	public ResponseEntity<?> deleteCustomer( @PathVariable("customerId") Integer customerId) {
		service.deleteCustomer(customerId);		
		return ResponseEntity.ok().build();		
	}
}
