package de.techem.lukas.books.executable.booksapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import de.techem.lukas.books.library.booksservice.api.Book;
import de.techem.lukas.books.library.booksservice.api.BookException;
import de.techem.lukas.books.library.booksservice.impl.DatabaseBooksService;

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
