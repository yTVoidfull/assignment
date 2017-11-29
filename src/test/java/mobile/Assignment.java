package mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageobjects.CalculatorPage;
import testbase.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.core.Is.is;


public class Assignment extends TestBase {

    WebDriver driver;
    CalculatorPage calculatorPage;

    public WebDriver getWebDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "testAvd");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", );
        capabilities.setCapability("appActivity","com.test.calc.activities.CalculatorActivity");

        WebDriver driver = null;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    @BeforeMethod
    public void setUpDriver(){
        driver = getWebDriver();
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void checkThatResultIsZeroAtStart() throws Exception {
        logAssertion("result is empty",calculatorPage.getResult(), is("0"));
    }

    @Test
    public void checkThatOnePlusOneIsTwo() throws Exception {
        String result = calculatorPage.clickAdd()
            .clickAdd()
            .getResult();

        logAssertion("result", result, is("2"));
    }

    @Test
    public void checkThatSquareRootOfFourIsTwo() throws Exception {
        String result = calculatorPage.clickAdd()
            .clickMultiplyByTwo()
            .clickSquare()
            .clickSquareRoot()
            .getResult();

        logAssertion("result", result, is("2"));
    }

    @Test
    public void checkThatSixDividedByTwoIsThree() throws Exception {
        String result = calculatorPage.clickAdd()
            .clickMultiplyByTwo()
            .clickSquare()
            .clickMultiplyByTwo()
            .clickSubtract()
            .clickSubtract()
            .clickDivideByTwo()
            .getResult();

        logAssertion("result", result, is("3"));
    }

    @Test
    public void checkThatSquareRootOfNegativeIsNotAProblem() throws Exception {
    String result = calculatorPage.clickSubtract()
        .clickSquareRoot()
        .getResult();

    logAssertion("result", result, is("N/A"));
    }

    @Test
    public void checkThatNegativeToPowerIsPositive() throws Exception {
    String result = calculatorPage.clickSubtract()
        .clickSubtract()
        .clickSquare()
        .getResult();

    logAssertion("result", result, is("-4"));
    }

    @Test
    public void checkThatMinusTwoTimesTwoIsMinusFour() throws Exception {
        String result = calculatorPage.clickSubtract()
            .clickSubtract()
            .clickMultiplyByTwo()
            .getResult();

        logAssertion("result", result, is("-4"));
    }
}
