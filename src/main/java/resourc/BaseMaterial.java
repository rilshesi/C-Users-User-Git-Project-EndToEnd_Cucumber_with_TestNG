package resourc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import com.google.common.io.Files;


public class BaseMaterial {
	
	public static   WebDriver driver;
	public   String screenshotpath;
	
	
	public WebDriver initialdDriver() throws IOException {
		
		
		// set capability for ie
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setCapability("requireWindowFocus", true);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				InternetExplorerOptions i = new InternetExplorerOptions();
				i.merge(cap);
		
		
// 1. create BaseMaterial properties
		Properties base = new Properties();
// 2. tell properties where file is located, in resourc package
		//FileInputStream f = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\EndToEndF_New\\src\\main\\java\\resourc\\material.properties");
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourc\\\\material.properties");
// 3. write info such as url, password and user in f. load f file from properties
		base.load(f);
		
// 4. getting data from file
		String browserN = base.getProperty("browser");
		String web = base.getProperty("url");
		

		
//5. browser option
		
		if(browserN.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resourc\\chromedriver.exe");
	// Adding options to chrome browser from DesiredCapabilities cap
			ChromeOptions chro = new ChromeOptions();
			driver = new ChromeDriver(chro);
			if(browserN.contains("chromeheadless"))     // headless means running in the background
			{
				chro.addArguments("headless");
			}

		}
		
		
		else if(browserN.contains("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resourc\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		
		else if (browserN.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resourc\\IEDriverServer1.exe");
			driver = new InternetExplorerDriver(i);
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(web);
		return driver;

		
	}
	
	
	
	
	//TAKING A SCREEN SHOT ON FAILURE WITH THE HELP OF TESTng LISTENER
			// Taking Screenshot on Failure	
				
	
	public static void captureScreenshot(String result) throws IOException {
	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// file already stored in scr, but we need to copy it to our local file using below
		//Files.copy(screenshotFile, new File("C:\\Test\\TestFailure\\"+result+"screensh.png"));
		Files.copy(screenshotFile, new File(System.getProperty("user.dir")+"\\screenShot\\"+result+"screensh.png"));
		
// the above failed with nullpointer exception and listener cannot see screenshotFile, if i don't use static access modifier in the method
		
		
		
//Using GregorianCalendar to fetch the time details
   /* Calendar cal = new GregorianCalendar();
    //Month value is always 1 less than actual. For February, MONTH would return 1 
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int sec = cal.get(Calendar.SECOND);
    int min = cal.get(Calendar.MINUTE);
    int date = cal.get(Calendar.DATE);
    int day = cal.get(Calendar.HOUR_OF_DAY);

    //Take screen shot and store it in volatile memory with reference name scrFile
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {

        //Create unique file name and store in under screenshot folder of root directory
        screenshotpath = System.getProperty("user.dir") + "\\screenShot\\" + methodName + "_" + year + "_" + date+ "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".png";
        
        //Copy the file to destination
        FileHandler.copy(scrFile, new File(screenshotpath));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }*/

}
	
	
	
	// Now how do method know if there is failure? we need to use the concept of Listener
	// we are going to create a new class for listener
	// so when the test is finish and there is failure, the control will go to the Listener class
	/* the file name needs to be dynamic because ScreenShortFailure.png 
	 *will be override every time a new screen shot is to be taken if we have many failures*/
	
	
	
	
	
	 
	





	
	
}
