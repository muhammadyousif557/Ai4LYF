package co.Ai4Lyf.Objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import co.Ai4Lyf.Main.Main;

public class SplashObjects extends Main {
    
    // Objects 
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.lyf.suite.lyfsuite:id/inhaler']")
		public WebElement LogoImage;
    
	@FindBy(xpath = "(//android.widget.TextView[@text='LYF Suite'])")
    	public WebElement SplashHeading;
  
	@FindBy(xpath = "(//android.widget.TextView[@text='Live to Your Fullest'])")
		public WebElement SplashParagraph;

    // Initializing the Page Objects
    public SplashObjects() { 
    	PageFactory.initElements(driver, this); 
    }
    
    // Actions
    public boolean SplashLogo() {
        return LogoImage.isDisplayed();
    }
    public String SplashWelcomeHeading() {
    	return SplashHeading.getText();
    }
    public String SplashPText() {
    	return SplashParagraph.getText();
    }
  
}
