package controllers;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entities.Book;
import entities.User;
import models.BookModel;

public class BookController {
	private BookModel bookModel;
	
	public BookController(BookModel bookModel) {
		this.bookModel = bookModel;
	}
	
	public ArrayList<Book> getBooks() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<Book> books = new ArrayList<Book>();
		books = bookModel.getAllBooks();
		return books;
	}
	
	public Book createBook(String title, String author, String sinopse, String cover, LocalDateTime dateLauch, User createdBy) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return bookModel.createBook(title, author, sinopse, cover, dateLauch, createdBy);
	}
	
	public Book getBookById(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return bookModel.getBookById(id);
	}
	
	public ArrayList<Book> getBooksByTitle(String title) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return bookModel.getBooksByTitle(title);
	}

	public ArrayList<Book> getBooksByUser(String userId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return bookModel.getBooksByUser(userId);
	}

	public ArrayList<Book> getBooksByCep(String cep) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return bookModel.getBooksByCep(cep);
	}
	
	public void updateBook(Book book) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		bookModel.updateBook(book);
	}
	
	public void deleteBook(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		bookModel.deleteBook(id);
	}
}
