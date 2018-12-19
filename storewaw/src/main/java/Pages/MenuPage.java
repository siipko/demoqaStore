package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuPage extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Product Category')]")
    private WebElement products;

    @FindBy(css = "#menu-item-33 .sub-menu li")
    private List<WebElement> submenuItems;

    @FindBy(className = "count")
    private WebElement count;


    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void openBasket() {
        count.click();
    }

    public void openRandomCategory() {
        moveToElement(products);
        waitForElements(By.cssSelector("#menu-item-33 .sub-menu li"), 6);
        clickRandomElement(submenuItems);
    }

}