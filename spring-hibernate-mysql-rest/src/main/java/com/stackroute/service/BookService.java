package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.exception.MovieAlreadyExistException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.model.Book;
import com.stackroute.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository cMatchRepository;
	
	
	public List<Book> getAllCMatches(){
		return cMatchRepository.findAllCMatch();
	}
	
	
	public Book addNewCMatch(Book cMatch) throws MovieAlreadyExistException {
		
		Boolean status = cMatchRepository.addNew(cMatch);
		if(status) {
			return cMatch;
		}
		throw new MovieAlreadyExistException();
	}
	
	public Book getCMatchById(String id) throws MovieNotFoundException {
		
		Book cMatch = cMatchRepository.findById(id);
		if(cMatch != null) {
			return cMatch;
		}
		
		throw new MovieNotFoundException();
	}

}
