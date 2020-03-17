package org.techem.training.springcloud.artisse.books;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;



public class BooksApplikation {
	@Autowired private DatabaseBooksService mapBooksService;
	@PostConstruct
	public void doBooksApplication() {
		System.out.println("Starting Books-App");
		try {
			String isbn = mapBooksService.newBook("Spring");
			System.out.println("Generated isbn: " + isbn);
			Book book = mapBooksService.findBookByIsbn(isbn);
			System.out.println("Found book: " + book);
		} catch (BookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Books-App finished");
		
	}
}
