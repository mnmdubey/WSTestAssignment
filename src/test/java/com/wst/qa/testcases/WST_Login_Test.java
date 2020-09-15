package com.wst.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wst.qa.base.WST_TestBase;
import com.wst.qa.pages.WST_Login;
import com.wst.qa.pages.WST_OpenApplication;
import com.wst.qa.testdata.WST_ExpData;
import com.wst.qa.testdata.WST_TestData;

public class WST_Login_Test extends WST_TestBase{
	
		WST_OpenApplication openApp;
		WST_Login wst_login;
		WST_ExpData wst_expData;
		WST_TestData wst_testdata;
		ExtentReports report;
		ExtentTest test;
//--------------------------------------------------------------------------------
		@BeforeTest
		public void EnvironmentSetUp(){
			createHTMLReport("WST_Login_Verification.html", "WST Login Page - Verification");
			}	
//-------------------------------------------------------------------------------		
		@BeforeMethod
		public void SetUp() throws InterruptedException{
			initialization();
			openApp = new WST_OpenApplication();
			wst_login = new WST_Login();
			wst_expData = new WST_ExpData();
			wst_testdata = new WST_TestData();
		}
	
//=========================================================================
		@Test (priority = 1, enabled = true, invocationCount = 1)
		public void validate_LaunchApp_Test(){
			System.out.println("Lets Open the IML Web Application");
			log_Info("Application has been Launched Successfully");
		}

		@Test (priority = 11, enabled = true, invocationCount = 1)
		public void validate_WST_LoginPage_TitleAndURL_Test(){
			//Title
			String WST_Login_Title = wst_login.validate_WST_LoginPage_Title();
			compare_ExpVsAct_Values(WST_Login_Title, wst_expData.LoginPage_Title);
		
			//URL
			String WST_Login_URL = wst_login.validate_WST_LoginPage_URL();
			compare_ExpVsAct_Values(WST_Login_URL, wst_expData.LoginPage_URL);
			}
		
		@Test(priority = 31, enabled = true, invocationCount = 1)
		public void validate_Principal_LoginVerification_Test() throws InterruptedException{
			wst_login.action_WST_Login(wst_testdata.supUser, wst_testdata.supPwd);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log_Info("User Logged in Successfully");
			takeScreenShot("WST_LoginVerification_Test_1.png");
			}
		
		@Test (priority = 9999, enabled = true, invocationCount = 1)
		public void validate_Principal_CloseApp_Test(){
			log_Info("All Test Completed, Application will be Closed");
			}		
//==================================================================	
	@AfterMethod
	public void ClosetheBroser(){
		driver.quit();
		System.out.println("Test Case RAN and Browser has been Closed");	
	}
//------------------------------------------------------------------------	
	@AfterTest
	public void TestCompleted(){
	testCompletedAndCloseReport();
	}	
}
