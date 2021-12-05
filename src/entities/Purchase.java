package entities;

import java.time.LocalDateTime;

public class Purchase {
	private String id;
	private Book book;
	private User purchased;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Purchase(String id, Book book, User purchased, LocalDateTime createdAt, LocalDateTime updatedAt) {
		setId(id);
		setBook(book);
		setPurchased(purchased);
		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public User getPurchased() {
		return purchased;
	}
	
	public void setPurchased(User purchasedId) {
		this.purchased = purchasedId;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
