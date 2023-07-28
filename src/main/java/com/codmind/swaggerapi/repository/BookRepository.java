package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.codmind.swaggerapi.dto.BookDTO;

public interface BookRepository extends CrudRepository<BookDTO, Integer>{

}
