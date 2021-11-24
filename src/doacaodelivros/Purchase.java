package doacaodelivros;

import java.time.LocalDate;

public class Purchase {
	private String id;
	private String bookId;
	private String purchasedId;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getPurchasedId() {
		return purchasedId;
	}
	
	public void setPurchasedId(String purchasedId) {
		this.purchasedId = purchasedId;
	}
	
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
