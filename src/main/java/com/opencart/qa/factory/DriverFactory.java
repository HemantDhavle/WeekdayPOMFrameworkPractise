package com.opencart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver init_driver(Properties prop)
	
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Brower successfully opened is "+browserName);
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("browser is not correct please pass the correct browser"+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.manage().window().fullscreen();
		return driver;
	}
	
	public Properties init_prop()
	{
		 prop = new Properties();
		 try {
			FileInputStream fs = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}
}
