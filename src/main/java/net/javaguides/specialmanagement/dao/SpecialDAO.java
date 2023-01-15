package net.javaguides.specialmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.menumanagement.model.menu;
import net.javaguides.specialmanagement.model.Special;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class SpecialDAO {  
	//資料庫存取的架構，要存取就一定要有DAO物件
	//1.一筆table做成一個java bean 2.做成array list[]集合（最好用，因有排序性） 3.要對DB做的事情，就對java bean做一樣的事
	private String jdbcURL = "jdbc:mysql://localhost:3306/face_project?useSSL=false";  //JDBC，資料庫名稱
	private String jdbcUsername = "root";
	private String jdbcPassword = "0853770905"; //passwd changed

	private static final String SELECT_ITEM_BY_NO_ITEM = "SELECT no, item, FROM recommendation WHERE no =? AND item= ?";  //選取對應資料
	private static final String SELECT_ALL_ITEM = "SELECT * FROM recommendation";  //選取所有資料
	public SpecialDAO() {
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
	
	//選no
		public menu selectItem(int no) {
			menu menu = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					// "select id,name,email,country from users where id =?"
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEM_BY_NO_ITEM);) {
				preparedStatement.setInt(1, no);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String item = rs.getString("item");
					int quantity = rs.getInt("quantity");
					String price = rs.getString("price");
					String image = rs.getString("image");
					menu = new menu(no, item, quantity, price, image);  //查詢資料庫中的欄位，指定id編號
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return menu;
		}

	public List<menu> selectAllItem() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<menu> menulist = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			// "select * from users"
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int no = rs.getInt("no");
				String item = rs.getString("item");
				int quantity = rs.getInt("quantity");
				String price = rs.getString("price");
				String image = rs.getString("image");
				menulist.add(new menu(no, item, quantity, price, image)); //查詢資料庫中的欄位，所有欄位
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return menulist;
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
