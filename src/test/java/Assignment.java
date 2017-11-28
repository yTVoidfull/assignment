import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import testbase.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

public class Assignment extends TestBase {

    public WebDriver getWebDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "testAdv");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "C:\\Users\\alplesca\\Desktop\\assignment\\app.apk");
        capabilities.setCapability("appActivity","com.test.calc.activities.CalculatorActivity");

        WebDriver driver = null;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    @Test
    public void driverTest() throws Exception {
        WebDriver driver = getWebDriver();
        driver.close();
        driver.quit();
    }
}
