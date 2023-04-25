package application;

public class Password {
	
	private String pass;
	private int minLength = 0;
	
	Password(String passw, int min){
		minLength = min;
		if (passw.length() > min) {
			pass = passw;
		}
		
	}
	
	Password(Password passw){
		pass = passw.getPass();
		minLength = passw.getMin(); 
	}
	
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String npass) {
		pass = npass;
	}
	
	public int getMin() {
		return minLength;
	}
	
	public void setMin(int nmin) {
		minLength = nmin;
	}
	
	
	public void encrypt(String passw) {
		
	}

}
