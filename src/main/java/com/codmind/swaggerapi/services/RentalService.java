package com.codmind.swaggerapi.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.codmind.swaggerapi.dto.BookDTO;
import com.codmind.swaggerapi.dto.RentalDTO;
import com.codmind.swaggerapi.exception.DachserException;
import com.codmind.swaggerapi.repository.RentalRepository;
import com.codmind.swaggerapi.request.dto.RentalRequestDTO;

@Service
public class RentalService {
	
	@Autowired
	MessageSource messageSource;
	
	Locale locale = new Locale("es");
	
	@Autowired
	RentalRepository repository;
	
	@Autowired
	BookService bookService;
	
	Integer copysRented = 0;
	
	public RentalDTO addRental(RentalRequestDTO rental) {
		 
		 BookDTO book = new BookDTO();
		 
		 try {
			 
			 book = bookService.findById(rental.getBook_id()).get();
			 
		 } catch(Exception e) {
			 
			 throw new DachserException(messageSource.getMessage("error.book.notFound", null, locale));
		 }
		 
		 Iterable<RentalDTO> source = repository.findAll();
		 
		 List<RentalDTO> rentals = new ArrayList<>();
		 
		 source.forEach(rentals::add);
		 
		 rentals.forEach( el->{
			 
			 if(el.getBook_id()==rental.getBook_id()) {
				 if(el.getEnd().getYear()>LocalDate.now().getYear() && el.getEnd().getDayOfYear()>LocalDate.now().getDayOfYear()){
					 copysRented++;				
				 }
			 }
		});
		 
		 if (repository.existsById(rental.getId())) {
			 
			  throw new DachserException(messageSource.getMessage("error.rental.alreadyExist", null, locale));
			  
         } else if ( copysRented >= book.getCopys() ) {
        	 
			  throw new DachserException(messageSource.getMessage("error.rental.notCopyAvailable", null, locale));
			  
		 } else {
			 
			  RentalDTO rentalDto = new RentalDTO();
			  rentalDto.setBook_id(rental.getId());
			  
			  DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
			  LocalDate dateIni = LocalDate.now();
			  LocalDate dateFin = LocalDate.parse(rental.getEnd(), formater);
			  
			  rentalDto.setStart(dateIni);
			  rentalDto.setEnd(dateFin);
			  
			  rentalDto.setId(rental.getId()); 		  
			  book.setCopys(book.getCopys()-1);
			  
			  bookService.updateBook(book);
			  
			  return repository.save(rentalDto);	
			  
		  }
	  }
	  
	  public RentalDTO updateRental(RentalRequestDTO rental) {
		  
		  if (repository.existsById(rental.getId())) {
			  
			  RentalDTO rentalDto = new RentalDTO();			  
			  rentalDto.setBook_id(rental.getId());
			  
			  DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
			  LocalDate dateIni = LocalDate.parse(rental.getStart(), formater);
			  LocalDate dateFin = LocalDate.parse(rental.getEnd(), formater);	
			  
			  
			  rentalDto.setStart(dateIni);
			  rentalDto.setEnd(dateFin);
			  rentalDto.setId(rental.getId());
			  
			  return repository.save(rentalDto);
			  
		  } else {
			  
			  throw new DachserException(messageSource.getMessage("error.rental.notfound", null, locale));
			  
		  }		  
	  }

	  public void deleteRental(Integer id) {
		  
		  if (repository.existsById(id)) {
			  
			  RentalDTO rental = findById(id).get();
			  repository.deleteById(id);			  
			  BookDTO book = bookService.findById(rental.getBook_id()).get();
			  book.setCopys(book.getCopys()+1);
			  bookService.updateBook(book);
			  
		  } 
		  
	  }
	  
	  public Iterable<RentalDTO> findAllRentals(){
		   return repository.findAll();
	  }
	  
	  public Optional<RentalDTO> findById(Integer id){		
		  return repository.findById(id);
	  }
	  
}
