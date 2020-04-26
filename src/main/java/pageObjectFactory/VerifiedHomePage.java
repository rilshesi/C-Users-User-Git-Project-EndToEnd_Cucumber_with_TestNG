package pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifiedHomePage {
	
	
	// (2)  definning page object
	
	
	public WebDriver driver2;
// to give life to driver2, we have to create a constructor below and then assign driver from HomePage to be = driver2
	
	private By searchBox = By.xpath("//input[@id='search-courses']");
	
	
	//returning page object
	
// We are creating a constructor that expect an argument which is coming from Homepage where we landingPage object was instantiated
	public VerifiedHomePage(WebDriver driver) {
		// Now assign life of driver2 coming from HomePage to the driver above using below
		
		this.driver2=driver;
		
		
	}




	
	
	
	public WebElement getsearchBox() {
		
		return driver2.findElement(searchBox);
	}


}
