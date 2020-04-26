package resourc;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;

	

public class Listeners extends BaseMaterial implements ITestListener						
{
	
	
	public WebDriver driver= null;
	
//with static access modifier in BaseMaterial, we do not need to declare an instance for BaseMaterial
	//BaseMaterial ba = new BaseMaterial();
	
	
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult result) {
		
		
		// Write screenshot code here
		// first create a BaseFile object at the top
		// we also need to tell testNG where our listener is
		try {
			
			BaseMaterial.captureScreenshot(result.getName());
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}		

   

}
