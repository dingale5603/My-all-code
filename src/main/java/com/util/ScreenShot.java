package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.config.Configuration;

public class ScreenShot {
	Driver_global dri=new Driver_global();
	 WebDriver driver;
		
	public void takeit() throws IOException{
		driver=dri.driver;
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date a=new Date();
		String currentdate=a.toString();
		currentdate=currentdate.replace(":", "_");
		File d=new File(Configuration.screenshort_path+currentdate+"img.jpg");
	    FileHandler.copy(s, d);
	}
}
