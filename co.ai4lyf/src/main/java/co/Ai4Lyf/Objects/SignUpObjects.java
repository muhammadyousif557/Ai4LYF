package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.Ai4Lyf.Main.Main;

public class SignUpObjects extends Main{
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/activity_name']")
	public WebElement Heading;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/activity']")
	public WebElement ParaText;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/nametv']")
	public WebElement NameLabel;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/ethnicity_tv']")
	public WebElement EthnicityLabel;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/med_tv']")
	public WebElement MedicalConditionLabel;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id='com.lyf.suite.lyfsuite:id/et_name']")
	public WebElement NameField;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/ethnicity_spinner_new']")
	public WebElement EthnicityPlaceHolder;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/medicial_spinner_new']")
	public WebElement MedicalConditionPlaceHolder;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/iv1']")
	public WebElement EthnictyImformativeIcon;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/iv2']")
	public WebElement MedicalConditionInformativeIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/tv_error']")
	public WebElement NameErrorMessage;
	
	@FindBy(xpath="//androidx.cardview.widget.CardView[@resource-id='com.lyf.suite.lyfsuite:id/next_btn']")
	public WebElement NextButton;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/gendertv']")
	public WebElement GenderLabel;
	
	public SignUpObjects() {
        PageFactory.initElements(driver, this);
    }
	
	public String GeTSignUpHeading() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Heading));
		return Heading.getText();
	}
	public String GeTParaText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ParaText));
		return ParaText.getText();
	}
	public String GeTNameLabel() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NameLabel));
		return NameLabel.getText();
	}
	public String GeTNamePlaceHolder() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NameField));
		return NameField.getText();
	}
	public String GeTEthnicityLabel() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(EthnicityLabel));
		return EthnicityLabel.getText();
	}
	public String GeTEthnicityPlaceHolder() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(EthnicityPlaceHolder));
		return EthnicityPlaceHolder.getText();
	}
	public String GeTMedicalConditionLabel() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(MedicalConditionLabel));
		return MedicalConditionLabel.getText();
	}
	public String GeTMedicalConditionPlaceHolder() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(MedicalConditionPlaceHolder));
		return MedicalConditionPlaceHolder.getText();
	}
	public boolean GetEthnictyImformativeIcon() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(EthnictyImformativeIcon));
		return EthnictyImformativeIcon.isDisplayed();
	}
	public boolean GetMedicalConditionInformativeIcon() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(MedicalConditionInformativeIcon));
		return MedicalConditionInformativeIcon.isDisplayed();
	}
	public void ClickNextButton() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NextButton));
		NextButton.click();
	}
	public String GetErrorMessage() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NameErrorMessage));
		return NameErrorMessage.getText();
	}
	public void EnterName(String name) {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NameField));
		NameField.clear();
		NameField.sendKeys(name);
	}
	public String GetGenderLabel() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(GenderLabel));
		return GenderLabel.getText();
	}
	
}
