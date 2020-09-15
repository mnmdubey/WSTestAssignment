package com.wst.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wst.qa.base.WST_TestBase;
import com.wst.qa.pages.WST_Home;
import com.wst.qa.pages.WST_Login;
import com.wst.qa.pages.WST_OpenApplication;
import com.wst.qa.pages.WST_Supplier;
import com.wst.qa.testdata.WST_ExpData;
import com.wst.qa.testdata.WST_TestData;

public class WST_Supplier_Test extends WST_TestBase{
		WST_OpenApplication openApp;
		WST_Login wst_login;
		WST_Home wst_homePage;
		WST_Supplier wst_supplier;
		
		WST_ExpData wst_expData;
		WST_TestData wst_testData;
				
		ExtentReports report;
		ExtentTest test;
//--------------------------------------------------------------------------------
	@BeforeTest
	public void EnvironmentSetUp(){
		createHTMLReport("Supplier_Verification.html", "Supplier Page - Verification");
		}	
//-------------------------------------------------------------------------------		
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		openApp = new WST_OpenApplication();
		wst_login = new WST_Login();
		wst_homePage = new WST_Home();
		wst_testData = new WST_TestData();
		wst_login.action_WST_Login(wst_testData.supUser, wst_testData.supPwd);
		
		wst_supplier = new WST_Supplier();
		}

//=========================================================================
	@Test (priority = 1, enabled = false, invocationCount = 1)
	public void validate_WST_LaunchApp_Test(){
		System.out.println("Lets Open the IML Web Application");
		log_Info("Application has been Launched Successfully");
	}
	
	@Test (priority = 11, enabled = false, invocationCount = 1)
	public void validate_Company_Search_Test() throws InterruptedException{
		//Title
		wst_supplier.validate_Company_Search();
		log_Info("validate_Company_Search RAN Successfully");
	}
	
	@Test (priority = 12, enabled = true, invocationCount = 1)
	public void action_Create_Supplier_Test() throws InterruptedException{
		wst_supplier.validate_Company_Search();
		log_Info("validate_Company_Search RAN Successfully");
		
		wst_supplier.action_Create_Supplier();
		log_Info("action_Create_Supplier RAN Successfully");
		
		wst_supplier.action_Process_Journal_Entry_Test();
		log_Info("action_Create_Supplier RAN Successfully");
		
		
	}
	
	
	
	
	
	@Test (priority = 9999, enabled = false, invocationCount = 1)
	public void validate_Principal_CloseApp_Test(){
		log_Warning("All Test Completed, Application will be Closed");
	}
	
//================================================================================
	
@AfterMethod
public void ClosetheBroser(){
	//driver.quit();
	System.out.println("Test Case RAN and Browser has been Closed");	
}
//------------------------------------------------------------------------	
@AfterTest
public void TestCompleted(){
testCompletedAndCloseReport();
}	
}



