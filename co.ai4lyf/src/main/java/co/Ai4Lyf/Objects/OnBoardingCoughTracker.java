package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class OnBoardingCoughTracker extends Main{
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/img1']")
	public WebElement LogoCough;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/tv1']")
	public WebElement HeadingText;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/text1']")
	public WebElement ParaText1;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Let our privacy-aware AI monitor your cough patterns for your better respiratory health.']")
	public WebElement ParaText2;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/skip']")
	public WebElement SkipText;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/next']")
	public WebElement NextText;
	
	//Intilization
	public OnBoardingCoughTracker() {
		PageFactory.initElements(driver, this);
		}
	
	
	//Actions
	public boolean GetLogo() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(LogoCough));
		return LogoCough.isDisplayed();
	}
	
	public String GetHeadingText(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(HeadingText));
		return HeadingText.getText();	
	}
	
	public String GetParatext1(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(ParaText1));
		return ParaText1.getText();	
	}
	
	public String GetParatext2(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(ParaText2));
		return ParaText2.getText();	
	}
	
	public String GetSkipText(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(SkipText));
		return SkipText.getText();	
	}
	
	public String GetNextText(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(NextText));
		return NextText.getText();	
	}
	public void ClickSkipText(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(SkipText));
		SkipText.click();	
	}
	public void ClickNextText(){
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(NextText));
		NextText.click();	
	}
	}


