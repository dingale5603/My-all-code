package login_testClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pom.Login;
import com.util.Driver_global;
import com.util.ScreenShot;

public class Login_negatiive {
	Driver_global dri;
	WebDriver driver ;
	Login page; 
	@Test
	public void enterOnlyUserId() throws InterruptedException {
		
		page.userId1("deepak");
		Thread.sleep(2000);
		page.loginbutton();
		Thread.sleep(2000);
		 String actual_eror = page.passErrormsg();
		 String expected_eror="Password should be minimum 6 characters.";
		 Assert.assertEquals( actual_eror, expected_eror);
		//System.out.println("*****Password should be minimum 6 characters*******");
		
		Thread.sleep(1000);
	}
	@Test
	public void enterOnlyPassword() throws InterruptedException {
		
		page.password1("deepak@");
		Thread.sleep(2000);
		page.loginbutton();
		Thread.sleep(2000);
		String actual_eror = page.userErrormsg();
		String expected_eror="User ID should be minimum 6 characters.";
		 Assert.assertEquals( actual_eror, expected_eror);
		//System.out.println("******User ID should be minimum 6 characters.******");
		Thread.sleep(2000);
		
	}
	@Test
	public void onlyLoginClick() throws InterruptedException {
		page.loginbutton();
		Thread.sleep(2000); 
		String actual_eror = page.passErrormsg();
		String actual_eror1 = page.userErrormsg();
		String expected_eror="Password should be minimum 6 characters.";
		String expected_eror1="User ID should be minimum 6 characters.";
		 Assert.assertEquals( actual_eror, expected_eror);
		 Assert.assertEquals( actual_eror1, expected_eror1);

	//	System.out.println("******User ID should be minimum 6 characters.******");
		//System.out.println("*****Password should be minimum 6 characters*******");
		Thread.sleep(2000);
	}
	@Test
	public void invalid_Credentials() throws InterruptedException {
		
		page.userId1("deepak");
		Thread.sleep(2000);
		page.password1("deepak@");
		Thread.sleep(2000);
		page.loginbutton();
		String invalidCredit_actual= page.BothWrong();
		String invalidCredit_exp="Invalid username or password.";
		Assert.assertEquals( invalidCredit_actual, invalidCredit_exp);
		//System.out.println("***** Invalid username or password.*******");
		Thread.sleep(2000);
		
	}
	
	@BeforeTest
	public void config() {
		dri=new Driver_global();
		driver=dri.mydriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page=new Login(driver);
	}
	@AfterMethod
	public void logout(ITestResult res) throws IOException {
		Reporter.log("logout from app",true);
		if(ITestResult.FAILURE==res.getStatus()) {
			System.out.println(res.getStatus());
			ScreenShot screenshot=new ScreenShot();
			screenshot.takeit();
			Reporter.log("screenshot captured",true);
			
			}
	}
	
	

}
