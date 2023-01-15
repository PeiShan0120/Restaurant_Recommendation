package net.javaguides.newslettermanagement.dao;

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

import net.javaguides.newslettermanagement.model.NewsLetter;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class NewsLetterDAO {  
	//資料庫存取的架構，要存取就一定要有DAO物件
	//1.一筆table做成一個java bean 2.做成array list[]集合（最好用，因有排序性） 3.要對DB做的事情，就對java bean做一樣的事
	private String jdbcURL = "jdbc:mysql://localhost:3306/face_project?useSSL=false";  //JDBC
	private String jdbcUsername = "root";
	private String jdbcPassword = "0853770905"; //passwd changed

	private static final String INSERT_NEWSLETTER_SQL = "INSERT INTO newsletter (id, email) VALUES (?, ?)";
//	private static final String SELECT_ALL_SHOPCART = "SELECT * from ShopCart WHERE id= ?";
	public NewsLetterDAO() {
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
	
	
	//insert newsletter
		public void insertNewsletter(NewsLetter newsletter) throws SQLException {   //新增資料
			System.out.println(INSERT_NEWSLETTER_SQL);
			
			try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWSLETTER_SQL)) {
				preparedStatement.setInt(1, newsletter.getId());
				preparedStatement.setString(2, newsletter.getEmail());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();   
			} catch (SQLException e) {
				printSQLException(e);
			}
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
