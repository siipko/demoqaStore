package Pages.Checkout;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
