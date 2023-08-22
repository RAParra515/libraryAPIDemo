package com.codmind.swaggerapi.services;

import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.entity.Book;
import com.codmind.swaggerapi.exception.DachserException;
import com.codmind.swaggerapi.repository.BookRepository;


@Service
public class BookService {
	
	 @Autowired
	 MessageSource messageSource;
	
	 @Autowired
	 BookRepository repository;
	 
	 @Autowired
	 private Validator validator;	
	 
	
		
	 Locale locale = new Locale("en");
	
	 
	 public Book addBook(BookDTO bookDto) throws RuntimeException{
		 
	  Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDto);
	   if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<BookDTO> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }		 
		Book book = new Book();
	   book.setCopys(bookDto.getCopys());
	   book.setTitle(bookDto.getTitle());
			 return repository.save(book);			 
		
	 }
	 
	 public Book updateBook(BookDTO bookDto,Integer bookId) {
		 
		 Set<ConstraintViolation<BookDTO>> violations = validator.validate(bookDto);
		   if (!violations.isEmpty()) {
	            StringBuilder sb = new StringBuilder();
	            for (ConstraintViolation<BookDTO> constraintViolation : violations) {
	                sb.append(constraintViolation.getMessage());
	            }
	            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
	        }
		   
		   Book book = new Book();
		 if (repository.existsById(bookId)) {
			 book.setId(bookId);
			 book.setCopys(bookDto.getCopys());
			 book.setTitle(bookDto.getTitle());
			 return repository.save(book);			 
		 } else {
			 throw new DachserException(messageSource.getMessage("error.book.notfound", null, locale));
		 }
	 }
	 
	 public void deleteBook(Integer id) {		 
	 try {
		 repository.deleteById(id);		 
	 }catch (Exception e){
		 
	 }
		 
	 }
	 
	 public Iterable<Book> findAll(){
		 
		 return repository.findAll();
		 
	 }
	 public Optional<Book> findById(Integer id){		 
		 
		 if(repository.existsById(id)) {
			 return repository.findById(id);
		 } else {
			 throw new DachserException(messageSource.getMessage("error.book.notfound", null, locale));
		 }
		 
	 }

}
