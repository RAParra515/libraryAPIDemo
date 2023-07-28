package com.codmind.swaggerapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.services.BookService;

@RestController
public class BookController {
	
	public BookController() {
//		users.add(new UserDTO(1L, "admin"));
//		users.add(new UserDTO(2L, "supervisor"));
//		users.add(new UserDTO(3L, "cajero"));
	
	}
	
	@Autowired
	BookService service;

	@GetMapping(value = "Books")	
	public ResponseEntity<List<BookDTO>> findAll(){
		Iterable<BookDTO> source = service.findAll();
		List<BookDTO> target = new ArrayList<>();
		source.forEach(target::add);
		return ResponseEntity.ok(target); 
	}	
	
	@PutMapping(value = "Books")
	public ResponseEntity<BookDTO> updateBook(BookDTO request){		
			BookDTO Book = service.updateBook(request);
			return ResponseEntity.ok(Book);					
	}
	
	@PostMapping(value = "Books")
	public ResponseEntity<BookDTO> createBook(BookDTO request){	
			BookDTO Book = service.addBook(request);
			return ResponseEntity.ok(Book);		
	}
	
	@DeleteMapping(value = "Books/{BookId}")
	public ResponseEntity<?> deleteBook( @PathVariable("BookId") Integer BookId) {
		service.deleteBook(BookId);
		return ResponseEntity.ok().build();		
	}

}
