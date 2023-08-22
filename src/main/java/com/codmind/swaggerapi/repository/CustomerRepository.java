package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codmind.swaggerapi.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	

}
