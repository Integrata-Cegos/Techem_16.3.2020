package org.javacream.books.warehouse.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import de.techem.lukas.books.library.booksservice.api.Book;
import de.techem.lukas.books.library.booksservice.api.BookException;
import de.techem.lukas.books.library.booksservice.api.BooksService;

public class TestActor {

	public static void doTest(BooksService booksService) {
		try {
			Collection<Book> books = booksService.findAllBooks();
			final int startSize = books.size();
			String j2eeTitle = "Spring";
			String isbn = booksService.newBook(j2eeTitle);
			books = booksService.findAllBooks();
			final int endSize = books.size();
			assertTrue(endSize == startSize + 1);
			assertNotNull(isbn);
			assertNotNull(booksService.findBookByIsbn(isbn));

			try {
				booksService.findBookByIsbn("ISBN-3");
				fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}
			booksService.deleteBookByIsbn(isbn);
			assertTrue(startSize == booksService.findAllBooks().size());
			try {
				booksService.deleteBookByIsbn(isbn);
				fail("BookException must be thrown!");
			} catch (BookException e) {
				// OK
			}

		} catch (BookException bookException) {
			bookException.printStackTrace();
			fail(bookException.getMessage());
		}

	}

}
