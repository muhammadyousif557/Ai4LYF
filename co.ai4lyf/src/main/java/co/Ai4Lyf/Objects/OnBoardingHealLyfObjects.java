package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class OnBoardingHealLyfObjects extends Main{
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/img1']")
	public WebElement Heallogo;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/tv1']")
	public WebElement HeadingText;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Heal naturally with science-backed remedies! discover natural remedies and track your treatment adherence for better health.']")
	public WebElement ParaText;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/skip']")
	public WebElement SkipText;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/next']")
	public WebElement NextText;
	
	
	//Intilization
		public OnBoardingHealLyfObjects() {
			PageFactory.initElements(driver, this);
			}
		
	//Actions
		public boolean GetHealLogo() {
			WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
	        // Wait until the WelcomeParagraph element is visible
	        wait.until(ExpectedConditions.visibilityOf(Heallogo));
			return Heallogo.isDisplayed();
		}
		public String GetHeadingText(){
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
		public String GetSkipText() {
			WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
	        // Wait until the WelcomeParagraph element is visible
	        wait.until(ExpectedConditions.visibilityOf(SkipText));
			return SkipText.getText();	
		}
		public String GetNextText() {
			WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
	        // Wait until the WelcomeParagraph element is visible
	        wait.until(ExpectedConditions.visibilityOf(NextText));
			return NextText.getText();	
		}
		public void ClickSkipText() {
			WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
	        // Wait until the WelcomeParagraph element is visible
	        wait.until(ExpectedConditions.visibilityOf(SkipText));
			SkipText.click();	
		}
		public void ClickNextText() {
			WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
	        // Wait until the WelcomeParagraph element is visible
	        wait.until(ExpectedConditions.visibilityOf(NextText));
	        NextText.click();	
		}
}
