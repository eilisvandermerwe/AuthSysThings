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
			
//			sql = "INSERT INTO users (name, username, password) VALUES (\"Bilbo!\", \"bilboB\", \"ring\");";
			stmt.executeUpdate(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUser(String inputtedUserName, String inputtedPassword) throws NoUserFoundEx {
		User user = new User("", "", "");
		
		try {
			stmt = conn.createStatement();
			String sql;
			 sql = "SELECT name, username, password FROM users WHERE username = \"bilboB\" AND password = \"ring\";";
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 

		     if(rs.next()) {
		         //Retrieve by column name
		         String name = rs.getString("name");
		         String username = rs.getString("username");
		         String password = rs.getString("password");

		         //Display values
		         System.out.print("name: " + name);
		         System.out.print(", username: " + username);
		         System.out.print(", password: " + password);
		         

				user = new User(name, username, password);
		         
		      } else {
		    	  throw new NoUserFoundEx();
		      }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;

	}
	   	   /*
	   	    * ResultSet rs = stmt.executeQuery(sql);
			
	   Statement stmt = null;

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first");
	         String last = rs.getString("last");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	*/

}
