package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.ExelFileReaderLogicUtility;



public class DataProviderUtility {

	
	
	// data is readBy the ExelFileReaderLogicUtility class we are 
	@DataProvider(name = "InDirectDP")
	public static Object[][] getUserInfoEXel()throws IOException
	{   
	    
	        return ExelFileReaderLogicUtility.getTestData("Sheet1");
	    

	}
	
	@DataProvider(name="DirectDP")
	public Object[][] getUserInfo()
	{         Object[][] data  = {
				{"Koushik", "koushikn@143536.com", "1234567893", "Karnataka,Davanagere", "male"},
				{"Swathi", "Swathi@143536.com", "1234567893", "Karnataka,Bangalore", "female"},
				{"Ramesh", "Ramesh@143536.com", "1234567893", "Karnataka,Ballari", "male"}
	};
	return data;
	}
}
