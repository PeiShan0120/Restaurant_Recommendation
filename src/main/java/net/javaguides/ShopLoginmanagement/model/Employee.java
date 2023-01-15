package net.javaguides.ShopLoginmanagement.model;


/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Employee {  //一個資料表，代表一個java bean物件，（一個類別class對應到一個資料表table）
	protected int id;
	protected String name;
	
	public Employee() {
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
