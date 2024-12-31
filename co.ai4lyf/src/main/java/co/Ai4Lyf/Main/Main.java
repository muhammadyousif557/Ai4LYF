package co.Ai4Lyf.Main;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import java.time.Duration;

public class Main {
	public static AndroidDriver driver;
    public AndroidDriver getdriver() {
        if (driver == null) { // Check for existing driver session
            UiAutomator2Options options = new UiAutomator2Options();
            options.setCapability("deviceName", "Pixel 7");
            options.setCapability("udid", "emulator-5554");
            options.setCapability("platformName", "Android");
            options.setCapability("platformVersion", "11.0");
            options.setCapability("appPackage", "com.lyf.suite.lyfsuite");
            options.setCapability("appActivity", "com.lyf.suite.lyfsuite.lyf_suite.ui.activity.splash.SplashActivity");
            options.setCapability("automationName", "UiAutomator2");
            options.setCapability("uiautomator2ServerInstallTimeout", 180000);
            options.setCapability("newCommandTimeout", 1800);

            try {
                URI serverURI = new URI("http://127.0.0.1:4723/");
                URL serverURL = serverURI.toURL();
                driver = new AndroidDriver(serverURL, options);
                System.out.println("Application Started...");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Implicit wait
            } catch (URISyntaxException e) {
                System.err.println("Invalid URI syntax: " + e.getMessage());
            } catch (MalformedURLException e) {
                System.err.println("Invalid Appium Server URL: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println("Driver initialization failed: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;  // Return existing driver if already created
    }
}

