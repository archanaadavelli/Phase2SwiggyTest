package com.swiggytest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLoginPage {

	private WebDriver driver;
	
	private static String PAGE_URL="https://www.swiggy.com";
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[1]")
	WebElement loginLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div")
	WebElement signinLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span")
	WebElement location;
	
	@FindBy(id = "mobile")
	WebElement mobileNumberInput;
	
	@FindBy(id = "otp")
	WebElement otpInput;	
	
	@FindBy(xpath = "//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a")
	WebElement verifyOTPButton;	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div/div/div/a/span[2]")
	WebElement userName;	
	
	public VerifyLoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver,this);
	}

	public void clickLogin(){
		if( driver.findElements( By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div") ).size() != 0) {
			signinLink.click();
		}else {
			loginLink.click();
		}
	}
	
	public void enterMobileNumber(String mobileNumber){
		mobileNumberInput.sendKeys(mobileNumber);
	}
	
	public void enterOTP(String OTP){
		otpInput.sendKeys(OTP);
	}	
	public void clickverifyOTPButton(){
		verifyOTPButton.click();
	}
	public String getUserName(){
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1qbcC")));
		return userName.getText();
	}
}
