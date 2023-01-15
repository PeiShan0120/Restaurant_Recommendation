package net.javaguides.shopcartmanagement.model;

public class TotalPrice {
	protected int id;
	protected int totalPrice;
	
	public TotalPrice() {
	}

	public TotalPrice(int id, int totalPrice) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
