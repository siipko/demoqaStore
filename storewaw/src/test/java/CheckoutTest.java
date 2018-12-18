import Models.Order;
import Pages.Checkout.BasketPage;
import Pages.ListOfProductsPage;
import Pages.MenuPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private MenuPage menu;
    private ListOfProductsPage listOfProductsPage;
    private ProductPage productPage;
    private Order order;
    private BasketPage basketPage;

    @BeforeMethod
    public void testSetup() {
        menu = new MenuPage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        order = new Order();

    }

    @Test
    public void checkoutTest() {
        for (int i = 0; i < 2; i++) {
            menu.openRandomCategory();
            String nameToCheck = listOfProductsPage.openRandomProduct();
            Assert.assertEquals(nameToCheck, productPage.getProductName());
            productPage.addProduct(order);
        }

        driver.get("http://store.demoqa.com/products-page/checkout/");
        basketPage.verifyProducts(order);
        
    }
}
