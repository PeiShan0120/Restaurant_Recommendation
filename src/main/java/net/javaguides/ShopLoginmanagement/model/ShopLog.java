package net.javaguides.ShopLoginmanagement.model;

import java.util.Date;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class ShopLog {  //一個資料表，代表一個java bean物件，（一個類別class對應到一個資料表table）
	protected int id;  //學生ID編號
	protected String name; //學生名字
	protected Date time; //出勤時間
	
	public ShopLog() {
	}
	
//	public User(String name, String email, String classnum, String password) {
//		super();
//		this.name = name;
//		this.time = time;
//	}

	public ShopLog(int id, String name, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;

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
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
