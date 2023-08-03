package com.codmind.swaggerapi.services;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.repository.CustomerRepository;

@Service
public class CustomerService {

	  @Autowired
	  MessageSource messageSource;
	
	  @Autowired
	  CustomerRepository repository;
	  
	  Locale locale = new Locale("es");
	  
	  public CustomerDTO addCustomer(CustomerDTO customer) {		  
		  if (repository.existsById(customer.getId())) {			  
			  throw new RuntimeException(messageSource.getMessage("error.customer.aleadyExist", null, locale));			  
		  }else {			  
			  return repository.save(customer);			  
		  }		  
	  }
	  
	  public CustomerDTO updateCustomer(CustomerDTO customer) {		  
		  if (repository.existsById(customer.getId())) {			  
			  return repository.save(customer);			  
		  }else {			  
			  throw new RuntimeException(messageSource.getMessage("error.customer.notfound", null, locale));			  
		  }		  
	  }

	  public void deleteCustomer(Integer id) {		  
		    repository.deleteById(id);	  
	  }
	  
	  public Iterable<CustomerDTO> findAllCustomers(){
		   return repository.findAll();
	  }
	  
}
