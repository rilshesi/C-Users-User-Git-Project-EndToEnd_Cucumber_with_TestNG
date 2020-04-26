package frameWork_8.EndToEndF_New;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectFactory.HomeQaclick;
import pageObjectFactory.LoginQaclick;
import pageObjectFactory.VerifiedHomePage;

import resourc.BaseMaterial;




public class TestHomeWithLog4j extends BaseMaterial {


	

	WebDriver driver;	
	
	
	
		
/*Adding Log4J: 
	1st add log4j api & core dependency to pom.xml . 
	2nd Add log4jresourses(where you add log4j.xml path) to build path in pom.xml
	3rd Create a new scr folder at project level; right click project, new, source folder(resources), finish, right click sorce folder, 
	new other,  xml, xml file, type name(must be log4j2;    2=version), next, finish.Copy and paste the basic xml configuration in it 
	4th go through log4j note for further learning*/

	// Initiating Log4j
	// Initiating Log4j
	public static Logger log = LogManager.getLogger(TestHomeWithLog4j.class.getName());

	
	
	
	
	//Calling BaseMaterial	
	@BeforeTest
	public void baseFileBrowserAccess() throws IOException {
		
		// adopting Basefile features
				
				driver = initialdDriver();
				log.info("Driver is initialized");
				
	}
	
	
	
	// Taking Care of pop up Method 1 (try catch)   	
			// this with try the code. Note this is Arithmetic Exception
			/*try 
			{
				
				HomeQaclick l = new HomeQaclick (driver);
				l.getpopUp().click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
				log.info("popup is clicked");
	
	
		
				String centerTittle = l.getCentreTittle().getText();
				 try
			        {
			            if(centerTittle.contains("FEATURED COURSE"))
			            {			               
			                Assert.assertEquals(centerTittle, "FEATURED COURSE"); //Deliberately failed for screenShot purpose and should be the last in a method to get the right pic	               
			            }		            
			        }
			         catch (Exception e)
			          {
			        	 log.info("centre tittle not a match");
			          }
				 finally
				 {
					 Assert.assertEquals(centerTittle, "FEATURED COURSES");
				 }

	}	 
	@Test
	public void homeQaclickAccess2() {			 
		HomeQaclick l = new HomeQaclick (driver);
					
					 l.getLogin().click();
					 log.debug("login clicked");;
					 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 
				
				
				 
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
		log.debug("Portal Homepage is Displayed");
		}
	
	
	
	@Test
    public void validateSearchBox(){
    	
		VerifiedHomePage v = new VerifiedHomePage(driver);
    	v.getsearchBox().isDisplayed();
        log.info("search box is present");
    }
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
			
	
	
	
}
