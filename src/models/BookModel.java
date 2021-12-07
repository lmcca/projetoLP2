package models;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import entities.Book;
import entities.User;
import sql.BookSql;

public class BookModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookSql bookSql = new BookSql();
	
	public Book createBook(String title, String author, String sinopse, String cover, LocalDateTime dateLauch, User createdBy) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Book book = null;
		try {
			book = new Book(UUID.randomUUID().toString(), title, author, sinopse, cover, dateLauch, LocalDateTime.now(), null,createdBy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookSql.createBook(book);
		
		return book;
	}
	
	public Book getBookById(String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return bookSql.getBookById(bookId);
	}
	
	public ArrayList<Book> getBooksByTitle(String bookTitle) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return bookSql.getBooksByTitle(bookTitle);
	}

	public ArrayList<Book> getBooksByUser(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return bookSql.getBooksByUser(userId);
	}
	
	public ArrayList<Book> getAllBooks() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("aaaaaaaaaaah entrei");
		return bookSql.getAllBooks();
	}

	public ArrayList<Book> getBooksByCep(String cep) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("aaaaaaaaaaah entrei");
		return bookSql.getBooksByCep(cep);
	}
	
	public boolean updateBook(Book book) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		return bookSql.updateBook(book);
	}
	
	public boolean deleteBook(String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return bookSql.deleteBook(bookId);
	}
}
