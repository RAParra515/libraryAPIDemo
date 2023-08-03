package com.codmind.swaggerapi.services;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.repository.BookRepository;


@Service
public class BookService {
	
	 @Autowired
	 MessageSource messageSource;
	
	 @Autowired
	 BookRepository repository;
	 
	 Locale locale = new Locale("es");
		
	
	 
	 public BookDTO addBook(BookDTO bookDto) throws RuntimeException{
		 
		 if (repository.existsById(bookDto.getId())) {
			 throw new RuntimeException( messageSource.getMessage("error.book.alreadyExist", null, locale)	);
		 } else {
			 return repository.save(bookDto);			 
		 }
	 }
	 
	 public BookDTO updateBook(BookDTO bookDto) {
		 
		 if (repository.existsById(bookDto.getId())) {
			 return repository.save(bookDto);			 
		 } else {
			 throw new RuntimeException(messageSource.getMessage("error.book.notfound", null, locale));
		 }
	 }
	 
	 public void deleteBook(Integer id) {		 
	 
		 repository.deleteById(id);
		 
	 }
	 
	 public Iterable<BookDTO> findAll(){
		 
		 return repository.findAll();
		 
	 }
	 public Optional<BookDTO> findById(Integer id){		 
		 return repository.findById(id);		 
	 }

}
