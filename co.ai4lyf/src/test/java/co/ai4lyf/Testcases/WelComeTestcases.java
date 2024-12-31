package co.ai4lyf.Testcases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;


public class WelComeTestcases extends Main{
	WelcomeScreenObjects welcome;
	
	public WelComeTestcases() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		if (driver == null) {  // Initialize driver only if it's null
			getdriver();  // Initialize driver
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Implicit wait for general use
      	}
        // Initialize SplashObject after driver is set
		welcome = new WelcomeScreenObjects();  
	}
	
	@Test(priority=1)
	public void LogoVerification(){
		boolean flag = welcome.WelcomeLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void HeadText(){
		String actualText = welcome.WelcomeScreenHeading();
		String expectedText = "Welcome to LYF Suite";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	
	@Test(priority=3)
	public void ParagraphText() {
		String actualText = welcome.WelcomeScreenPara();
		String expectedText = "Live to Your Fullest with LYF Suite!\nGet premium holistic personal care,\nall in one easy-to-use platform.";
		Assert.assertEquals(actualText, expectedText, "The text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	} 
	
	@Test(priority=4)
	public void GetContinueBtn() throws InterruptedException {
		welcome.ClickContinueBtn();
		String actualText = welcome.GetWaterLogText();
		String expectedText = "Hydrate LYF";
		Assert.assertEquals(actualText, expectedText, "The text does not match the expected value.");
		System.out.println("actualText:" + actualText);
	}
	
	@AfterMethod
	public void tearDown(){
	    if (driver != null) {
	        driver.quit();  // Close the entire session properly
	        driver = null;
	    }
	}

}
