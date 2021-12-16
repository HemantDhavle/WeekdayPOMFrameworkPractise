package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	private By fn = By.xpath("//input[@name='firstname']");
	
	public void doRegistration(String fName)
	{
		driver.findElement(fn).sendKeys(fName);
	}
}
