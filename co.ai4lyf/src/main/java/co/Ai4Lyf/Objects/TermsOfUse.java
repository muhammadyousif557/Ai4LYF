package co.Ai4Lyf.Objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.Ai4Lyf.Main.Main;

public class TermsOfUse extends Main{
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/activity_name']")
    public WebElement TC;
	
	public TermsOfUse() {
		 PageFactory.initElements(driver, this);
	}
	
	public String GetTC() {
		WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		// Wait until the WelcomeParagraph element is visible
		wait.until(ExpectedConditions.visibilityOf(TC));
		return TC.getText();
	}


}
