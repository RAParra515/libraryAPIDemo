package com.codmind.swaggerapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.repository.CustomerRepository;

@Service
public class CustomerService {

	
	  @Autowired
	  CustomerRepository repository;
	  
	  public CustomerDTO addCustomer(CustomerDTO customer) {		  
		  if (repository.existsById(customer.getId())) {			  
			  throw new RuntimeException("el cliente ya existe");			  
		  }else {			  
			  return repository.save(customer);			  
		  }		  
	  }
	  
	  public CustomerDTO updateCustomer(CustomerDTO customer) {		  
		  if (repository.existsById(customer.getId())) {			  
			  return repository.save(customer);			  
		  }else {			  
			  throw new RuntimeException("el cliente no existe");			  
		  }		  
	  }

	  public void deleteCustomer(Integer id) {		  
		    repository.deleteById(id);	  
	  }
	  
	  public Iterable<CustomerDTO> findAllCustomers(){
		   return repository.findAll();
	  }
	  
}
