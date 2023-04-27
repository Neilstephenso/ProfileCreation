package application;

import java.awt.image.BufferedImage;

public class Profile {
	
	public String username = "";
	public Password pass;
	public BufferedImage img;
	
	
	Profile(String username1, Password passw){
		username = username1;
		pass = new Password(passw);
	}
	
	Profile(String username1, Password passw, BufferedImage img1){
		username = username1;
		pass = new Password(passw);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username1) {
		username = username1;
	}
	
	public Password getPassword() {
		return pass;
	}
	
	public void setPassword(Password passw) {
		pass = passw;
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public void setImage(BufferedImage img1) {
		img = img1;
	}
}
