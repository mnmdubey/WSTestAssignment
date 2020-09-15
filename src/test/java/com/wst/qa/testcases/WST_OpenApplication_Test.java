package com.wst.qa.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wst.qa.base.WST_TestBase;
import com.wst.qa.pages.WST_OpenApplication;
import com.wst.qa.testdata.WST_ExpData;

	public class WST_OpenApplication_Test extends WST_TestBase{
		WST_OpenApplication openApp;
		WST_ExpData wst_expData;
	
	//--------------------------------------------------------------------------------
	@BeforeTest
	public void EnvironmentSetUp(){
		createHTMLReport("OpenApplication_Verification.html", "Open Application Page - Verification");
		}	
	//-------------------------------------------------------------------------------
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		openApp = new WST_OpenApplication();
		wst_expData = new WST_ExpData();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss-SSS"); 
		Calendar cal = Calendar.getInstance();  
		}
	//========================================================================================	
	@Test (priority = 10, enabled = true)
	public void LaunchApplication_Test(){
		System.out.println("Lets Open the IML Web Application");
		log_Info("Application has been Launched Successfully");
		takeScreenShot("LaunchApplication_Test_1.png");
	}
	
	@Test (priority = 11, enabled = true)
	public void validate_WST_MainPage_TitleAndURL_Test(){
		
		String WST_LoginPage_Title = openApp.validate_WST_MainPage_Title();
		System.out.println("WST_LoginPage_Title:"+WST_LoginPage_Title);
		compare_ExpVsAct_Values(WST_LoginPage_Title, wst_expData.LoginPage_Title);
	
		//URL
		String WST_LoginPage_URL = openApp.validate_WST_MainPage_URL();
		System.out.println("WST_LoginPage_URL: "+WST_LoginPage_URL);
		compare_ExpVsAct_Values(WST_LoginPage_URL, wst_expData.LoginPage_URL);
		
		//takeScreenShot("ScreenShot_"+DateTime+".png");
	}
	
	@Test (priority = 9999, enabled = true)
	public void WST_CloseApp_Test(){
		log_Info("All Test Completed, Application will be Closed");
	}		
	
	//==================================================================================
	@AfterMethod
	public void ClosetheBroser(){
		driver.quit();
		System.out.println("Test Case RAN and Browser has been Closed");	
	}
	
	
	//------------------------------------------------------------------------	
	@AfterTest
	public void TestCompleted(){
	testCompletedAndCloseReport();
	//		report.endTest(test);  
	//		report.flush();
		}
	}
