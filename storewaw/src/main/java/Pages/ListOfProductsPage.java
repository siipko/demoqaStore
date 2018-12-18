package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListOfProductsPage extends BasePage {

    @FindBy(className = "wpsc_product_title")
    private List<WebElement> products;

    public ListOfProductsPage(WebDriver driver) {
        super(driver);
    }

    public String openRandomProduct(){
        WebElement element = getRandomElement(products);
        String name = element.getText();
        element.click();
        return name;
    }
}
