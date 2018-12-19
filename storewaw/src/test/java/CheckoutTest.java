import Models.Order;
import Models.User;
import Pages.Checkout.CheckoutBasketPage;
import Pages.Checkout.CheckoutInfoPage;
import Pages.Checkout.CheckoutResultPage;
import Pages.ListOfProductsPage;
import Pages.MenuPage;
import Pages.ProductPage;
import Providers.UserFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private MenuPage menu;
    private ListOfProductsPage listOfProductsPage;
    private ProductPage productPage;
    private Order order;
    private CheckoutBasketPage basketPage;
    private CheckoutResultPage resultPage;
    private CheckoutInfoPage addressPage;
    private User user;

    @BeforeMethod
    public void testSetup() {
        menu = new MenuPage(driver);
        listOfProductsPage = new ListOfProductsPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new CheckoutBasketPage(driver);
        addressPage = new CheckoutInfoPage(driver);
        resultPage = new CheckoutResultPage(driver);
        order = new Order();
        user = new UserFactory().getKowalski();
    }

    @Test
    public void checkoutTest() {
        for (int i = 0; i < 3; i++) {
            menu.openRandomCategory();
            String nameToCheck = listOfProductsPage.openRandomProduct();
            Assert.assertEquals(nameToCheck, productPage.getProductName());
            productPage.addProduct(order);
        }
        menu.openBasket();
        basketPage.verifyProducts(order)
                .goToInfoPage();

    }
}
