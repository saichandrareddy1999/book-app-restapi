package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Book;
import com.stackroute.service.BookService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class BookController {
	
	
	@Autowired
	private BookService cMatchService;

	@RequestMapping(value = "/favourite", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCMatchHandler() {
		System.out.println("Get All movie handler invoked");
		
		List<Book> cMatchList = cMatchService.getAllCMatches();
		
		return new ResponseEntity<List<Book>>(cMatchList,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/favourite", method = RequestMethod.POST)
	public ResponseEntity<?> addNewCMatchHandler(@RequestBody Book cMatch) {
		System.out.println(" Add movie handler invoked");
		
		ResponseEntity<?> respEntity;
		
		try {
			Book newCMatch = cMatchService.addNewCMatch(cMatch);
			respEntity =  new ResponseEntity<Book>(newCMatch,HttpStatus.CREATED);
		} catch(Exception ex) {
			respEntity =  new ResponseEntity<String>("Failed to add",HttpStatus.CONFLICT);
		}
		return respEntity;	
		
	}	
	
}

//resource, headers, statuscode - ResponseEntity