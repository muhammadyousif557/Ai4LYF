package co.Ai4Lyf.Objects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.Ai4Lyf.Main.Main;

public class OTPObjects extends Main {
    
    @FindBy(xpath = "//android.widget.EditText")
    public WebElement OTPBOX;
    
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.lyf.suite.lyfsuite:id/textView']")
    public WebElement OtpHeading;
    
    public OTPObjects() {
        PageFactory.initElements(driver, this);
    }

    public String GetOtpHeading() {
    	WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(OtpHeading));
		return OtpHeading.getText();
    }
    
    public void EnterOtp(String otp) {
        WebDriverWait wait = new WebDriverWait(getdriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(OTPBOX));  // Ensure OTP field is visible
        // Ensure the OTP input field is interactable
        OTPBOX.clear();
        OTPBOX.click();
        OTPBOX.sendKeys(otp);
    }
}
