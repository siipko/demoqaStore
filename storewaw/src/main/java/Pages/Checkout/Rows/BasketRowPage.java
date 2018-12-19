package Pages.Checkout.Rows;

import Models.Product;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BasketRowPage extends BasePage {
    @FindBy(css = "td:nth-of-type(2)")
    private WebElement name;
    @FindBy(css = "input[name='quantity']")
    private WebElement quantity;
    @FindBy(css = "td:nth-of-type(4)")
    private WebElement price;
    @FindBy(css = "td:nth-of-type(5)")
    private WebElement totalPrice;

    public BasketRowPage(WebDriver driver, WebElement element) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    public Product toProduct() {
        return new Product(name.getText(), getDecimal(price),
                Integer.parseInt(quantity.getAttribute("value")), getDecimal(totalPrice));
    }
}
