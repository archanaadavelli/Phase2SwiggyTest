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

import com.swiggytest.pages.VerifyLoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class VerifyLoginTest {
	
	WebDriver driver;
	VerifyLoginPage loginPage;
	
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
	@Given("^user navigate to swiggy home page to login$")
	public void checkHomePageOpened() {
		loginPage = new VerifyLoginPage(driver);
	}
	
	@When("^user click on login$")
	public void clickLogin() {
		loginPage.clickLogin();

	}
	@When("^enter \"([^\\\"]*)\" and click on login$")
	public void setmobileNumber(String mobileNumber) throws Exception {
		loginPage.enterMobileNumber(mobileNumber);
	}
	@When("^enter OTP manually$")
	public void enterOTP() {
		//otpInput.sendKeys(OTP);
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@When("^user click on verify OTP$")
	public void clickVerifyOTP() {
		loginPage.clickverifyOTPButton();

	}	
	@Then("^verify user name as \"([^\"]*)\"$")
	public void verifyUserLogin(String userName) {
		assertEquals(loginPage.getUserName(),userName);;
		if(loginPage.getUserName().equals(userName)) {
			System.out.println("Login Successfull : "+loginPage.getUserName());
		}else {
			System.out.println("Login Failed : "+loginPage.getUserName());
		}
		  try {
				takeScreenshots("loginverify");
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
