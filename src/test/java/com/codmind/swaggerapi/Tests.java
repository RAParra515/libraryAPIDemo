package com.codmind.swaggerapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.dto.RentalDTO;
import com.codmind.swaggerapi.entity.Rental;
import com.codmind.swaggerapi.services.BookService;
import com.codmind.swaggerapi.services.RentalService;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
  classes = SwaggerApiApplication.class)
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class Tests {
	
	
	@Autowired
	RentalService service;
	
	@Autowired
	BookService serviceBook;
	
	@Test 	
	public void createRental() {		
		
		BookDTO book = new BookDTO();
		book.setCopys(3);
		book.setTitle("asd");
		serviceBook.addBook(book);
		RentalDTO rental = new RentalDTO();
		rental.setBook_id(1);
		rental.setEnd("3333-02-02");		
		Rental rentalRetrive = service.addRental(rental);
		assertThat(rental.getEnd().startsWith("3333"));
		
	}
	
	
	@Test 	
	public void deleteRental() {		
		service.deleteRental(1);		
		assertThat(service.findById(1).isEmpty());
	}
}

    
