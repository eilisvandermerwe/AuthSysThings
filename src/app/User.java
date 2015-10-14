package app;

public class User {
	
	private String name;
	private String username;
	private String password;
	
	public User(String inputtedName, String inputtedUsername, String inputtedPassword) {
		setName(inputtedName);
		setUsername(inputtedUsername);
		setPassword(inputtedPassword);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
