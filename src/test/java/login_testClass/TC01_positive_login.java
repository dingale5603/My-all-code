package login_testClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pom.Login;
import com.util.Driver_global;
import com.util.ScreenShot;
import com.util.Xl_sheetcode;

public class TC01_positive_login {
	Driver_global dri=new Driver_global();
	WebDriver driver;
	Login p; 
	
	@Test
	public void enteronlyuserid() throws InterruptedException, EncryptedDocumentException, IOException {
	   driver= dri.driver;
		p=new Login(driver);
		Xl_sheetcode sheet=new Xl_sheetcode();
		String a = sheet.readstrdata(0, 0);
		String b = sheet.readstrdata(0, 1);
		p.userId1(a);
		p.password1(b);
		p.loginbutton();
	 String actual= p.home_validation();
	 String expected = "Dipak";
	  Assert.assertEquals(actual, expected);
	  
		System.out.println("*****login successfull*******");
		Thread.sleep(1000);
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