package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    private Logger log = Logger.getLogger(this.getClass());
    private WebDriver driver;

    @FindBy(id = "com.test.calc:id/add")
    private WebElement btnAddOne;

    @FindBy(id = "com.test.calc:id/subtract")
    private WebElement btnSubtractOne;

    @FindBy(id = "com.test.calc:id/sqrt")
    private WebElement btnSquareRoot;

    @FindBy(id = "com.test.calc:id/divide")
    private WebElement btnDivideByTwo;

    @FindBy(id = "com.test.calc:id/multiply")
    private WebElement btnMultiplyByTwo;

    @FindBy(id = "com.test.calc:id/power")
    private WebElement btnSquare;

    @FindBy(id = "com.test.calc:id/result")
    private WebElement txtResult;

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage clickAdd(){
        logClickAction(btnAddOne);
        return this;
    }

    public CalculatorPage clickSubtract(){
        logClickAction(btnSubtractOne);
        return this;
    }

    public CalculatorPage clickSquareRoot(){
        logClickAction(btnSquareRoot);
        return this;
    }

    public CalculatorPage clickSquare(){
        logClickAction(btnSquare);
        return this;
    }

    public CalculatorPage clickDivideByTwo(){
        logClickAction(btnDivideByTwo);
        return this;
    }

    public CalculatorPage clickMultiplyByTwo(){
        logClickAction(btnMultiplyByTwo);
        return this;
    }

    public String getResult(){
        String result = txtResult.getText();
        String[] resultParts = result.split(": ");
        return resultParts.length > 1 ? resultParts[1] : "";
    }

    private void logClickAction(WebElement element){
        log.info("clicking on " + element.getText());
        element.click();
    }

}
