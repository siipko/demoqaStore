package Pages.Checkout;

import Models.Order;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_row")
    private List<WebElement> listOfProduts;

    @FindBy(css = ".yourtotal .pricedisplay")
    private WebElement totalOrderPrice;

    public void verifyProducts(Order order) {
        for (int i = 0; i < listOfProduts.size(); i++) {
            Assert.assertEquals(order.getProduct(i), new BasketRowPage(driver, listOfProduts.get(i)).toProduct());
        }
        Assert.assertEquals(order.getTotalOrderCost(), totalOrderPrice.getText().replace("$", ""));
    }
}
