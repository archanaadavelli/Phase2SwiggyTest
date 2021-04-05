package com.swiggytest.tests;

import org.testng.annotations.Test;

import com.swiggytest.logs.Logger;
import com.swiggytest.pages.SwiggyHomePage;
import com.swiggytest.pages.SwiggySetLocationPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SwiggyHomePageTest {
	
	WebDriver driver;
	Logger logger;
	SwiggyHomePage swiggyHome;
	
	TakesScreenshot scrShot;
	File DestFile;

	public void takeScreenshots(String fileName) throws IOException {
		scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		DestFile = new File("/home/archanakitsgmai/SwiggyTestScreenshots/" + fileName + ".png");
		FileHandler.copy(SrcFile, DestFile);
	}
	
	@Given("^user navigate to swiggy home page$")
	public void SwiggyHomePageOpen() {
		swiggyHome = new SwiggyHomePage(driver);
	}	
	@Then("^user verify page opened$")
  public void checkHomePageOpened() {
	  
	  logger = new Logger("swiggyhomepage");
	  //assertTrue(swiggyHome.isPageOpened());
	  if(swiggyHome.isPageOpened()) {
		  System.out.println("Page is opened");
		  logger.writeLog("Page is opened");
	  }else {
		  System.out.println("Page is not opened");
		  logger.writeLog("Page is not opened");
	  }
	  logger.closeLog();
	  try {
		takeScreenshots("homepage");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @Before
  public void beforeTest() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @After
  public void afterTest() {

	  driver.close();
  }

}
