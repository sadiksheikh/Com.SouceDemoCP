package com.SauceDemo.TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.HomePOMClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TC04_VerifyAllProductFunctionality extends TestBaseClass
{
	@Test(enabled = false)
	public void verifyAllProductFunctionality() throws IOException
	{
		
		//--homePage--//
		
		//bag product
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickAllProducts();
		log.info("All products will get selected");
		
		ScreenshotClass.takeScreenshot(driver);
		
		//--validation--//
		String expectedProduct = "6";
		
		String actualProduct = hp.getTextFromAddToCart();
		log.info("actual product->"+actualProduct);
		
		log.info("apply validation");
		
		Assert.assertEquals(actualProduct, expectedProduct);

		
		
		}

}
