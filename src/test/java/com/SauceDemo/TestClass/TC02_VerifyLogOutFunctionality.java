package com.SauceDemo.TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.HomePOMClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;


public class TC02_VerifyLogOutFunctionality extends TestBaseClass
{
	//test steps
	@Test
	public void verifyLOgOutFunctionality() throws IOException
	{
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickMenuButton();
		System.out.println("clicked on menu button");
		
		hp.clickLogOutButton();
		System.out.println("clicked on logoUt button");
		
		ScreenshotClass.takeScreenshot(driver);
		log.info("apply the validation");
		
	
		   String expectedTitle = "Swag Labs";    //dev/BA
			
		   String actualTitle = driver.getTitle();
		   log.info(actualTitle);
		   Assert.assertEquals(actualTitle, expectedTitle);

	}

}
