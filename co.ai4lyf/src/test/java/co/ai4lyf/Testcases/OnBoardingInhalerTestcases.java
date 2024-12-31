package co.ai4lyf.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.LoginObjects;
import co.Ai4Lyf.Objects.OnBoardingCoughTracker;
import co.Ai4Lyf.Objects.OnBoardingInHalerTrackerObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;

public class OnBoardingInhalerTestcases extends Main{
	OnBoardingInHalerTrackerObjects inhaler;
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	LoginObjects login;
	OnBoardingCoughTracker cough;
	
	public OnBoardingInhalerTestcases() {
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
		welcome.ClickContinueBtn();
		waterlog.ClickNextText();	
	}
	
	@Test(priority=1)
	public void LogoVerification() {
		 boolean flag = inhaler.GetLogoInhaler();
		 Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void HeadText(){
		String actualText = inhaler.GetHeadingtext();
		String expectedText = "Inhaler LYF";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=3)
	public void ParaText1(){
		String actualText = inhaler.GetParatext1();
		String expectedText = "Breath to fullest with every puff on time!";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=4)
	public void ParaText2(){
		String actualText = inhaler.GetParatext2();
		String expectedText = "Log and track your inhaler and symptoms smoothly with AI assistance.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=5)
	public void SkipText(){
		String actualText = inhaler.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=6)
	public void NextText(){
		String actualText = inhaler.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=7)
	public void ClickSkipText(){
		inhaler.ClickSkipText();
		String actualText = login.GetEmailLabeltext();
    	String expectedText = "Email";
    	Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
    	}
	@Test(priority=8)
	public void ClickNextText(){
		inhaler.ClickNextText();
		String actualText = cough.GetHeadingText();
    	String expectedText = "Cough LYF";
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
