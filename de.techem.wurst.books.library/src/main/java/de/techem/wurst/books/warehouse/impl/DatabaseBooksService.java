package de.techem.wurst.books.warehouse.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.techem.wurst.books.isbngenerator.api.IsbnGenerator;
import de.techem.wurst.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import de.techem.wurst.books.store.RestStoreService;
import de.techem.wurst.books.warehouse.api.Book;
import de.techem.wurst.books.warehouse.api.BookException;
import de.techem.wurst.books.warehouse.api.BooksService;

@Repository
public class DatabaseBooksService implements BooksService {

	@Autowired
	@SequenceStrategy
	private IsbnGenerator isbnGenerator;
	
	//@Autowired
	//private StoreService storeService;
	
//	public void setStoreService(StoreService storeService) {
//		this.storeService = storeService;
//	}
	
	@Autowired
	private RestStoreService restStoreService;

	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		entityManager.persist(book);
		return isbn;
	}

	public IsbnGenerator getIsbnGenerator() {
		return isbnGenerator;
	}

	@Transactional
	public Book findBookByIsbn(String isbn) throws BookException {
		try {
			System.out.println("findBookByIsbn: " + isbn);
			Book result = entityManager.find(Book.class, isbn);
			System.out.println("result findBookByIsbn: " + isbn);
			result.setAvailable(restStoreService.getStock("books", isbn) > 0);
			System.out.println("set findBookByIsbn: " + isbn);
			return result;
		} catch (NullPointerException e) {
			System.out.println(e);
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, isbn);
		}
	}

	@Transactional
	public Book updateBook(Book bookValue) throws BookException {
		try {
			entityManager.merge(bookValue);
			return bookValue;
		} catch (Exception nre) {
			throw new BookException(BookException.BookExceptionType.NOT_FOUND, bookValue.getIsbn());
		}
	}

	@Transactional
	public void deleteBookByIsbn(String isbn) throws BookException {
			Book toDelete = entityManager.find(Book.class, isbn);
			if (toDelete == null){
				throw new BookException(BookException.BookExceptionType.NOT_DELETED, isbn);
				
			}
			entityManager.remove(toDelete);
	}

	public Collection<Book> findAllBooks() {
		TypedQuery<Book> query = entityManager.createQuery("select b from Book as b", Book.class);
		return query.getResultList();
	}

}
