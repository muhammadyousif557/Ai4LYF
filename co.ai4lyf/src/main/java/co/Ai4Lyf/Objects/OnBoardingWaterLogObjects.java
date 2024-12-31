package co.Ai4Lyf.Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class OnBoardingWaterLogObjects extends Main {
	
	// Page Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/img1']")
	public WebElement WaterLogLogo;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/tv1']")
	public WebElement MainHeading;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/text1']")
	public WebElement WaterLogPara1;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Let our smart tracking, reminders, and insights help you meet your hydration goals.']")
	public WebElement WaterLogPara2;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/skip']")
	public WebElement SkipText;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/next']")
	public WebElement NextText;
	
	
	
	// Initializing Page Objects
	public OnBoardingWaterLogObjects() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public boolean GetWaterLogo() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(WaterLogLogo));
        return WaterLogLogo.isDisplayed();
    }
	public String GetMainHeading () {
		return MainHeading.getText();
	}
	public String GetWaterLogPara1 () {
		return WaterLogPara1.getText();
	}
	public String GetWaterLogPara2 () {
		return WaterLogPara2.getText();
	}
	public String GetSkipText () {
		return SkipText.getText();
	}
	public void ClickSkipText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(SkipText));
		SkipText.click();
	}
	public String GetNextText () {
		return NextText.getText();
	}
	public void ClickNextText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NextText));
		NextText.click();
	}
	
}
