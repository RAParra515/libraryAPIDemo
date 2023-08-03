package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.codmind.swaggerapi.dto.CustomerDTO;

public interface CustomerRepository extends CrudRepository<CustomerDTO, Integer> {

	

}
