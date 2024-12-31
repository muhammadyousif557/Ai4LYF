package co.ai4lyf.Testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import co.Ai4Lyf.Main.Main;
import co.Ai4Lyf.Objects.LoginObjects;
import co.Ai4Lyf.Objects.OTPObjects;
import co.Ai4Lyf.Objects.OnBoardingMedLogObjects;
import co.Ai4Lyf.Objects.OnBoardingWaterLogObjects;
import co.Ai4Lyf.Objects.SignUpObjects;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;
import co.Ai4Lyf.getotp.OTPVerification;
import freemarker.log.Logger;

public class SignUpTestcases extends Main {
	// Create logger instance
	//private static final Logger logger = Logger.getLogger(LoginTestcases.class.getName());
// Intilizingthe Objects classes.
	WelcomeScreenObjects welcome;
	OnBoardingWaterLogObjects waterlog;
	OnBoardingMedLogObjects medicine;
	LoginObjects login;
	OTPVerification getotpfunc;
	OTPObjects otpobj;
	SignUpObjects signup;

	public SignUpTestcases() {
		super();
		getotpfunc = new OTPVerification();
	}

	@BeforeMethod
	public void setup() throws MailosaurException, IOException, InterruptedException {
		// Intilizing the Log file
		//PropertyConfigurator.configure(getClass().getClassLoader().getResource("log4j.properties"));
		getotpfunc.resetGeneratedEmail();
		if (driver == null) {
			getdriver();
		}
		welcome = new WelcomeScreenObjects();
		waterlog = new OnBoardingWaterLogObjects();
		medicine = new OnBoardingMedLogObjects();
		login = new LoginObjects();
		otpobj = new OTPObjects();
		signup = new SignUpObjects();
		welcome.ClickContinueBtn();
		waterlog.ClickSkipText();
		String generatedEmail = getotpfunc.GetGeneratedEmail(); // Call GetGeneratedEmail method
		//System.out.println("Generated Email: " + generatedEmail);
		login.EnterEmail(generatedEmail);// Use the generated email for login
		login.ClickLoginBtn();
		String otp = getotpfunc.GetOTP();
		otpobj.EnterOtp(otp); // Enter OTP in the OTP input field
	}

	@Test(priority = 1)
	public void HeadingVerification() {
		String actualText = signup.GeTSignUpHeading();
		String expectedText = "Set up your profile";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 2)
	public void NameLabelVerification() {
		String actualText = signup.GeTNameLabel();
		String expectedText = "Name *";
		Assert.assertEquals(actualText, expectedText, "The Label text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 3)
	public void NamePlaceHolderVerification() {
		String actualText = signup.GeTNamePlaceHolder();
		String expectedText = "Enter your name";
		Assert.assertEquals(actualText, expectedText, "The PlaceHolder text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 4)
	public void EthnicityLabelVerification() {
		String actualText = signup.GeTEthnicityLabel();
		String expectedText = "Ethnicity";
		Assert.assertEquals(actualText, expectedText, "The Label text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 5)
	public void EthnicityPlaceHolderVerification() {
		String actualText = signup.GeTEthnicityPlaceHolder();
		String expectedText = "Select ethnicity";
		Assert.assertEquals(actualText, expectedText, "The PlaceHolder text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 6)
	public void EthnicityInformativeLogoVerification() {
		boolean flag = signup.GetEthnictyImformativeIcon();
		Assert.assertTrue(flag);
	}

	@Test(priority = 7)
	public void MedicalConditionLabelVerification() {
		String actualText = signup.GeTMedicalConditionLabel();
		String expectedText = "Medical Condition";
		Assert.assertEquals(actualText, expectedText, "The Label text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 8)
	public void MedicalConditionPlaceHolderVerification() {
		String actualText = signup.GeTMedicalConditionPlaceHolder();
		String expectedText = "Select your underlying medical condition";
		Assert.assertEquals(actualText, expectedText, "The PlaceHolder text does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 9)
	public void MedicalConditionInformativeLogoVerification() {
		boolean flag = signup.GetMedicalConditionInformativeIcon();
		Assert.assertTrue(flag);
	}

	@Test(priority = 10)
	public void EmptyName() {
		signup.ClickNextButton();
		String actualText = signup.GetErrorMessage();
		String expectedText = "Name is required ";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 11)
	public void EnterName() {
		signup.EnterName("Yousaf");
		signup.ClickNextButton();
		String actualText = signup.GetGenderLabel();
		String expectedText = "Gender *";
		Assert.assertEquals(actualText, expectedText, "The Label does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 12)
	public void NumericName() {
		signup.EnterName("123456789");
		signup.ClickNextButton();
		String actualText = signup.GetGenderLabel();
		String expectedText = "Gender *";
		Assert.assertEquals(actualText, expectedText, "The Label does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 13)
	public void SpecialCharaterName() {
		signup.EnterName("!@#$%^&*()_+-=[]{};:'/");
		signup.ClickNextButton();
		String actualText = signup.GetGenderLabel();
		String expectedText = "Gender *";
		Assert.assertEquals(actualText, expectedText, "The Label does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 14)
	public void NameMinValidation() {
		signup.EnterName("A");
		signup.ClickNextButton();
		String actualText = signup.GetErrorMessage();
		String expectedText = "Name must be at least 2 characters long";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@Test(priority = 15)
	public void NameMaxValidation() {
		signup.EnterName("Yousaf Yousaf Yousaf Yousaf Yousaf Yousaf Yousaf Yousaf Yousaf Yousaf");
		signup.ClickNextButton();
		String actualText = signup.GetErrorMessage();
		String expectedText = "Name cannot exceed 30 characters";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the session properly
			driver = null;
		}
	}

}
