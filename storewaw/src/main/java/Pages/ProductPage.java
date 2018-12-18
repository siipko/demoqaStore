package Pages;

import Models.Order;
import Models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "prodtitle")
    private WebElement productName;

    @FindBy(css = ".currentprice")
    private WebElement productPrice;

    @FindBy(css = ".wpsc_buy_button")
    private WebElement addToBasket;

    @FindBy(css = ".count")
    private WebElement basketCount;

    public String getProductName() {
        return productName.getText();
    }

    public void addProduct(Order order) {
        int n = rand.nextInt(2) + 1;
        for (int i = 0; i < n; i++) {
            order.addProduct(new Product(getProductName(), productPrice.getText()));
            addToBasket.click();
            wait.until(ExpectedConditions.textToBePresentInElement(basketCount, String.valueOf(order.getAmountOfProducts())));
        }
    }

}
