package com.wst.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.wst.qa.base.WST_TestBase;

	public class WST_OpenApplication extends WST_TestBase {
	
		
		//Initializing the Page Objects:
			public WST_OpenApplication(){
				PageFactory.initElements(driver, this);
			}

			//Actions:
			public String validate_WST_MainPage_Title(){
				return driver.getTitle();
			}
			
			//Actions:
			public String validate_WST_MainPage_URL(){
				return driver.getCurrentUrl();
			}
	}
