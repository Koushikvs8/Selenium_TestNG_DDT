package PageObjectClasses;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{


	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	////////Fields/////////////////
	
	
	@FindBy(xpath = "//input[@class='form-control'][1]")
	 WebElement  userName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNor;
	
	@FindBy(xpath = "//textarea[@id='textarea']")
	private WebElement Address;
	
	@FindBy(xpath = "//input[@id='male']")
	 WebElement maleChkbox;
	
	@FindBy(xpath = "//input[@id='female']")
	private WebElement femaleChkbox;
	//a[text()='Blogger']
	
	@FindBy(xpath = "//a[text()='Blogger']")
      WebElement bloggerLink ;
	////////Actions/////////////////
	
	public void User_Form_Fill(String usern ,String emailn ,String phoneNorn ,String Addressn  ,String Gender ) throws InterruptedException
	{
		
		try {
			Thread.sleep(2000);
			userName.sendKeys(usern);
			Thread.sleep(2000);
			email.sendKeys(emailn);
			Thread.sleep(2000);
			phoneNor.sendKeys(phoneNorn);
			Thread.sleep(2000);
			Address.sendKeys(Addressn);
			
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		finally {
			if(Gender.equals("male")) {
				Thread.sleep(2000);
			this.maleChkbox.click();
			}
			else 
			{   Thread.sleep(2000);
				this.femaleChkbox.click();
			}
		}
		
		
	}
	
public void waiting()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(userName));
}
	
////////////////////////Footer////////////////
public void click_Footer_BolggerLink()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.open(arguments[0].href, '_blank');", bloggerLink);


}	
	public void swichToWindow()
	{
		Set<String> windows= driver.getWindowHandles();
		String CurrentWindow=driver.getWindowHandle();
		for (String window : windows) {
			if(!window.equals(CurrentWindow))
			{
				driver.switchTo().window(window);
				
			}
			
			
		
		}
	}
}
