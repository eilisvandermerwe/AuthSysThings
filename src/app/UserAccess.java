package app;
import java.sql.*;
import app.NoUserFoundEx;

public class UserAccess {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/AuthSysThing";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "ch@ngeme1";

	Connection conn = null;
	Statement stmt = null;
	
	public UserAccess() {

		try{
			//Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("I think we did it!");
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
	public boolean saveUser(User newUser){
		try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO users (name, username, password) VALUES (\"" + newUser.getName() + "\", \"" + newUser.getUsername() + "\", \"" + newUser.getPassword() + "\");";
			stmt.executeUpdate(sql);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUser(String inputtedUserName, String inputtedPassword) throws NoUserFoundEx {
		User user = new User("", "", "");
		
		try {
			stmt = conn.createStatement();
			String sql;
			 sql = "SELECT name, username, password FROM users WHERE username = \"" + inputtedUserName + "\" AND password = \""+ inputtedPassword +"\";";
			 ResultSet rs = stmt.executeQuery(sql);
			 
		     if(rs.next()) {
		         //Retrieve by column name
		         String name = rs.getString("name");
		         String username = rs.getString("username");
		         String password = rs.getString("password");

				user = new User(name, username, password);
		         
		      } else {
		    	  throw new NoUserFoundEx();
		      }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;

	}

}
