package entities;


import java.time.LocalDateTime;

public class Book {
	private String id;
	private String title;
	private String author;
	private String sinopse;
	private String cover;
	private User createdBy;
	private LocalDateTime dateLauch;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Book(String id, String title, String author, String sinopse, String cover, LocalDateTime dateLauch,LocalDateTime createdAt, LocalDateTime updatedAt, User createdBy) {
		setId(id);
		setTitle(title);
		setAuthor(author);
		setSinopse(sinopse);
		setCover(cover);
		setCreatedBy(createdBy);
		setDateLauch(dateLauch);
		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public User getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public LocalDateTime getDateLauch() {
		return dateLauch;
	}
	
	public void setDateLauch(LocalDateTime dateLauch) {
		this.dateLauch = dateLauch;
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
