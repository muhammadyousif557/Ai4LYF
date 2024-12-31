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
import co.Ai4Lyf.Objects.PrivacyPolicy;
import co.Ai4Lyf.Objects.SignUpObjects;
import co.Ai4Lyf.Objects.TermsOfUse;
import co.Ai4Lyf.Objects.WelcomeScreenObjects;
import co.Ai4Lyf.getotp.OTPVerification;
import freemarker.log.Logger;

public class LoginTestcases extends Main{
    // Create logger instance
    private static final Logger logger = Logger.getLogger(LoginTestcases.class.getName());
// Intilizingthe Objects classes.
	WelcomeScreenObjects welcome;
    OnBoardingWaterLogObjects waterlog;
    OnBoardingMedLogObjects medicine;
    LoginObjects login;
    OTPVerification getotpfunc;
    OTPObjects otpobj;
    SignUpObjects signup;
    PrivacyPolicy pp;
    TermsOfUse tc;
	
	public LoginTestcases() {
		super();
		//Intilizing the OTP Verification class
		getotpfunc = new OTPVerification(); 
		
	}
	@BeforeMethod
	public void setup() {
		//Intilizing the Log file
        PropertyConfigurator.configure(getClass().getClassLoader().getResource("log4j.properties"));
        if (driver == null) {
            getdriver();
        }
        welcome = new WelcomeScreenObjects();
        waterlog = new OnBoardingWaterLogObjects();
        medicine = new OnBoardingMedLogObjects();
        login = new LoginObjects();
        otpobj = new OTPObjects();
        signup = new SignUpObjects();
        pp = new PrivacyPolicy();
        tc = new TermsOfUse();
        welcome.ClickContinueBtn();
        waterlog.ClickSkipText();
    }
	
	@Test(priority=1)
	public void BackLogoClick() {
		login.ClickBackIcon();
		String actualText = medicine.GetHeadingText();
		String expectedText = "Medicine Log";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=2)
	public void BackLogoVerification() {
		boolean flag = login.GetBackIcon();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LyfSuiteLogoVerification() {
		boolean flag = login.GetLyfSuiteIcon();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void VerifyHeadingText() {
		String actualText = login.GetHeadingText();
		String expectedText = "LYF Suite";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=5)
	public void VerifyParaText() {
		String actualText = login.GetParaText();
		String expectedText = "Live to Your Fullest";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=6)
	public void VerifyEmailLabelText() {
		String actualText = login.GetEmailLabeltext();
		String expectedText = "Email";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=7)
	public void VerifyEmailPlaceHolderText() {
		String actualText = login.GetEmailPlaceHoldertext();
		String expectedText = "Enter your email address";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=8)
	public void ValidEmail() throws IOException, MailosaurException, InterruptedException {
	    //logger.info("Executing test: ValidEmail");
        String generatedEmail = getotpfunc.GetGeneratedEmail();  // Call GetGeneratedEmail method
        System.out.println("Generated Email: " + generatedEmail);
        login.EnterEmail(generatedEmail);// Use the generated email for login
        login.ClickLoginBtn();
        String otp = getotpfunc.GetOTP();  // Get OTP from email
        //logger.info("OTP received: " + otp);  // Log the OTP
        // Pass the OTP to the EnterOtp method
        otpobj.EnterOtp(otp);  // Enter OTP in the OTP input field
        String actualText = signup.GeTSignUpHeading();
		String expectedText = "Set up your profile";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected value.");
	    //logger.info("Test passed: ValidEmail with actualText: " + actualText);
		System.out.println("Actual Text: " + actualText);
        
    }
	@Test(priority=9)
	public void EmailWithoutDomain1(){
		login.EnterEmail("test");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
		
	}
	@Test(priority=10)
	public void EmailWithoutDomain2(){
		login.EnterEmail("test@");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
		
	}
	@Test(priority=11)
	public void EmailWithoutDomain3(){
		login.EnterEmail("test@@");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=12)
	public void EmailWithDomain1(){
		login.EnterEmail("test@gmail");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=13)
	public void EmailWithOutDomain4(){
		login.EnterEmail("test@gmail.");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=14)
	public void EmailWithOutDomain5(){
		login.EnterEmail("test@gmailcom");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=15)
	public void EmailWithOutDomain6(){
		login.EnterEmail("test@gmail.c");
		login.ClickLoginBtn();
		String actualText = otpobj.GetOtpHeading();
		String expectedText = "Enter OTP";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=16)
	public void EmailWithServer(){
		login.EnterEmail("test@gmail.com");
		login.ClickLoginBtn();
		String actualText = otpobj.GetOtpHeading();
		String expectedText = "Enter OTP";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=17)
	public void EmailWithDoubleDomain1(){
		login.EnterEmail("test@gmail.com.");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=18)
	public void EmailWithDoubleDomain2(){
		login.EnterEmail("test@gmail.com.uk");
		login.ClickLoginBtn();
		String actualText = otpobj.GetOtpHeading();
		String expectedText = "Enter OTP";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=19)
	public void EmailWithPlus(){
		login.EnterEmail("test+1@gmail.com");
		login.ClickLoginBtn();
		String actualText = otpobj.GetOtpHeading();
		String expectedText = "Enter OTP";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=20)
	public void EmailWithSpecialch1(){
		login.EnterEmail("test_1@gmail.com");
		login.ClickLoginBtn();
		String actualText = otpobj.GetOtpHeading();
		String expectedText = "Enter OTP";
		Assert.assertEquals(actualText, expectedText, "The Heading does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	@Test(priority=21)
	public void EmailWithSpecialch2(){
		login.EnterEmail("test@gm_ail.com");
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Please enter a valid email!";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	
	@Test(priority=22)
	public void BottomTextVerification(){
	    String actualText = login.GetBottomText1() + " " + login.GetBottomText2() + " " + login.GetBottomText3() + " " + login.GetBottomText4();
		String expectedText = "By creating an account, you agree to our Privacy Policy & Terms of Use";
		Assert.assertEquals(actualText, expectedText, "The text does not match the expected message.");
		System.out.println("Actual Text: " + actualText);	
	}
	@Test(priority=23)
	public void EmptyEmail(){
		login.ClickLoginBtn();
		String actualText = login.GetErrorMessage();
		String expectedText = "Email is required";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	
	@Test(priority=24)
	public void GetPrivacyPolicy(){
		login.ClickPrivacyPolicy();
		String actualText = pp.GetHeading();
		String expectedText = "Privacy Policy";
		Assert.assertEquals(actualText, expectedText, "The text does not match the expected message.");
		System.out.println("Actual Text: " + actualText);
	}
	
	@Test(priority=25)
	public void GetTermsConditition(){
		login.ClickTerms();
		String actualText = tc.GetTC();
		String expectedText = "Terms & Conditions";
		Assert.assertEquals(actualText, expectedText, "The error message does not match the expected message.");
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