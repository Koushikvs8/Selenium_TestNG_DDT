
	package TestCases;

	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;



	import PageObjectClasses.HomePage;
	import TestBase.BaseClass;
	import Utilities.DataProviderUtility;
	import io.opentelemetry.api.logs.Logger;

	public class TC3_FormFillingDDT extends BaseClass {
	    
		 @Test(  groups = {"master"},  dataProvider ="DirectDP",dataProviderClass =DataProviderUtility.class)
		    public void Validate_UserAbleTo_Fill_Details(String usern ,String emailn ,String phoneNorn ,String Addressn  ,String Gender ) throws InterruptedException {
			
			 HomePage homepage = new HomePage(driver);
		     logger.info("user is navigated to  Homepage ");
		 homepage.User_Form_Fill(usern, emailn, phoneNorn, Addressn, Gender);
		 logger.info("Filling the form with testdata");
			 driver.navigate().refresh();
		    }
	   
	}


