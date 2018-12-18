import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://store.demoqa.com/");
    }
}
