import Pages.ListOfProductsPage;
import Pages.MenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private MenuPage menu;
    private ListOfProductsPage listOfProductsPage;

    @BeforeMethod
    public void testSetup() {
        menu = new MenuPage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
    }

    @Test
    public void checkoutTest() {
        menu.openRandomCategory();
        String nameToCheck = listOfProductsPage.openRandomProduct();

    }
}
