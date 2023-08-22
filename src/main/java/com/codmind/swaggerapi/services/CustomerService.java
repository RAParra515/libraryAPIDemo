package com.codmind.swaggerapi.services;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.dto.CustomerDTO;
import com.codmind.swaggerapi.entity.Customer;
import com.codmind.swaggerapi.exception.DachserException;
import com.codmind.swaggerapi.repository.CustomerRepository;

@Service
public class CustomerService {

	  @Autowired
	  MessageSource messageSource;
	
	  @Autowired
	  CustomerRepository repository;
	  
	  @Autowired
	  private Validator validator;	
	  
	
	  
	  Locale locale = new Locale("es");
	  
	  public Customer addCustomer(CustomerDTO customerReq) {		
		  
		  Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerReq);
		   if (!violations.isEmpty()) {
	            StringBuilder sb = new StringBuilder();
	            for (ConstraintViolation<CustomerDTO> constraintViolation : violations) {
	                sb.append(constraintViolation.getMessage());
	            }
	            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
	        }
		   Customer customer = new Customer();
		   customer.setAddress(customerReq.getAddress());
		   customer.setLastName(customerReq.getLastName());
		   customer.setName(customerReq.getName());
		  			  
			  return repository.save(customer);			  
		  		  
	  }
	  
	  public Customer updateCustomer(CustomerDTO customerReq,Integer id) {	
		  
		  Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerReq);
		   if (!violations.isEmpty()) {
	            StringBuilder sb = new StringBuilder();
	            for (ConstraintViolation<CustomerDTO> constraintViolation : violations) {
	                sb.append(constraintViolation.getMessage());
	            }
	            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
	        }
		   Customer customer = new Customer();
		   customer.setId(id);
		   customer.setLastName(customerReq.getLastName());
		   customer.setName(customerReq.getName());
		   customer.setAddress(customerReq.getAddress());
		  if (repository.existsById(id)) {			  
			  return repository.save(customer);			  
		  }else {			  
			  throw new DachserException(messageSource.getMessage("error.customer.notfound", null, locale));			  
		  }		  
	  }

	  public void deleteCustomer(Integer id) {	
		  try {
			  repository.deleteById(id);	  
			  
		  }catch (Exception e) {
			// TODO: handle exception
		}
	  }
	  
	  public Iterable<Customer> findAllCustomers(){
		   return repository.findAll();
	  }
	  
}
