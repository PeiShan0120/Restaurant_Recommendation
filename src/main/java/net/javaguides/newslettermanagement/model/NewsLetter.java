package net.javaguides.newslettermanagement.model;

public class NewsLetter {
	protected int id;
	protected String email;

	public NewsLetter() {
		
	}
	
	public NewsLetter(int id, String email) {
			super();
			this.id=id;
			this.email=email;
		}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

}
