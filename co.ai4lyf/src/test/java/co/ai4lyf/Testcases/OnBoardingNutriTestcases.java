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

public class OnBoardingNutriTestcases extends Main{
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	OnBoardingInHalerTrackerObjects inhaler;
	OnBoardingCoughTracker cough;
	OnBoardingHealLyfObjects heallyf;
	OnBoardingNutriObjects nutri;
	LoginObjects login;
	OnBoardingMedLogObjects medicine;
	
	public OnBoardingNutriTestcases() {
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
	}
	@Test(priority = 1)
	public void LogoVerification() {
		boolean flag = nutri.GetNutriLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 2)
	public void HeadingVerification() {
		String actualText = nutri.GetHeadingText();
		String expectedText = "Nutri Log";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 3)
	public void ParaText1Verification() {
		String actualText = nutri.GetParaText1();
		String expectedText = "Nourish your body, fuel your life!";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 4)
	public void ParaText2Verification() {
		String actualText = nutri.GetParaText2();
		String expectedText = "Achieve your nutritional goals with personalized recipes, diet plans, coaching and tracking.";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 5)
	public void SkipTextVerification() {
		String actualText = nutri.GetSkipText();
		String expectedText = "Skip";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 6)
	public void NextTextVerification() {
		String actualText = nutri.GetNextText();
		String expectedText = "Next";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 7)
	public void ClickSkip() {
		nutri.ClickSkipText();
		String actualText = login.GetEmailLabeltext();
		String expectedText = "Email";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority = 8)
	public void ClickNext() {
		nutri.ClickNextText();
		String actualText = medicine.GetHeadingText();
		String expectedText = "Medicine Log";
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
