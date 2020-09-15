package com.wst.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wst.qa.base.WST_TestBase;

public class WST_Login extends WST_TestBase {
	//Page Factory - Object Repository
	@FindBy(id="UserName")
	WebElement Login_UserName_IP;
	
	@FindBy(id="Password")
	WebElement Password_IP;
	
	@FindBy(xpath="/html/body/form/div/div[1]/div[2]/div/input[1]")
	WebElement Login_Submit_Btn;
	
	
	//Initializing the Page Objects:
	public WST_Login(){
		PageFactory.initElements(driver, this);
	}

//Actions:
public String validate_WST_LoginPage_Title(){
	return driver.getTitle();
}

	public String validate_WST_LoginPage_URL(){
	return driver.getCurrentUrl();
}


public WST_Home action_WST_Login(String userName, String Password) throws InterruptedException{
	Thread.sleep(6000);
	
	Login_UserName_IP.sendKeys(userName);
	Thread.sleep(2000);
	
	Password_IP.sendKeys(Password);
	Thread.sleep(2000);
	
	//Login_Submit.submit();
	Login_Submit_Btn.click();
	//.click();
	Thread.sleep(2000);
	System.out.println("Navigate To Home Page -- You Clicked on Login Button");
	return new WST_Home();
	}
}

