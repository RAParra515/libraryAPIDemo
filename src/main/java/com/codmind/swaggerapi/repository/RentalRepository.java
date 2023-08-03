package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.codmind.swaggerapi.dto.RentalDTO;

public interface RentalRepository extends CrudRepository< RentalDTO, Integer> {

}
