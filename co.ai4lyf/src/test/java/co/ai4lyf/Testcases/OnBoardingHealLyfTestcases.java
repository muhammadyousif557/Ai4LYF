package co.ai4lyf.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.LoginObjects;
import co.Ai4Lyf.Objects.OnBoardingCoughTracker;
import co.Ai4Lyf.Objects.OnBoardingHealLyfObjects;
import co.Ai4Lyf.Objects.OnBoardingInHalerTrackerObjects;
import co.Ai4Lyf.Objects.OnBoardingNutriObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;

public class OnBoardingHealLyfTestcases extends Main{
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	OnBoardingInHalerTrackerObjects inhaler;
	OnBoardingCoughTracker cough;
	OnBoardingHealLyfObjects heallyf;
	OnBoardingNutriObjects nutri;
	LoginObjects login;
	
	public OnBoardingHealLyfTestcases() {
		super();
	}
	@BeforeMethod
	public void setup() {
		if (driver == null) {
            getdriver();
        }
		welcome = new WelcomeScreenObjects();
		waterlog = new OnBoardingWaterLogObjects();
		inhaler = new OnBoardingInHalerTrackerObjects();
		cough = new OnBoardingCoughTracker();
		heallyf = new OnBoardingHealLyfObjects();
		nutri = new OnBoardingNutriObjects();
		login = new LoginObjects();
		welcome.ClickContinueBtn();
		waterlog.ClickNextText();
		inhaler.ClickNextText();
		cough.ClickNextText();
	}
	@Test(priority = 1)
	public void LogoVerification() {
		boolean flag = heallyf.GetHealLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 2)
	public void HeadingVerification() {
		String actualText = heallyf.GetHeadingText();
		String expectedText = "Heal LYF";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 3)
	public void ParaVerification() {
		String actualText = heallyf.GetParaText();
		String expectedText = "Heal naturally with science-backed remedies! discover natural remedies and track your treatment adherence for better health.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 4)
	public void SkipTextVerification() {
		String actualText = heallyf.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 5)
	public void NextTextVerification() {
		String actualText = heallyf.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 6)
	public void ClickSkip() {
		heallyf.ClickSkipText();
		String actualText = login.GetEmailLabeltext();
		String expectedText = "Email";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 7)
	public void ClickNext() {
		heallyf.ClickNextText();
		String actualText = nutri.GetHeadingText();
		String expectedText = "Nutri Log";
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
