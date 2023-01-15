package net.javaguides.shopcartmanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Shopcart {  //一個資料表，代表一個java bean物件，（一個類別class對應到一個資料表table）
	protected int no; 
	protected int quantity;
	protected int id;
	protected String item;
	protected int price;
	protected String image;
	
	public Shopcart() {
	}

	public Shopcart(int no, int quantity, int id, String item, int price, String image) {
		super();
		this.no = no;
		this.quantity = quantity;
		this.id = id;
		this.item = item;
		this.price = price;
		this.image = image;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
