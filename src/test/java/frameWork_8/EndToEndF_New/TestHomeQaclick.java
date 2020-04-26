package frameWork_8.EndToEndF_New;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectFactory.HomeQaclick;
import pageObjectFactory.LoginQaclick;
import resourc.BaseMaterial;



public class TestHomeQaclick extends BaseMaterial {
	
	










	WebDriver driver;

	
//added becos of listener null in constructor in BaseMaterial

	





	//Calling BaseMaterial	
	@BeforeTest
	public void baseFileBrowserAccess() throws IOException {
		
		// adopting Basefile features
				
				driver = initialdDriver();
				
	}
	
	
	
	
	
				
	/*// Taking Care of pop up Method 1 (try catch)   	
				try // this with try the code. Note this is Arithmetic Exception
				{
					HomeQaclick l = new HomeQaclick (driver);
					l.getpopUp().click();
				}
				
				catch(Exception e) // this will catch it if error exist
				{
				System.out.println("Pop up is not available today");
				}*/
				
				
	@Test
	public void homeQaclickAccess() {
		// Taking Care of pop up Method 2 (if)
				HomeQaclick l = new HomeQaclick (driver);
	//The driver inside the bracket has life, so we need to give life to driver2 in HomeQaclick with the help of constructor. 
				if(l.getpopUpSize().size()>0) {
					l.getpopUp().click();
					}
				
				String centerTittle = l.getCentreTittle().getText();
				Assert.assertEquals(centerTittle, "FEATURED COURSES");
				
				l.getLogin().click();
				
	}
	
	
	

	@Test
	public void loginQaclickAccess() throws IOException  { 
	//The driver inside the bracket has life, so we need to give life to driver2 in LoginQaclick with the help of constructor.	
		
		
		//LOGIN PAGE
		LoginQaclick login = new LoginQaclick(driver);
		login.emailData();			//email data, comet and remove from below bracket when using resourc.TestNgdataDriver
		login.passWordData();		//password data, comet when using resourc.TestNgdataDriver
		login.getEmailBox().sendKeys(login.emailData());
		login.getPasswordBox().sendKeys(login.passWordData());
		
		login.getLogin().click();
		
	
		
		
		}
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
			
	
	
	
}
