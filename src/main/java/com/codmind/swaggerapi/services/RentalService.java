package com.codmind.swaggerapi.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.codmind.swaggerapi.dto.RentalDTO;
import com.codmind.swaggerapi.entity.Book;
import com.codmind.swaggerapi.entity.Rental;
import com.codmind.swaggerapi.exception.DachserException;
import com.codmind.swaggerapi.repository.RentalRepository;


@Service
public class RentalService {
	
	@Autowired
	MessageSource messageSource;
	
	Locale locale = new Locale("es");
	
	@Autowired
	RentalRepository repository;
	
	@Autowired
	BookService bookService;
	
	
	
	@Autowired
	private Validator validator;	
	
	Integer copysRented = 0;
	@Transactional
	public Rental addRental(RentalDTO rentalReq) {
		copysRented=0;
		
		  Set<ConstraintViolation<RentalDTO>> violations = validator.validate(rentalReq);
		   if (!violations.isEmpty()) {
	            StringBuilder sb = new StringBuilder();
	            for (ConstraintViolation<RentalDTO> constraintViolation : violations) {
	                sb.append(constraintViolation.getMessage());
	            }
	            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
	        }
		 
		 Book book =bookService.findById(rentalReq.getBook_id()).get(); 
		 
		 
		 Iterable<Rental> source = repository.findAll();
		 
		 List<Rental> rentals = new ArrayList<>();
		 Rental rental = new Rental();
		 
		 source.forEach(rentals::add);		 
		 rentals.forEach( el->{		
			
			 if(el.getBook_id().equals(rentalReq.getBook_id())) {
			
				 if(el.getEnd().getYear()>LocalDate.now().getYear()) {
					 copysRented++;
				 } else if (el.getEnd().getYear()==LocalDate.now().getYear()) {
					 if (el.getEnd().getDayOfYear()>=LocalDate.now().getDayOfYear())
						 copysRented++;			
				 }
			 }
		});
		 
		 
		  if ( copysRented >= book.getCopys() ) {
        	 
			  throw new DachserException(messageSource.getMessage("error.rental.notcopyavailable", null, locale));
			  
		 } else {
			 
			  
			  
			  
			  DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
			  LocalDate dateIni = LocalDate.now();
			  LocalDate dateFin = LocalDate.parse(rentalReq.getEnd(), formater);
			  rental.setBook_id(rentalReq.getBook_id());
			  rental.setStart(dateIni);
			  rental.setEnd(dateFin);			  
			   		  
			  
			  
			  return repository.save(rental);	
			  
		  }
	  }
	  
	  public Rental updateRental(RentalDTO rentalReq,Integer id) {
		  
		  Set<ConstraintViolation<RentalDTO>> violations = validator.validate(rentalReq);
		   if (!violations.isEmpty()) {
	            StringBuilder sb = new StringBuilder();
	            for (ConstraintViolation<RentalDTO> constraintViolation : violations) {
	                sb.append(constraintViolation.getMessage());
	            }
	            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
	        }
		  
		  if (repository.existsById(id)) {
			  
			  Rental rental = new Rental();		  
			  rental.setBook_id(rentalReq.getBook_id());
			  
			  DateTimeFormatter formater = DateTimeFormatter.ISO_LOCAL_DATE;
			  //LocalDate dateIni = LocalDate.parse(rentalReq.getStart(), formater);
			  LocalDate dateFin = LocalDate.parse(rentalReq.getEnd(), formater);	
			  
			  
			  //rental.setStart(dateIni);
			  rental.setEnd(dateFin);
			  rental.setId(id);
			  
			  return repository.save(rental);
			  
		  } else {
			  
			  throw new DachserException(messageSource.getMessage("error.rental.notfound", null, locale));
			  
		  }		  
	  }

	  public void deleteRental(Integer id) {
		  
		  try {
			  repository.deleteById(id);	
			  
		  }catch (Exception e) {
			// TODO: handle exception
		}
 
		  
	  }
	  
	  public Iterable<Rental> findAllRentals(){
		   return repository.findAll();
	  }
	  
	  public Optional<Rental> findById(Integer id){		
		  return repository.findById(id);
	  }
	  
}
