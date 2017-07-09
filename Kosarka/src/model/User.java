package model;

public class User {
	private String username;
	private String password;
	private boolean administrator;
	
	public User(String username, String password, boolean administrator) {
		this.username = username;
		this.password = password;
		this.administrator = administrator;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public boolean getAdministrator() { return administrator; }
	public void setAdministrator(boolean administrator) { this.administrator = administrator; }

	public boolean equals(User user) { return username.equals(user.username) && password.equals(user.password); }
	public boolean equals(String u, String p) { return username.equals(u) && password.equals(p); }
	
	
	
}
