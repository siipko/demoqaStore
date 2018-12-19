package Pages.Checkout;

import Models.Order;
import Models.User;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[title='billingfirstname']")
    private WebElement firstName;
    @FindBy(css = "input[title='billinglastname']")
    private WebElement lastName;
    @FindBy(css = "input[title='billingcity']")
    private WebElement city;
    @FindBy(css = "select[title='billingcountry']")
    private WebElement country;
    @FindBy(css = "textarea[title='billingaddress']")
    private WebElement address;
    @FindBy(css = "input[title='billingphone']")
    private WebElement phone;
    @FindBy(css = "input[title='billingstate']")
    private WebElement undefined;
    @FindBy(css = "input[title='billingemail']")
    private WebElement email;
    @FindBy(id = "shippingSameBilling")
    private WebElement shippingSameBilling;
    @FindBy(css = "input[value='Purchase']")
    private WebElement purchase;

    @FindBy(xpath = "//tr[@class='total_price total_shipping']//td[2]")
    private WebElement shippingCost;


    public void purchase() {
        purchase.click();
    }

    public CheckoutInfoPage addShippingCost(Order order) {
        order.addShippingCost(getDecimal(shippingCost));
        return this;
    }
    public CheckoutInfoPage setShippingSameAsBilling() {
        shippingSameBilling.click();
        return this;
    }

    public CheckoutInfoPage setUserPersonalData(User user) {
        waitForElement(firstName);
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setPhone(user.getPhone());
        setEmail(user.getEmail());
        setAddress(user.getAddress());
        setCity(user.getCity());
        setCountry(user.getCountry());
        setUndefined(user.getUndefined());
        return this;
    }

    private void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    private void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    private void setCity(String city) {
        this.city.sendKeys(city);
    }

    private void setCountry(String countryName) {
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(countryName);
    }

    private void setAddress(String address) {
        this.address.sendKeys(address);
    }

    private void setPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    private void setUndefined(String undefined) {
        this.undefined.sendKeys(undefined);
    }

    private void setEmail(String email) {
        this.email.sendKeys(email);
    }

}
