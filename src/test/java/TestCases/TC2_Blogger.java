package TestCases;

import  org.testng.Assert;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObjectClasses.BasePage;
import PageObjectClasses.BloggerPage;
import PageObjectClasses.HomePage;
import TestBase.BaseClass;


public class TC2_Blogger extends BaseClass  {
  @Test(groups = {"Regression","master"})
  public void Validate_footer_ThemImage_clickable()
  {
	 HomePage homepage =new HomePage(driver);
	 logger.info("user is Navigated to Homepage");
	 homepage.click_Footer_BolggerLink();
	 logger.info("user clicked on the BloggerLink at Footer");
	 homepage.swichToWindow();
	 BloggerPage bloggerPage =new BloggerPage(driver);
	 logger.info("user is navigated to Blogger page");
	 Boolean result= bloggerPage .validateBloggerHomePage();
	 logger.info("user is able to see the homepage of Blogger page");
     Assert.assertTrue(!result);
  }
  



}
