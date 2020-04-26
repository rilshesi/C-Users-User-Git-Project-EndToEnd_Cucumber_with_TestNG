package pageObjectFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeQaclick {

	
	public WebDriver driver2;

	
	
	// (2)  definning page object
		
		private By signin = By.cssSelector("a[href*='sign_in']");
		private By centreTittle = By.cssSelector("div.text-center");
		private By homeNavBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
		private By centretitle2 = By.cssSelector("div[class*='video-banner'] h3");
		private By popUp = By.xpath("//button[contains(text(),'NO THANKS')]");
		
		
		
		
		
		
		
		
		
		
		
	//returning page object
		
		// I created a constructor that expect an argument coming from homeQaclickAccess so we can give life to driver2
		public HomeQaclick(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver2=driver;
		}
		public WebElement getLogin() {
			
			return driver2.findElement(signin);
		}
		public WebElement getCentreTittle() {
			
			return driver2.findElement(centreTittle);
		}
		public WebElement getHomeNavBar() {
			
			return driver2.findElement(homeNavBar);
		}
		public WebElement getcentretitle2() {
			
			return driver2.findElement(centretitle2);
		}
		
		public WebElement getpopUp() {
			
			return driver2.findElement(popUp);
		}
		
		public List<WebElement> getpopUpSize() {
			
			return driver2.findElements(popUp);
			
		}

	

}
