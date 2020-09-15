package com.wst.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wst.qa.base.WST_TestBase;
import com.wst.qa.testdata.WST_ExpData;
import com.wst.qa.testdata.WST_TestData;


	public class WST_Supplier extends WST_TestBase {
		//Page Factory - Object Repository
		
	@FindBy(name="CompanyName")
	WebElement CompName_SearchBox;
	
	@FindBy(xpath="//*[@id='_column101']/a")
	WebElement CompName_link;
	
	@FindBy(xpath="//*[@id='menu_Id_50']/a")
	WebElement Contact_Menu;
	
	@FindBy(xpath="//*[@id='menu_Id_50']/ul/li[2]/a/span")
	WebElement Supplier_link;
	
	@FindBy(xpath="//*[@id='ItemSearch']/div[1]/div/a")
	WebElement Create_Supplier_Link;
	
	
	
	@FindBy(xpath="//*[@id='No']")
	WebElement Supplier_Type_Ind_Radio_Option;
	
	@FindBy(xpath="//*[@id='FirstNameBusiness']")
	WebElement Sup_FirstName_IP;
	
	@FindBy(xpath="//*[@id='LastNameBusiness']")
	WebElement Sup_LastName_IP;
	
	@FindBy(xpath="//*[@id='CustomerType']")
	WebElement Sup_Cust_Type_Drp;
	
	@FindBy(xpath="//*[@id='SupplierAccountNo']")
	WebElement Sup_AcntNo_IP;
	
	@FindBy(xpath="//*[@id='IsInternationalSuppRadio_1']")
	WebElement Sup_PayDet_Abroad_Radio_Option;
	
	@FindBy(xpath="//*[@id='AccountNumber']")
	WebElement Sup_PayDet_AcntNum_IP;
	
	@FindBy(xpath="//*[@id='BankName']")
	WebElement Sup_BankName_IP;
	
	@FindBy(xpath="//*[@id='savecustomer']")
	WebElement Sup_Create_Save_Btn;
	
	@FindBy(xpath="//*[@id='menu_Id_58']/a")
	WebElement Process_Menu;
	
	@FindBy(xpath="//*[@id='menu_Id_58']/ul/li[6]/a/span")
	WebElement Journal_link;
	
	
	
	
	//-------------------------------------------------------------
		
	WST_ExpData wst_expData = new WST_ExpData();
	WST_TestData wst_testData = new WST_TestData();
	
	//-------------------------------------------------------------
	
	//Initializing the Page Objects:
		public WST_Supplier(){
			PageFactory.initElements(driver, this);
		}

		//Actions:
		public String validate_WST_HomePage_Title(){
			return driver.getTitle();
		}
		
		//Actions:
		public String validate_WST_HomePage_URL(){
			return driver.getCurrentUrl();
		}
				
		
	//Actions: Search
		public void validate_Company_Search() throws InterruptedException{
			Thread.sleep(6000);
			CompName_SearchBox.sendKeys("NOTIFY TEST");
			Thread.sleep(3000);
			CompName_link.click();
			
			Set<String> winHandler = driver.getWindowHandles();
			Iterator<String> itr = winHandler.iterator();
			
			String PrarentWinHandleId = itr.next();
			System.out.println("PrarentWinHandleId: "+PrarentWinHandleId);
			
			String ChildWinHandleId = itr.next();
			System.out.println("ChildWinHandleId: "+ChildWinHandleId);
			
			driver.switchTo().window(ChildWinHandleId);
			System.out.println("Moved to Other Tab");
			
			driver.switchTo().window(PrarentWinHandleId);
			System.out.println("Moved to Parent Tab");
			
			driver.switchTo().window(ChildWinHandleId);
			System.out.println("Moved to Other Tab");
		}
		
		public void action_Create_Supplier() throws InterruptedException{
			Thread.sleep(6000);
//			SupplierPage_btn.click();
			
			System.out.println("You Clicked on button");
			Contact_Menu.click();
			Thread.sleep(2000);
			
			Supplier_link.click();
			Thread.sleep(3000);
			
			Create_Supplier_Link.click();
			Thread.sleep(4000);
			
			Supplier_Type_Ind_Radio_Option.click();
			Sup_FirstName_IP.sendKeys(wst_testData.Sup_FName);
			Sup_LastName_IP.sendKeys(wst_testData.Sup_LName);
			Select selectCustTypeDrp = new Select(Sup_Cust_Type_Drp);
			selectCustTypeDrp.selectByVisibleText(wst_testData.Sup_Type);
			
			Sup_AcntNo_IP.clear();
			Sup_AcntNo_IP.sendKeys(wst_testData.Sup_AcntNum);
			
			Sup_PayDet_Abroad_Radio_Option.click();
			
			Sup_PayDet_AcntNum_IP.clear();
			Sup_PayDet_AcntNum_IP.sendKeys(wst_testData.Sup_PayDet_AcntNum);
			
			Sup_BankName_IP.clear();
			Sup_BankName_IP.sendKeys(wst_testData.Sup_BankName);
				
			
			Sup_Create_Save_Btn.click();;
			
		}
		
		public void action_Process_Journal_Entry_Test() throws InterruptedException{
			Thread.sleep(6000);
//			SupplierPage_btn.click();
			
			Process_Menu.click();
			Thread.sleep(2000);
			
			Journal_link.click();
			Thread.sleep(3000);
			
		}
		
		
		
		
}




