	package com.SauceDemo.TestClass;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;



import com.SauceDemo.POMClass.HomePOMClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TC05_VerifyDropDownFunctionality extends TestBaseClass
	{
	@Test
		public void verifyDropDownFunctionality() throws IOException
		{
			HomePOMClass hp = new HomePOMClass(driver);
			hp.clickDropDownFilter();
			log.info("DropDown Perform Susscessfully");
			
			ScreenshotClass.takeScreenshot(driver);
				
//			Validation
			
			String expectedresult = "Name (A to Z)";
					
					
			String actualresult ="Name (A to Z)";	
			log.info("Actual Result of DropDown is-->"+actualresult+"<--");
			log.info("Apply Validation");
			
			AssertJUnit.assertEquals(actualresult, expectedresult);
			
			
		}
	}
