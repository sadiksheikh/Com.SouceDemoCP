package com.SauceDemo.TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.POMClass.HomePOMClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TC03_VerifyBagProductFunctionality extends TestBaseClass
{
	@Test
	public void verifyBagProductFunctionality() throws IOException
	{
		
		//--homePage--//
		
		//bag product
		HomePOMClass hp = new HomePOMClass(driver);
		hp.clickBagButton();
		log.info("Bag product will get selected");
		
		ScreenshotClass.takeScreenshot(driver);
		//--validation--//
		String expectedProduct = "1";
		
		String actualProduct = hp.getTextFromAddToCart();
		log.info("actual product->"+actualProduct);
		
		log.info("apply validation");
		
		Assert.assertEquals(actualProduct, expectedProduct);

		
		}

}
