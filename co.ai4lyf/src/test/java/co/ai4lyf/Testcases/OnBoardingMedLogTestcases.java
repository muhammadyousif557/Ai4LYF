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
import co.Ai4Lyf.Objects.OnBoardingMedLogObjects;
import co.Ai4Lyf.Objects.OnBoardingNutriObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;

public class OnBoardingMedLogTestcases extends Main{
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	OnBoardingInHalerTrackerObjects inhaler;
	OnBoardingCoughTracker cough;
	OnBoardingHealLyfObjects heallyf;
	OnBoardingNutriObjects nutri;
	LoginObjects login;
	OnBoardingMedLogObjects medicine;
	
	public OnBoardingMedLogTestcases() {
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
		medicine = new OnBoardingMedLogObjects();
		login = new LoginObjects();
		welcome.ClickContinueBtn();
		waterlog.ClickNextText();
		inhaler.ClickNextText();
		cough.ClickNextText();
		heallyf.ClickNextText();
		nutri.ClickNextText();
	}
	@Test(priority = 1)
	public void LogoVerification() {
		boolean flag = medicine.GetMedicineLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 2)
	public void HeadingVerification() {
		String actualText = medicine.GetHeadingText();
		String expectedText = "Medicine Log";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 3)
	public void GetParaText1() {
		String actualText = medicine.GetParaText1();
		String expectedText = "Stay well, never miss a dose again!";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 4)
	public void GetParaText2() {
		String actualText = medicine.GetParaText2();
		String expectedText = "Stay on top of your prescription with our smart scheduling and reminders.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 5)
	public void SkipTextVerification() {
		String actualText = medicine.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 6)
	public void NextTextVerification() {
		String actualText = medicine.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 7)
	public void ClickSkip() {
		medicine.ClickSkipText();
		String actualText = login.GetEmailLabeltext();
		String expectedText = "Email";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 8)
	public void ClickNext() {
		medicine.ClickNextText();
		String actualText = login.GetEmailLabeltext();
		String expectedText = "Email";
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
