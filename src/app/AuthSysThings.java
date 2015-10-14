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
		User bilbo = new User("Bilbo", "bilboB", "ring");
		
		System.out.println(bilbo.getName() + " password: " + bilbo.getPassword());
	}

}
