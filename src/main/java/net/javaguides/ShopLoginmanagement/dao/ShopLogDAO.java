package net.javaguides.ShopLoginmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.javaguides.ShopLoginmanagement.model.ShopLog;
import net.javaguides.ShopLoginmanagement.model.Employee;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class ShopLogDAO {  
	//資料庫存取的架構，要存取就一定要有DAO物件
	//1.一筆table做成一個java bean 2.做成array list[]集合（最好用，因有排序性） 3.要對DB做的事情，就對java bean做一樣的事
	private String jdbcURL = "jdbc:mysql://localhost:3306/face_project?useSSL=false";  //JDBC
	private String jdbcUsername = "root";
	private String jdbcPassword = "0853770905"; //passwd changed

	private static final String SELECT_USER_BY_ID = "SELECT id,name FROM employee WHERE id =?";  //選取對應資料
	private static final String SELECT_USER_BY_ID_WITH_DATE = "SELECT id,name,time FROM facedetection WHERE id =? AND DATE(time) = CURDATE() ORDER BY time ASC";
	public ShopLogDAO() {
	}

	//連線資料庫MySQL
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
	

	//查詢學生資料(id)
	public Employee selectUserId(int id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				// "select id,name,email,country from users where id =?"
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				employee = new Employee(id, name);  //查詢資料庫中的欄位，指定id編號
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}
	
	//today date
	public List<ShopLog> selectUserByDate(int id) {
		List<ShopLog> shoplog = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				// "select id,name,email,country from users where id =?"
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_WITH_DATE);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			//if time existed
			while (rs.next()) {
				try {
					String name = rs.getString("name");
					Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("time"));
					shoplog.add(new ShopLog(id, name, time));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return shoplog;
	}

	//印出資料庫exception
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
