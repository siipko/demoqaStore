package Pages.Checkout.Rows;

import Models.Product;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ResultRowPage extends BasePage {

    public ResultRowPage(WebDriver driver, WebElement element) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    @FindBy(xpath = "//td[1]")
    private WebElement name;
    @FindBy(xpath = "//td[3]")
    private WebElement quantity;
    @FindBy(xpath = "//td[2]")
    private WebElement price;
    @FindBy(xpath = "//td[4]")
    private WebElement totalPrice;


    public Product toProduct() {
        return new Product(name.getText(), getDecimal(price),
                getInt(quantity), getDecimal(totalPrice));
    }

}
