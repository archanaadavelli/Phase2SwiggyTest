package com.swiggytest.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.swiggytest.pages.SwiggySetLocationPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SwiggySetLocationTest {
	
	WebDriver driver;
	SwiggySetLocationPage locationPage;
	
	TakesScreenshot scrShot;
	File DestFile;

	public void takeScreenshots(String fileName) throws IOException {
		scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		DestFile = new File("/home/archanakitsgmai/SwiggyTestScreenshots/" + fileName + ".png");
		FileHandler.copy(SrcFile, DestFile);
	}
	@Before
	public void initDriver() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Given("^user navigate to swiggy home page to setlocation$")
	public void checkHomePageOpened() {
		locationPage = new SwiggySetLocationPage(driver);
	}
	
	@When("^user set location \"([^\"]*)\"$")
	public void setLocation(String location) {
		locationPage.enterLocation(location);

	}
	@When("^selet the locaiton from list$")
	public void seletLocaitonFromList() throws Exception {
		locationPage.setLocation();
	}	
	
	@Then("user verify the location as \"([^\"]*)\"$")
	public void verifyLocaitonSet(String locationset) {
		assertEquals(locationPage.checkLocation(),locationset);;
		if(locationPage.checkLocation().equals(locationset)) {
			System.out.println("Location set Successfull : "+locationPage.checkLocation());
		}else {
			System.out.println("Location set Failed : "+locationPage.checkLocation());
		}
		try {
			takeScreenshots("setlocation");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@After
	public void closeDriver() {
		driver.close();
	}

}
