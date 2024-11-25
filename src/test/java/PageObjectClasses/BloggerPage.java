package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BloggerPage extends BasePage {

	public BloggerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
////////Fields/////////////////
	
	
@FindBy(xpath = "//span[normalize-space()='Sign in']")
 WebElement  signIN;

	public boolean validateBloggerHomePage() {
		return signIN.isDisplayed();
	}
	
	
	
}
