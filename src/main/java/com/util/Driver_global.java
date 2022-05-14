package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.config.Configuration;

public class Driver_global {
	public WebDriver driver;
	public WebDriver mydriver() {
		System.setProperty("webdriver.chrome.driver", Configuration.path);
		 driver=new ChromeDriver();
		driver.get(Configuration.url);
		return driver;
	}
	

}
