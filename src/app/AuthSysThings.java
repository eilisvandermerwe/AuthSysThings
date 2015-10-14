package app;
import app.UserAccess;

public class AuthSysThings {

	public AuthSysThings() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Hello, welcome to our app.");
		System.out.println("If you want to login, press 1");
		System.out.println("If you want to register, press 2");
		
		
		UserAccess pleasework = new UserAccess();
		User bilbo = new User("Luke Skywalker", "LukeS", "force");
		pleasework.saveUser(bilbo);
		try {
			User currentUser = pleasework.getUser ("LukeS" , "force");
			System.out.println("Welcome " + currentUser.getName() + "!");
		} catch (NoUserFoundEx e) {
			System.out.println("User or password is WRONG.");
		}
		
	}

}
