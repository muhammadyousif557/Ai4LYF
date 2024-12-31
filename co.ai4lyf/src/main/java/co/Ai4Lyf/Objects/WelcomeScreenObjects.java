package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class WelcomeScreenObjects extends Main{
	
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@index='0']")
    	public WebElement WelcomeLogoImage;
    
	@FindBy(xpath = "//android.widget.TextView[@text='Welcome to LYF Suite']")
		public WebElement WelcomeHeading;
  
	@FindBy(xpath = "//android.widget.TextView[@text=\"Live to Your Fullest with LYF Suite!\nGet premium holistic personal care,\nall in one easy-to-use platform.\"]")
  		public WebElement WelcomeParagraph;

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.lyf.suite.lyfsuite:id/continue_btn']")
		public WebElement ContinueBtn;
  
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/tv1']")
		public WebElement WaterLogText;
  
  
  //Initializing the Page Objects
	public WelcomeScreenObjects() {
        //super(); 
        PageFactory.initElements(driver, this);  
    }
	
	//Actions
	public boolean WelcomeLogo() {
        return WelcomeLogoImage.isDisplayed();
    }
	
	public String WelcomeScreenHeading() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(WelcomeHeading));
    	return WelcomeHeading.getText();
    }
	
	public String WelcomeScreenPara() {
		// Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(WelcomeParagraph));
        // Return the text of the WelcomeParagraph element
        return WelcomeParagraph.getText();
    }
	
	public void ClickContinueBtn() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10)); // Wait up to 10 seconds
	    wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)); // Wait until the button is clickable
	    ContinueBtn.click();
	}
	
	public String GetWaterLogText() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        // Wait until the WelcomeParagraph element is visible
        wait.until(ExpectedConditions.visibilityOf(WaterLogText));
		return WaterLogText.getText();
	}
	
}
