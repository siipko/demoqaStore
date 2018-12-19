package Pages.Checkout;

import Models.Order;
import Models.Product;
import Pages.BasePage;
import Pages.Checkout.Rows.ResultRowPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutResultPage extends BasePage {
    @FindBy(css = "tbody tr")
    private List<WebElement> listOfProduts;

    @FindBy(xpath = "//div/p[3]")
    private WebElement totalOrderPrice;

    public CheckoutResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutResultPage verifyProducts(Order order) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), order.getSize()));
        for (int i = 0; i < listOfProduts.size(); i++) {
            Product expected = order.getProduct(i);
            Product actual = new ResultRowPage(driver, listOfProduts.get(i)).toProduct();
            assertThat(actual).isEqualToComparingFieldByField(expected);
        }
        String expected = order.getTotalOrderCostWithShipping().toString();
        String actual = totalOrderPrice.getAttribute("innerHTML").replace(",", "");
        assertThat(actual).contains(expected);
        return this;
    }
}
