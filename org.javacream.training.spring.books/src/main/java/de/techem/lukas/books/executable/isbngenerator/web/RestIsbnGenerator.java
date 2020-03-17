package de.techem.lukas.books.executable.isbngenerator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator;
import de.techem.lukas.books.library.isbngenerator.api.IsbnGenerator.RandomStrategy;

@RestController
public class RestIsbnGenerator {

	@Autowired @RandomStrategy private IsbnGenerator isbnGenerator;

	@PostMapping(path = "isbngenerator", produces = MediaType.TEXT_PLAIN_VALUE)
	public String create() {
		return isbnGenerator.next();
	}
	
	
}
