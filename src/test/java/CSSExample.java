import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSExample extends Base{
    @Test
    public void CSSTest() throws Exception {
        String text;

//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver81.exe");
//        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/login/");
        text = driver.findElement(By.cssSelector("#loginbutton")).getText();
        System.out.println(text);
        driver.quit();

//      driver.get("https://www.travelup.com/en-gb");
//      text = driver.findElement(By.cssSelector("h1[class$='navbar-brand']")).getAttribute("");
//      System.out.println(text);
    }
}