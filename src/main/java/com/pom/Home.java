package com.pom;


import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Home {
	@FindBy(css="span.nickname") private WebElement homepage;
	
	
	
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void luanch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\chromedriver2\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("https://kite.zerodha.com");
	}	
	
	
	@Test
	public void home_validation(String name){
		 name = homepage.getText();
		 String name1="dipak";
		 Assert.assertEquals(name, name1);
	}
	
}
