package com.SauceDemo.TestClass;



import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.SauceDemo.POMClass.LoginPOMClass;
import com.SauceDemo.UtilityClass.ScreenshotClass;

public class TestBaseClass 
{
	   WebDriver driver;				
	   Logger log= Logger.getLogger("CopyPastSouceDemoProject");
		
	    @Parameters("browserName")	// For Perform Cross Browser Testing
		@BeforeMethod
		public void setUp(String browserName) throws IOException
		{
			if(browserName.equals("chrome"))
			{
			    System.setProperty("webdriver.chrome.driver", 
						"./DriverFiles\\chromedriver.exe");
			    
			    ChromeOptions options = new ChromeOptions();
				 options.addArguments("--remote-allow-origins=*");
				 
				driver = new ChromeDriver(options);
			}
			else
			{
				System.setProperty("webdriver.gecko.driver", 
						"./DriverFiles\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			PropertyConfigurator.configure("log4j.properties");		//("File Name")	
			log.info("Browser is opened");
			
			
			driver.manage().window().maximize();
			log.info("Browser is maximized");
			
			driver.get("https://www.saucedemo.com/");
			log.info("URL is opened");
			
			ScreenshotClass.takeScreenshot(driver);
			 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
			
			//login
			LoginPOMClass lp = new LoginPOMClass(driver);
		    lp.sendUsername();
		    log.info("Username is entered");
		    
		    lp.sendPassword();
		    log.info("Password is entered");
		    
		    lp.clickOnLoginButton();
		    log.info("Clicked on login button");
		    
		    
		}
		
		@AfterMethod
		public void tearDown() 
		{

			driver.quit();
			log.info("browser is closed");
			
		}

	}


