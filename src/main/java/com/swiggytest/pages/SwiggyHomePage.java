package com.swiggytest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyHomePage {
	private WebDriver driver;
	
	private static String PAGE_URL="https://www.swiggy.com";

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/h2")
	WebElement heading;
	
	public SwiggyHomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver,this);
	}
	
	public boolean isPageOpened(){
	       return heading.getText().toString().contains("Order food from favourite restaurants near you.");
	   }
	public WebDriver getWebDriver() {
		return driver;
	}

}
