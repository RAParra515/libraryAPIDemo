package com.codmind.swaggerapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
