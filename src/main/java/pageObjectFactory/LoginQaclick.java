package pageObjectFactory;



import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class LoginQaclick {


	public WebDriver driver2;
	public Properties loginPty;
	
		

	// (1) getting email data	
		public String emailData() throws IOException{
		Properties loginPty = new Properties();
		FileInputStream loginfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourc\\material.properties");
		loginPty.load(loginfile);
		this.loginPty=loginPty;              // this is done to give live to the loginPty in passWordData below
		String email = loginPty.getProperty("email");
		return email;
		}
		
	// (2) getting password data
		public String passWordData() {
			String passWord = loginPty.getProperty("password");
			return passWord;
		}
	
	
	
	
	
	
	
	
	
	// (3)  Defining Login page object
			
	By emailId = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By login = By.cssSelector("input[type='submit']");
	

	//returning page object
	
	// I created a constructor that expect an argument coming from loginQaclickAccess so we can give life to driver2
	public LoginQaclick(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver2=driver;
	}
	
	
	
	public WebElement getEmailBox() {
		
		return driver2.findElement(emailId);
	}
	public WebElement getPasswordBox() {
		
		return driver2.findElement(password);
	}
	public WebElement getLogin() {
	
	return driver2.findElement(login);
	}
	

}
