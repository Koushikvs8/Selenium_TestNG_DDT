package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class BaseClass {
	 public static WebDriver driver ;
	 Properties   prop;
	 public   Logger logger;  
	           
	        
	@BeforeClass(groups = {"smoke","Regression","master"})
	@Parameters("browserTestNG")  
	 public void SetUpUrl(String browserTestNG ) throws IOException
	    {
	    	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
	    	
	    	logger = LogManager.getLogger(this.getClass());//log4j for logging
	    	
	    	prop =new Properties();
	    	prop.load(file);
	    	
	    	//////////////////
	    	String browser ;
	    	  String browserProty=prop.getProperty("Browser");
	   
	    	////////////////////////////////Dynamic browser selection/////////////////////
	    	 if (browserTestNG==null) {
	    		 
	    		 browser=browserProty;
			} else {
				browser=browserTestNG;
			}
	    	  /////////////////////////////////////
	    	  
	    	if(browser.equalsIgnoreCase("chrome"))
	    	{
	    		driver=new ChromeDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("FirFox"))
	    	{
	    		driver =new FirefoxDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("Edge"))
	    	{
	    		driver =new EdgeDriver();
	    	}
	    	driver.manage().deleteAllCookies();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        String url=prop.getProperty("Url");
	    	driver.get(url);
	    	logger.info("the Execution is started and "+url +" is launched for specfic to this case");
	    	driver.manage().window().maximize();
	    	
	    	
	    	
	    	
	    }

	@AfterClass(groups = {"smoke","Regression","master"})
	public void mainTearDown()
	{
		logger.info("the Execution is endedand is launched for specfic to this case\"");
		driver.quit();;
	}
	/////////////////////////ScrenShotetaker///////////////////////
	
	public static String CaptureScreenShot()
	{   String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
	    File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	    File targetFile= new File(System.getProperty("user.dir")+"\\Reports\\screenshots\\"+timestamp+"ss.png");
		sourceFile.renameTo(targetFile);
		return System.getProperty("user.dir")+"\\Reports\\screenshots\\"+"ss.png";
		
	}

	
	
}
