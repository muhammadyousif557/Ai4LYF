package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.Ai4Lyf.Main.Main;

public class PrivacyPolicy extends Main{
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/activity_name']")
    public WebElement PrivacyPolicy;
	
	
	public PrivacyPolicy() {
        PageFactory.initElements(driver, this);
    }
	
	public String GetHeading() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(PrivacyPolicy));
		return PrivacyPolicy.getText();
	}

}
