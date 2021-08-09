import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("https://yves-rocher.hu");
        driver.manage().window().maximize();
    }

    @Test
    public void WheelTest() throws InterruptedException {
        Mainpage mainpage = new Mainpage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.attributeToBe(By.xpath("/html/body/iframe"), "sytle", "//iframe[@style='display: block; opacity: 1; transition: opacity 0.2s ease 0s; position: fixed; inset: 0px; border: none; width: 100%; height: 100%; z-index: 9999999;']"));
        Thread.sleep(5000);
        /*List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < iframes.size(); i++) {
            System.out.println(iframes.get(i).getAttribute("style"));}
        WebElement iframe = driver.findElement(By.xpath("/html/body/iframe"));*/
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@style='display: block; opacity: 1; transition: opacity 0.2s ease 0s; position: fixed; inset: 0px; border: none; width: 100%; height: 100%; z-index: 9999999;']")));
        //System.out.println(driver.getPageSource());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("azanyadat@te.iframe");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.RETURN).build().perform();
        //Thread.sleep(5000);
        //driver.quit();
    }
}