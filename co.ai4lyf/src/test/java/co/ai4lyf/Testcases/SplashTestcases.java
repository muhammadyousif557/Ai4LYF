package co.ai4lyf.Testcases;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.SplashObjects;


public class SplashTestcases extends Main {
	SplashObjects splash;
	
	public SplashTestcases () {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		if (driver == null) {  // Initialize driver only if it's null
			getdriver();  // Initialize driver
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // Implicit wait for general use
      	}
        // Initialize SplashObject after driver is set
		splash = new SplashObjects();  
	}
	
	@Test(priority=1)
	public void LogoVerification(){
		boolean flag = splash.SplashLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void HeadText(){
		String actualText = splash.SplashWelcomeHeading();
		String expectedText = "LYF Suite";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	

	@Test(priority=3)
	public void ParagraphText(){
		String actualText = splash.SplashPText();
		String expectedText = "Live to Your Fullest";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	
	
	@AfterMethod
	public void tearDown(){
	   if (driver != null) {
	        driver.quit();  // Close the entire session properly
	        driver = null;
	   }
	   
	}
}
