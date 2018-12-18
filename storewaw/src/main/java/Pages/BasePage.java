package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public abstract class BasePage {
    WebDriver driver;
    Actions actionBuilder;
    WebDriverWait wait;
    Random rand = new Random();

    BasePage(WebDriver driver) {
        this.driver = driver;
        actionBuilder = new Actions(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElements(By by, int expectedAmount) {
        wait.until(ExpectedConditions.numberOfElementsToBe(by, expectedAmount));
    }

    void moveToElement(WebElement element) {
        actionBuilder.moveToElement(element).perform();
    }

    WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(rand.nextInt(elements.size() - 1));
    }

    void clickRandomElement(List<WebElement> elements) {
        getRandomElement(elements).click();
    }
}