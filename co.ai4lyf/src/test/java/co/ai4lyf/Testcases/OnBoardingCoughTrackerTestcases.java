package co.ai4lyf.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.OnBoardingHealLyfObjects;
import co.Ai4Lyf.Objects.LoginObjects;
import co.Ai4Lyf.Objects.OnBoardingCoughTracker;
import co.Ai4Lyf.Objects.OnBoardingInHalerTrackerObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;

public class OnBoardingCoughTrackerTestcases extends Main{
	OnBoardingInHalerTrackerObjects inhaler;
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	LoginObjects login;
	OnBoardingCoughTracker cough;
	OnBoardingHealLyfObjects heallyf;
	
	
	public OnBoardingCoughTrackerTestcases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		if (driver == null) {
            getdriver();
        }
		inhaler = new OnBoardingInHalerTrackerObjects();
		welcome = new WelcomeScreenObjects();
		waterlog = new OnBoardingWaterLogObjects();
		cough = new OnBoardingCoughTracker();
		login = new LoginObjects();
		heallyf = new OnBoardingHealLyfObjects();
		welcome.ClickContinueBtn();
		waterlog.ClickNextText();
		inhaler.ClickNextText();
	}
	
	@Test(priority=1)
	public void LogoVerification() {
		 boolean flag = cough.GetLogo();
		 Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void HeadText(){
		String actualText = cough.GetHeadingText();
		String expectedText = "Cough LYF";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=3)
	public void ParaText1(){
		String actualText = cough.GetParatext1();
		String expectedText = "Cough less, breathe more, live free!";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=4)
	public void ParaText2(){
		String actualText = cough.GetParatext2();
		String expectedText = "Let our privacy-aware AI monitor your cough patterns for your better respiratory health.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=5)
	public void SkipText(){
		String actualText = cough.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=6)
	public void NextText(){
		String actualText = cough.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=7)
	public void ClickSkipText(){
		cough.ClickSkipText();
		String actualText = login.GetEmailLabeltext();
    	String expectedText = "Email";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=8)
	public void ClickNextText(){
		cough.ClickNextText();
		String actualText = heallyf.GetHeadingText();
    	String expectedText = "Heal LYF";
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
