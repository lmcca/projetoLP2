package entities;

import java.time.LocalDateTime;

public class User {
	private String id;
	private String email;
	private String name;
	private String password; 
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public User(String id, String password, String email, String name, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
		setId(id);
		setPassword(password);
		setEmail(email);
		setName(name);
		setAddress(address);
		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
	
	@Override
	public String toString() {
		return "Este usuario tem como nome " + this.name + " este email " + this.email + " e este endereco " + this.address;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

