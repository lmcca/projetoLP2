package models;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import entities.Book;
import entities.User;
import sql.BookSql;

public class BookModel {
	private BookSql bookSql = new BookSql();
	
	public Book createBook(String title, String author, String sinopse, String cover, LocalDateTime dateLauch, User createdBy) throws SQLException {
		Book book = new Book(UUID.randomUUID().toString(), title, author, sinopse, cover, dateLauch, LocalDateTime.now(), null,createdBy );
		
		bookSql.createBook(book);
		
		return book;
	}
	
	public Book getBookById(String bookId) throws SQLException {
		return bookSql.getBookById(bookId);
	}
	
	public ArrayList<Book> getBooksByTitle(String bookTitle) throws SQLException {
		return bookSql.getBooksByTitle(bookTitle);
	}
	
	public ArrayList<Book> getAllBooks() throws SQLException {
		return bookSql.getAllBooks();
	}
	
	public boolean updateBook(Book book) throws SQLException{
		return bookSql.updateBook(book);
	}
	
	public boolean deleteBook(String bookId) throws SQLException {
		return bookSql.deleteBook(bookId);
	}
}
