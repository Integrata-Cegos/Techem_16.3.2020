package de.techem.books;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import de.techem.books.warehouse.api.Book;
import de.techem.books.warehouse.api.BookException;
import de.techem.books.warehouse.impl.DatabaseBooksService;

//@Component
public class BooksApplication {

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
