package application;

import javafx.beans.property.SimpleStringProperty;

public class Profile {
	
	private final SimpleStringProperty username;
	private final SimpleStringProperty pWord;
	private final SimpleStringProperty email;
	
	

	public Profile(String userName1, String nEmail, String passw) {
		username = new SimpleStringProperty(userName1);
		pWord = new SimpleStringProperty(passw);
		email = new SimpleStringProperty(nEmail);
	}



	public String getUsername() {
		return username.get();
	}
	
	public void setUsername(String username1) {
		username.set(username1);
	}
	
	public String getPassword() {
		return pWord.get();
	}
	
	public void setPassword(String passw) {
		pWord.set(passw);
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(String nEmail) {
		email.set(nEmail);
	}
}