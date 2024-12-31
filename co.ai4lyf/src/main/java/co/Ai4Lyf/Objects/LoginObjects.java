package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class LoginObjects extends Main {
	// Objects

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Back']")
	public WebElement BackIcon;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.lyf.suite.lyfsuite:id/linearlayout']/android.widget.ImageView")
	public WebElement LyfSuiteIcon;

	@FindBy(xpath = "//android.widget.TextView[@text='LYF Suite']")
	public WebElement HeadingText;

	@FindBy(xpath = "//android.widget.TextView[@text='Live to Your Fullest']")
	public WebElement ParaText;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/textView']")
	public WebElement EmailLabeltext;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.lyf.suite.lyfsuite:id/ed_email']")
	public WebElement EmailPlaceHoldertext;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.lyf.suite.lyfsuite:id/ed_email']")
	public WebElement EmailtextBox;

	@FindBy(xpath = "//androidx.cardview.widget.CardView[@resource-id='com.lyf.suite.lyfsuite:id/login_btn']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/emailerror']")
	public WebElement ErroMessage;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/t1']")
	public WebElement BottomText1;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/privacy_policy']")
	public WebElement BottomText2;

	@FindBy(xpath = "//android.widget.TextView[@text='&']")
	public WebElement BottomText3;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/termsofuse']")
	public WebElement BottomText4;
	
	// Intilization
	public LoginObjects() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void ClickBackIcon() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BackIcon));
		BackIcon.click();
	}

	public boolean GetBackIcon() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BackIcon));
		return BackIcon.isDisplayed();
	}

	public boolean GetLyfSuiteIcon() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(LyfSuiteIcon));
		return LyfSuiteIcon.isDisplayed();
	}

	public String GetHeadingText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(HeadingText));
		return HeadingText.getText();
	}

	public String GetParaText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(ParaText));
		return ParaText.getText();
	}

	public String GetEmailLabeltext() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(EmailLabeltext));
		return EmailLabeltext.getText();
	}

	public String GetEmailPlaceHoldertext() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(EmailPlaceHoldertext));
		return EmailPlaceHoldertext.getText();
	}
	
	public void EnterEmail(String email) {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(EmailtextBox));
		EmailtextBox.clear();
		//EmailtextBox.click();
		EmailtextBox.sendKeys(email);
	}
	
	public void ClickLoginBtn() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
	}
	public String GetErrorMessage() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(ErroMessage));
		return ErroMessage.getText();
	}
	
	public String GetBottomText1() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BottomText1));
		return BottomText1.getText();
	}
	
	public String GetBottomText2() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BottomText2));
		return BottomText2.getText();
	}
	
	public String GetBottomText3() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BottomText3));
		return BottomText3.getText();
	}
	public String GetBottomText4() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(BottomText4));
		return BottomText4.getText();
	}
	public void ClickPrivacyPolicy() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(BottomText2));
		BottomText2.click();
	}
	
	public void ClickTerms() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(BottomText4));
		BottomText4.click();
	}
	
}
