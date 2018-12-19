package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public abstract class BasePage {
    public WebDriver driver;
    Actions actionBuilder;
    protected WebDriverWait wait;
    Random rand = new Random();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actionBuilder = new Actions(driver);
        wait = new WebDriverWait(driver, 20);
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElements(By by, int expectedAmount) {
        wait.until(ExpectedConditions.numberOfElementsToBe(by, expectedAmount));
    }

    void moveToElement(WebElement element) {
        actionBuilder.moveToElement(element).perform();
    }

    WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(rand.nextInt(elements.size()));
    }

    void clickRandomElement(List<WebElement> elements) {
        getRandomElement(elements).click();
    }

    protected BigDecimal getDecimal(WebElement element) {
        return new BigDecimal(element.getText().replace("$", "").replace(",", ""));
    }

    protected int getInt(WebElement element) {
        return Integer.parseInt(element.getText());
    }
}