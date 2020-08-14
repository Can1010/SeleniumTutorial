import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver81.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}