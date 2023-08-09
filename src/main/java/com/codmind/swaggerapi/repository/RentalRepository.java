package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codmind.swaggerapi.entity.Rental;
@Repository
public interface RentalRepository extends CrudRepository< Rental, Integer> {

}
