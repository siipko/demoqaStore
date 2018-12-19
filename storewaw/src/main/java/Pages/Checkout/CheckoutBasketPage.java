package Pages.Checkout;

import Models.Order;
import Models.Product;
import Pages.BasePage;
import Pages.Checkout.Rows.BasketRowPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutBasketPage extends BasePage {
    @FindBy(css = ".product_row")
    private List<WebElement> listOfProduts;
    @FindBy(css = ".yourtotal .pricedisplay")
    private WebElement totalOrderPrice;
    @FindBy(className = "step2")
    private WebElement goToInfoPage;

    public CheckoutBasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutBasketPage goToInfoPage() {
        goToInfoPage.click();
        return this;
    }


    public CheckoutBasketPage verifyProducts(Order order) {
        for (int i = 0; i < listOfProduts.size(); i++) {
            Product expected = order.getProduct(i);
            Product actual = new BasketRowPage(driver, listOfProduts.get(i)).toProduct();
            assertThat(actual).isEqualToComparingFieldByField(expected);
        }
        assertThat(getDecimal(totalOrderPrice)).isEqualTo(order.getTotalOrderCost());
        return this;
    }
}
