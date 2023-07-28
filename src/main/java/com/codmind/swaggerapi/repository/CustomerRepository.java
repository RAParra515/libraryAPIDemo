package com.codmind.swaggerapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codmind.swaggerapi.dto.CustomerDTO;

public interface CustomerRepository extends CrudRepository<CustomerDTO, Integer> { 
	
//	List<CustomerDTO> findByLastName(String lastName);
//	
//	List<CustomerDTO> findAll();
//
//	CustomerDTO findById(long id);
//	
//	//CustomerDTO save(CustomerDTO customerDto);
//	
//	void deleteById(long id);
//
//	boolean existsById(long id);
	

}
