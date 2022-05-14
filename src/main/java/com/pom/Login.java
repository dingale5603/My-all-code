package com.pom;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	
	//Declaration
    @FindBy(id="userid") private WebElement userId;
	@FindBy(xpath="//span[contains(text(),'User ID should')]")private WebElement user_eror_msg;
    @FindBy(id="password") private WebElement password;
    @FindBy(xpath="//span[contains(text(),'Password should')]")private WebElement pass_eror_msg;
    @FindBy(css="//*[@id=\"container\"]/div/div/div/form/p[1]/text()")private WebElement invalidBoth_eror_msg;
    @FindBy(tagName="button") private WebElement login;
    @FindBy(css="span.nickname") private WebElement homepage;
	
 
     //Initialization
    public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	} 
    //userId
    public void userId1(String user) throws EncryptedDocumentException {	
		userId.sendKeys(user);
	}
    //password
    public void password1(String pass) {
		password.sendKeys(pass);
	}
    //login button
    public void loginbutton() {
    	login.click();
    }
    //user error massage
    public String userErrormsg() {
         String msg = user_eror_msg.getText();
         return msg;
    }
    //pass error massage
    public String passErrormsg() {
        String msg = pass_eror_msg.getText();
        return msg;
   }
    //both wrong
    public String BothWrong() {
        String msg = invalidBoth_eror_msg.getText();
        return msg;
   }
    public String home_validation(){
		 String name = homepage.getText();
		return name;
    }
}
