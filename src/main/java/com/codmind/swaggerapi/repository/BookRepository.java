package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codmind.swaggerapi.dto.BookDTO;

@Repository
public interface BookRepository extends CrudRepository<BookDTO, Integer>{

}
