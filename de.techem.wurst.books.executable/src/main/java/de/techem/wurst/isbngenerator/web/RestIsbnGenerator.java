package de.techem.wurst.isbngenerator.web;

import de.techem.wurst.books.isbngenerator.api.IsbnGenerator;
import de.techem.wurst.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestIsbnGenerator {

	@Autowired @RandomStrategy private IsbnGenerator isbnGenerator;

	@PostMapping(path = "isbngenerator", produces = MediaType.TEXT_PLAIN_VALUE)
	public String create() {
		return isbnGenerator.next();
	}
	
	
}
