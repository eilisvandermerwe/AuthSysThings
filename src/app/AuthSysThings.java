package app;
import java.util.Scanner;

import app.UserAccess;

public class AuthSysThings {

	public AuthSysThings() {
		// TODO Auto-generated constructor stub
	}
//Eilis Smells
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserAccess pleasework = new UserAccess();
		
		System.out.println("Hello, welcome to our app.");
		System.out.println("If you want to login, press 1");
		System.out.println("If you want to register, press 2");
		
		String result = scanner.nextLine();
		
		if(result.equals("1")){
			// login our user

			System.out.println("Enter your username:");
			String username = scanner.nextLine();
			
			System.out.println("Enter your password:");
			String password = scanner.nextLine();
			
			try {
				User currentUser = pleasework.getUser (username, password);
				System.out.println("Welcome " + currentUser.getName() + "!");
			} catch (NoUserFoundEx e) {
				System.out.println("User or password is WRONG.");
			}
			
		} else if (result.equals("2")){
			// register our user
			System.out.println("Enter your name:");
			String name = scanner.nextLine();
			
			System.out.println("Enter your username:");
			String username = scanner.nextLine();
			
			System.out.println("Enter your password:");
			String password = scanner.nextLine();

			User bilbo = new User(name, username, password);
			pleasework.saveUser(bilbo);
			
		} else {
			// loop round again, idiot!
			System.out.println("Ahhhh");
		}

		
		
	}

}
