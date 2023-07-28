package com.codmind.swaggerapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.repository.BookRepository;


@Service
public class BookService {
	
	 @Autowired
	 BookRepository repository;
	 
	 public BookDTO addBook(BookDTO bookDto) {
		 
		 if (repository.existsById(bookDto.getId())) {
			 throw new RuntimeException("Ya existe un libro con ese identificador");
		 } else {
			 return repository.save(bookDto);			 
		 }
	 }
	 
	 public BookDTO updateBook(BookDTO bookDto) {
		 
		 if (repository.existsById(bookDto.getId())) {
			 return repository.save(bookDto);			 
		 } else {
			 throw new RuntimeException("No existe un libro con ese identificador");
		 }
	 }
	 
	 public void deleteBook(Integer id) {		 
	 
		 repository.deleteById(id);
		 
	 }
	 
	 public Iterable<BookDTO> findAll(){
		 
		 return repository.findAll();
		 
	 }

}
