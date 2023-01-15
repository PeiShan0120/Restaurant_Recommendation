package net.javaguides.shopcartmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.menumanagement.dao.MenuDAO;
import net.javaguides.menumanagement.model.menu;
import net.javaguides.shopcartmanagement.model.Shopcart;
import net.javaguides.shopcartmanagement.model.TotalPrice;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class ShopcartDAO {  
	MenuDAO menuDAO;
	//資料庫存取的架構，要存取就一定要有DAO物件
	//1.一筆table做成一個java bean 2.做成array list[]集合（最好用，因有排序性） 3.要對DB做的事情，就對java bean做一樣的事
	private String jdbcURL = "jdbc:mysql://localhost:3306/face_project?useSSL=false";  //JDBC
	private String jdbcUsername = "root";
	private String jdbcPassword = "0853770905"; //passwd changed
	
	// duplicate
	private static final String SELECT_ALL_SHOPCART = "SELECT * from ShopCart WHERE id= ?";
	private static final String DELETE_ITEM_SQL = "DELETE FROM ShopCart WHERE id = ? AND no =?";
	private static final String UPDATE_QUANTITY_SQL = "UPDATE ShopCart set quantity = ? WHERE id = ? AND no = ?";
	private static final String SELECT_QUANTITY_BY_NO_ID = "SELECT * FROM ShopCart WHERE id =? AND no =?";
	
	//待修改
	private static final String INSERT_SHOPCART_SQL = "INSERT INTO ShopCart (no, quantity, id) VALUES (?, ? , ?) ON DUPLICATE KEY UPDATE quantity = quantity+1";
	private static final String UPDATE_TOTAL_PRICE = "UPDATE totalprice set totalprice = ? WHERE id = ?";
	private static final String DELETE_ALL_SQL = "DELETE FROM ShopCart WHERE EXISTS (SELECT * FROM ShopCart WHERE id = ?) AND id = ?";
	
	public ShopcartDAO() {
		menuDAO = new MenuDAO();
	}

	protected Connection getConnection() {  //建立連線物件
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	//insert & update shopcart
	public void insertShop(Shopcart shopcart) throws SQLException {   //新增資料
		System.out.println(INSERT_SHOPCART_SQL);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOPCART_SQL)) {
			preparedStatement.setInt(1, shopcart.getNo());
			preparedStatement.setInt(2, shopcart.getQuantity());
			preparedStatement.setInt(3, shopcart.getId());
//			preparedStatement.setInt(4, shopcart.getQuantity());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();   
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//list shopcart
	public List<Shopcart> selectAllShop(int id) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Shopcart> shopcart = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			// "select * from users"
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOPCART);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int no = rs.getInt("no");
				int quantity = rs.getInt("quantity");
				menu menu = menuDAO.selectItem(no);
				int totalPrice = menu.getPrice() * quantity;
				
				shopcart.add(new Shopcart(no, quantity, id, menu.getItem(), totalPrice, menu.getImage())); //查詢資料庫中的欄位，所有欄位
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return shopcart;
	}
	
	
	//delete Shopcart row by id & no
	public boolean deleteShop(int id, int no) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ITEM_SQL);) {
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, no);
			rowDeleted = preparedStatement.executeUpdate() > 0;  //刪除欄位
		}
		return rowDeleted;
	}
	
	//delete all Shopcart
	public boolean deleteAllShop(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_SQL);) {
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;  //刪除欄位
		}
		return rowDeleted;
	}
	
	//update ShopCart quantity by id & no
	public boolean updateQuantity(Shopcart shopcart) throws SQLException{
		boolean quantityUpdate;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_SQL);) {
			preparedStatement.setInt(1, shopcart.getQuantity());
			preparedStatement.setInt(2, shopcart.getId());
			preparedStatement.setInt(3, shopcart.getNo());
			
			quantityUpdate = preparedStatement.executeUpdate() > 0;
		}
		return quantityUpdate;
	}
	
	//select quantity to update from ShopCart quantity by id & no
	public Shopcart selectQuantity(int id, int no) {
		Shopcart shopcart = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				// "select id,name,email,country from users where id =?"
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUANTITY_BY_NO_ID);) {
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, no);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				menu menu = menuDAO.selectItem(no);
				
				int quantity = rs.getInt("quantity");
				shopcart = new Shopcart(no, quantity, id, menu.getItem(), menu.getPrice(), menu.getImage());
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return shopcart;
	}
	
	//update totalprice DB
	public boolean updateTotalPrice(TotalPrice totalPrice) throws SQLException {   //新增資料
		boolean totalPriceUpdate;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_SQL);) {
			preparedStatement.setInt(1, totalPrice.getTotalPrice());
			preparedStatement.setInt(2, totalPrice.getId());
			
			totalPriceUpdate = preparedStatement.executeUpdate() > 0;
		}
		return totalPriceUpdate;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
