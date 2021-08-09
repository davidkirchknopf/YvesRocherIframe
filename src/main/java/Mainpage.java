
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mainpage {

    protected WebDriver driver;
    protected Mainpage mainpage;

    public Mainpage(WebDriver driver) {
        this.driver = driver;
    }
    public final By WheelButton = By.xpath("//*[@id=\"_wof_close\"]/img");
    public final By ENTER_EMAIL = By.xpath("//input[@type='email']");
    public final By SUBMIT_BUTTON = By.id("//input[@type='submit']");


    public void clickOnEnterEmail() {
        driver.findElement(ENTER_EMAIL).click();
    }
    public void typeInENTER_EMAIL(String keyWord) {
        driver.findElement(ENTER_EMAIL).sendKeys(keyWord);
    }
    public void clickOnSUBMIT_BUTTON() {
        driver.findElement(SUBMIT_BUTTON).click();
    }
}