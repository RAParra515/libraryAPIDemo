package com.codmind.swaggerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.entity.Book;
import com.codmind.swaggerapi.services.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookController {
	
	@Autowired
	BookService service;

	@ApiOperation(value = "Get all books", notes = "returns a list of every book")
	@GetMapping(value = "books")	
	public ResponseEntity<List<Book>> findAll(){
		Iterable<Book> source = service.findAll();
		List<Book> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target); 
	}	
	
	@ApiOperation(value = "Get book by id", notes = "return a specific book")
	@GetMapping(value = "books/{BookId}")	
	public ResponseEntity<Book> findById(@NotEmpty(message = "el identificador ha de venir informado") @PathVariable("BookId") Integer BookId){
		service.findById(BookId);
		return ResponseEntity.ok(service.findById(BookId).get()); 
	}	
	
	@ApiOperation(value = "update one book", notes = "update a single book information")
	@PutMapping(value = "books/{BookId}")
	public ResponseEntity<Book> updateBook(@RequestBody BookDTO request, @PathVariable("BookId") Integer bookId){		
		
			Book Book = service.updateBook(request,bookId);
			return ResponseEntity.ok(Book);					
	}
	
	@ApiOperation(value = "create a book entry", notes = "adds a book registry to the system")
	@PostMapping(value = "books")
	public ResponseEntity<Book> createBook(@RequestBody BookDTO request){	
          
			Book Book = service.addBook(request);
			return ResponseEntity.ok(Book);		
	}
	
	@ApiOperation(value = "delete one specific book registry", notes = "deletes one book registry")
	@DeleteMapping(value = "Books/{BookId}")
	public ResponseEntity<?> deleteBook( @NotEmpty(message = "el identificador ha de venir informado") @PathVariable("BookId") Integer BookId) {
		service.deleteBook(BookId);
		return ResponseEntity.ok().build();		
	}

}
