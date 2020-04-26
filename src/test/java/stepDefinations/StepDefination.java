package stepDefinations;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import frameWork_8.EndToEndF_New.TestHomeWithLog4j;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjectFactory.HomeQaclick;
import pageObjectFactory.LoginQaclick;
import pageObjectFactory.VerifiedHomePage;
import resourc.BaseMaterial;









public class StepDefination extends BaseMaterial {
	WebDriver driver;
	
	public static Logger log = LogManager.getLogger(TestHomeWithLog4j.class.getName());
	HomeQaclick l = new HomeQaclick (driver);
	
	
	
	@Given("Initialize browser from base file and navigate to url")
	public void initialize_browser_from_base_file_and_navigate_to_url() throws IOException  {
		driver = initialdDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//button[contains(text(),'NO THANKS')]")));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("//button[contains(text(),'NO THANKS')]")));
		

		
// NOTE: I USED IF STATEMENT BELOW BECAUSE try catch will not work in Cucumber step Defination			
		
		HomeQaclick l = new HomeQaclick (driver);
			 if(l.getpopUpSize().equals(null))

				{

					log.info("No popUp today");
					
				}
				else if(l.getpopUpSize().equals(l.getpopUpSize()))
				{
					l.getpopUp().click();
				}

		}

		
		
		
/*// Taking Care of pop up Method 1 (try catch)   	
		try // this with try the code. Note this is Arithmetic Exception
		{
			LandingPagePO l = new LandingPagePO (driver);
			l.getpopUp().click();
		}
		
		catch(Exception e) // this will catch it if error exist
		{
		System.out.println("Pop up is not available today");
		}*/
		
		
// Taking Care of pop up Method 2 (if)
		
		// Taking Care of pop up Method 2 (if)
		
			//The driver inside the bracket has life, so we need to give life to driver2 in HomeQaclick with the help of constructor. 	
		
		/*if(l.getpopUpSize().size()>0) {
			
					l.getpopUp().click();
				}
				log.info("popup is clicked");*/
		
	

	
	
//NOTE: IN JUnit, you have to catch the error using below AssertionError catch, then print it out yourself as JUnit will not print it out
	//Also There many error collector when using try catch. 
// READ ABOUT Soft Assertion not in frame work 8	THIS WILL WORK BETTER
	
	
	public static List<String> errors = new ArrayList<String>();			
				
	@Given("Verify page centre tittle is displayed and get failure screen shot")
	public void verify_page_centre_tittle_is_displayed_and_get_failure_screen_shot() {			
		HomeQaclick l = new HomeQaclick (driver);
		String centerTittle = l.getCentreTittle().getText();
				try
				{
					if(centerTittle.contains("FEATURED COURSE"))
					 {			               
					  Assert.assertEquals(centerTittle, "FEATURED COURSE"); //Deliberately failed Hard Assertion for screenShot purpose and should be the last in a method to get the right pic	               
					}		            
					        }
				catch (AssertionError error) {
					errors.add(error.toString());
					System.out.println(error);
					    }
				finally
				{
					Assert.assertEquals(centerTittle, "FEATURED COURSES");
				}
								
	
    }
	
	
	

	@Given("Click on signin to get to login page")
	public void click_on_signin_to_get_to_login_page()  {
        
		HomeQaclick l = new HomeQaclick (driver);
		
		 l.getLogin().click();
		 log.debug("login clicked");;
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

	    
	@When("User enter {string} and {string} to login")
	public void user_enter_and_to_login(String username, String password) throws IOException {
		//LOGIN PAGE
				LoginQaclick login = new LoginQaclick(driver);
				login.emailData();			//email data, comet and remove from below bracket when using resourc.TestNgdataDriver
				login.passWordData();		//password data, comet when using resourc.TestNgdataDriver
				login.getEmailBox().sendKeys(username);
				login.getPasswordBox().sendKeys(password);
				
				login.getLogin().click();
				log.debug("Portal Homepage is Displayed");
				
	}
	

    @Then("^Validate that user is successfully logged in$")
    public void validate_that_user_is_successfully_logged_in() throws Throwable {
    	
    	VerifiedHomePage v = new VerifiedHomePage(driver);
    	v.getsearchBox().isDisplayed();
        log.info("search box is present");
        
    }
    
    @Then("Close browser")
    public void close_browser() {
       driver.quit();
       driver=null;
    }

	    }
