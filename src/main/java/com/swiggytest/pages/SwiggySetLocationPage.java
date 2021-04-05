package com.swiggytest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwiggySetLocationPage {



	private WebDriver driver;
	
	private static String PAGE_URL="https://www.swiggy.com";

	@FindBy(id = "location")
	WebElement locationInput;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/span[2]")
	WebElement findCityInList;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span")
	WebElement location;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span")
	WebElement existingLocation;
	
	public SwiggySetLocationPage(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver,this);
	}
	
	public void enterLocation(String location) {
		locationInput.sendKeys(location);
	}
	
	public void setLocation() {
		findCityInList.click();
	}
	
	public String checkLocation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span")));
		return location.getText().toString();
	}
	
}
