package testWithTestngData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectFactory.HomeQaclick;
import pageObjectFactory.LoginQaclick;
import resourc.BaseMaterial;

public class TestHomeWithParameterizing extends BaseMaterial {
	
	
	
	
	

	WebDriver driver;
	
	//added becos of listener null in constructor in BaseMaterial
	

	
	
///////////////////////THIS IS ANOTHER TEST ENTIRELY BECAUSE OF PARAMERIZING DATA//////////////////////////////////7
	
	
// TO PARAMETERISING FROM TestNG XML FILE (FRAMEWORK1) /EndToEndFWork/src/main/java/resources/TestNgdataDriver.java
//You can parameterise the value or drive the data from TestNG xml file
//Assume we are entering 3 diffERENT user and pass to run at the same time
// WE NEED TO PUT THE FOLLOWING IN FRONT OF @Test i.e
//				@Test(dataProvider = "getaDta", dataProviderClass = TestNgdataDriver.class)
//			THEN ADD two String in the method bracket. i.e:  (String email, String password), which will replace email and password data



	

	

	@Test(dataProvider = "getData", dataProviderClass = resourc.TestNgdataDriver.class)
public void loginQaclickAccess(String emailTestng, String passwordTestng) throws IOException  { 
//The driver inside the bracket has life, so we need to give life to driver2 in LoginQaclick with the help of constructor.	


//-----WE ALSO NEED TO INITIALIZE DRIVER INSIDE THE DATA PROVIDED SO THAT DIFFERENT BROWSER CAN BE OPENED FOR DIFFERENT USER AND PASSWORD
//HOME PAGE
			driver = initialdDriver();



//----- Taking Care of pop up Method 1 (try catch)   	
			try // this with try the code. Note this is Arithmetic Exception
			{
				HomeQaclick l = new HomeQaclick (driver);
				l.getpopUp().click();
			}
			catch(Exception e) // this will catch it if error exist
			{
				System.out.println("Pop up is not available today");
			}



//HOME PAGE
			HomeQaclick l = new HomeQaclick (driver);
			String centerTittle = l.getCentreTittle().getText();
			Assert.assertEquals(centerTittle, "FEATURED COURSES");
			l.getLogin().click();


//LOGIN PAGE

			LoginQaclick login = new LoginQaclick(driver);
			login.getEmailBox().sendKeys(emailTestng);
			login.getPasswordBox().sendKeys(passwordTestng);

			login.getLogin().click();


			driver.close();
			driver=null;
}








}
