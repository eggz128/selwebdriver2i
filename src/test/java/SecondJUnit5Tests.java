import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static helpers.HelperLib.*;
@DisplayName("The second set of JUnit 5 tests")
public class SecondJUnit5Tests extends TestBase {

    @Test
    @Tag("RunThis")
    @DisplayName("End to end login logout cycle")
    void loginlogout() throws InterruptedException {


        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        driver.findElement(By.id("username")).sendKeys("edgewords");
        driver.findElement(By.id("password")).sendKeys("edgewords123");
        driver.findElement(By.linkText("Submit")).click();

        waitHelper(By.linkText("Log Out"), 3, driver);

        driver.findElement(By.linkText("Log Out")).click();
        driver.switchTo().alert().accept();

        waitHelper(By.id("username"), 10, driver);

        driver.findElement(By.id("username")).sendKeys("finished");

    }


}
