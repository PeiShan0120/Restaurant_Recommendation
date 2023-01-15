package net.javaguides.menumanagement.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class menu {  //一個資料表，代表一個java bean物件，（一個類別class對應到一個資料表table）
	protected int no;  //對應到DB中的欄位
	protected String item;
	protected int quantity;
	protected int price;
	protected String image;
	
	public menu() {
	}

	public menu(int no, String item, int quantity, int price, String image) {
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
