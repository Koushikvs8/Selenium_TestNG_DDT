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

public class TC1_FormFillingTestCases extends BaseClass {
    
	 @Test(groups = {"smoke","master"})
	    public void Validate_UserAbleTo_Fill_Details( ) throws InterruptedException {
		
		 HomePage homepage = new HomePage(driver);
	     logger.info("user is navigated to  Homepage ");
	 homepage.User_Form_Fill("koushik", "koushik@123@.com", "1233456789", "shivamogga", "male");
	 logger.info("Filling the form with testdata");
		 driver.navigate().refresh();
	    }
   
}
