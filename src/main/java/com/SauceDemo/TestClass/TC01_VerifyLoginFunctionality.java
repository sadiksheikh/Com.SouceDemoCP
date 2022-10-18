package com.SauceDemo.TestClass;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.UtilityClass.ScreenshotClass;



public class TC01_VerifyLoginFunctionality extends TestBaseClass 
{

	@Test
	public void verifyLoginFunctionality() throws IOException
	{	//home page
	    ScreenshotClass.takeScreenshot(driver);
	    
	    log.info("apply the validation");
		
	   String expectedTitle = "Swag Labs";    //dev/BA	
	   String actualTitle = driver.getTitle();
	
	   Assert.assertEquals(actualTitle, expectedTitle);

	}

}
