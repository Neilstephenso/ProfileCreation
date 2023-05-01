package application;

import javafx.beans.property.SimpleStringProperty;


/**
 * makes a profile with a username email and password
 * 
 * @author StephensonNeil, Blake Jordan
 * @version 4/30/23
 *
 */
public class Profile {
	
	private final SimpleStringProperty username;
	private final SimpleStringProperty pWord;
	private final SimpleStringProperty email;
	
	

	/**
	 * constructor class that takes 3 strings 
	 * @param userName1 new username
	 * @param nEmail new email
	 * @param passw new password
	 */
	public Profile(String userName1, String nEmail, String passw) {
		username = new SimpleStringProperty(userName1);
		pWord = new SimpleStringProperty(passw);
		email = new SimpleStringProperty(nEmail);
	}



	/**
	 * gets and returns the username of the profile
	 * @return username
	 */
	public String getUsername() {
		return username.get();
	}
	
	/**
	 * sets the username of the profile
	 * @param username1 new username
	 */
	public void setUsername(String username1) {
		username.set(username1);
	}
	
	/**
	 * gets and returns the password
	 * @return password
	 */
	public String getPassword() {
		return pWord.get();
	}
	
	/**
	 * sets the password
	 * @param passw new password
	 */
	public void setPassword(String passw) {
		pWord.set(passw);
	}
	
	/**
	 * gets and returns the email
	 * @return email
	 */
	public String getEmail() {
		return email.get();
	}
	
	/**
	 * sets the email
	 * @param nEmail new email
	 */
	public void setEmail(String nEmail) {
		email.set(nEmail);
	}
}