package net.javaguides.specialmanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Special {  
	protected int no;
	protected String item;
	protected int quantity;
	protected String price;
	protected String image;
	
	public Special() {
	}

	public Special(int no, String item, int quantity, String price, String image) {
		super();
		this.no = no;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
