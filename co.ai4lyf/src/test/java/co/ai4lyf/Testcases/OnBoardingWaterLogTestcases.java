package co.ai4lyf.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.LoginObjects;
import co.Ai4Lyf.Objects.OnBoardingInHalerTrackerObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;
import org.testng.Assert;

public class OnBoardingWaterLogTestcases extends Main {
    OnBoardingWaterLogObjects waterlog;
    WelcomeScreenObjects welcome;
    LoginObjects login;
    OnBoardingInHalerTrackerObjects inhaler;
    
    public OnBoardingWaterLogTestcases () {
    	super();
    }
    
    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Initialize the driver only once
        if (driver == null) {
            getdriver();
        }
        // Initialize the page objects
        welcome = new WelcomeScreenObjects();
        waterlog = new OnBoardingWaterLogObjects();
        login = new LoginObjects();
        inhaler = new OnBoardingInHalerTrackerObjects();
        welcome.ClickContinueBtn();
    }
    
    @Test(priority = 1)
    public void WaterLogoVerification() throws InterruptedException {
        // Only perform navigation when needed, do not call ClickContinueBtn() in setup.
        boolean flag = waterlog.GetWaterLogo();
        Assert.assertTrue(flag);
    }
    
    @Test(priority=2)
	public void HeadText(){
		String actualText = waterlog.GetMainHeading();
		String expectedText = "Hydrate LYF";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
    
    @Test(priority=3)
	public void ParaText1(){
		String actualText = waterlog.GetWaterLogPara1();
		String expectedText = "Wellness starts with hydration!";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
    
    @Test(priority=4)
	public void ParaText2(){
		String actualText = waterlog.GetWaterLogPara2();
		String expectedText = "Let our smart tracking, reminders, and insights help you meet your hydration goals.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
    @Test(priority=5)
	public void Skiptext(){
		String actualText = waterlog.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
    @Test(priority=6)
	public void Nexttext(){
		String actualText = waterlog.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
    
    @Test(priority=7)
    public void ClickSkip() {
    	waterlog.ClickSkipText();
    	String actualText = login.GetEmailLabeltext();
    	String expectedText = "Email";
    	Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
    	}
    @Test(priority=8)
    public void ClickNext() {
    	waterlog.ClickNextText();
    	String actualText = inhaler.GetHeadingtext();
    	String expectedText = "Inhaler LYF";
    	Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
    	}
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the session properly
            driver = null;
        }
    }
}
