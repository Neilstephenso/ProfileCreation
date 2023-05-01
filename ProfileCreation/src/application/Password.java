package application;


/**
 * a class for making the password more secure and allowing for restrictions to be put on the passwords
 * 
 * @author StephensonNeil, Blake Jordan
 * @version 4/30/23
 */
public class Password {
	
	private String pass;
	private int minLength = 0;
	
	/**
	 * constructor class for the password
	 * @param passw new password
	 * @param min minimum length for the password
	 */
	Password(String passw, int min){
		minLength = min;
		if (passw.length() > min) {
			pass = passw;
		}
		
	}
	
	/**
	 * constructor class for the password
	 * @param passw new password
	 */
	Password(Password passw){
		pass = passw.getPass();
		minLength = passw.getMin(); 
	}
	
	/**
	 * gets and returns the password
	 * @return password
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * sets the password
	 * @param npass new password
	 */
	public void setPass(String npass) {
		pass = npass;
	}
	
	/**
	 * gets and returns the minimum length of the password
	 * @return minLength
	 */
	public int getMin() {
		return minLength;
	}
	
	/**
	 * sets the minimum length of the password
	 * @param nmin new minimum
	 */
	public void setMin(int nmin) {
		minLength = nmin;
	}
	
	/**
	 * this method takes a password and encrypts it to make it not readable to the human eye
	 * 
	 * @TODO make this method encrypt the password
	 * @return the encrypted password
	 */
	public String encrypt() {
		String str = new String();
		for (int i = 0; i < this.getPass().length(); i++) {
			str += "*";
		}
		return str;
	}

}
