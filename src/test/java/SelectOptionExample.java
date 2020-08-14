import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectOptionExample extends Base{
    @Test
    public void select() throws InterruptedException {
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        Select continents=new Select(driver.findElement(By.id("continents")));
 //       continents.deselectAll();
        continents.selectByIndex(5);
        Thread.sleep(1000);
        continents.selectByVisibleText("Asia");
        boolean multiple = continents.isMultiple();
        System.out.println("isMultiple = "  + multiple);

    }

    @Test
    public void multipSelect() throws InterruptedException {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        Select commands = new Select(driver.findElement(By.id("selenium_commands")));
        commands.selectByIndex(4);
        Thread.sleep(500);
        commands.selectByIndex(3);
        Thread.sleep(500);
        List<WebElement> allCommands = commands.getAllSelectedOptions();

        System.out.println("allcommands.size() =" + allCommands.size());
        for (WebElement c:allCommands
            ){
            System.out.println("c.getText() =" + c.getText());
        }

    }

    //    WebDriver driver;
//    @Before
    public void setUp() throws Exception {
        //<editor-fold desc="CHROME">
//               System.setProperty("webdriver.chrome.driver","/Users/elifalp/Documents/WS_Selenium/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        //</editor-fold>

        //<editor-fold desc="FIREFOX">
        //System.setProperty("webdriver.gecko.driver", "/Users/elifalp/Documents/WS_Selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        //</editor-fold>

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        driver.findElement(By.id("cookieChoiceDismiss")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,1000)");
    }

    @Test
    public void selectOptionExample() throws Exception {

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        Select continentOptions = new Select(driver.findElement(By.id("continents")));
        continentOptions.selectByVisibleText("Europe");
        Thread.sleep(1000);
        continentOptions.selectByIndex(3);
        System.out.println(continentOptions.isMultiple());
    }

    @Test
    public void multiSelectExample() throws Exception {

        Select seleniumCommendsOptions = new Select(driver.findElement(By.id("selenium_commands")));
        seleniumCommendsOptions.selectByVisibleText("Navigation Commands");
        seleniumCommendsOptions.selectByIndex(0);
        Thread.sleep(500);
        System.out.println(seleniumCommendsOptions.isMultiple());

        //First way to find the selected options
        System.out.println("\n******************Listing the selected options - first way************");
        List<WebElement> selectOptions = seleniumCommendsOptions.getOptions();
        for (int i = 0; i < selectOptions.size(); i++)
             {
                System.out.println("The option with index " + i + "=" + selectOptions.get(i).getText() +
                                   " ------------> " + (selectOptions.get(i).isSelected() ? "SELECTED" : "not selected"));
        }

        //Second way to find the selected options
        System.out.println("\n******************Listing the selected options - second way************");
        List<WebElement> selectedOnes = seleniumCommendsOptions.getAllSelectedOptions();
        for (int i = 0; i < selectedOnes.size(); i++)
        {
            System.out.println("The option with index " + i + "=" + selectOptions.get(i).getText());
        }

        System.out.println("\n******************After deselection************");
        //seleniumCommendsOptions.deselectByIndex(4);
        seleniumCommendsOptions.deselectAll();
        for (int i = 0; i < selectOptions.size(); i++)
        {
            System.out.println("The option with index " + i + "=" + selectOptions.get(i).getText() +
                    " ---------->" + (selectOptions.get(i).isSelected() ? "selected" : "not selected"));
        }


    }


 //   @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}

