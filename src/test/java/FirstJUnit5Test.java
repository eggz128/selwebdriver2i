import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

@Tag("RunThis")
public class FirstJUnit5Test extends TestBase{

// a comment to check polling scm in jenkins



    @Test
    void firstTest(){

        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();


    }

    @Test
    void twoitest(){
        driver.get("https://2itesting.com/contact/");
        driver.findElement(By.id("28eb7d9f-fbea-44cb-e3f2-19ba0f4bfe5d")).click();
        driver.findElement(By.id("28eb7d9f-fbea-44cb-e3f2-19ba0f4bfe5d")).sendKeys("Hello world");
    }

    @Test
    void floattest(){
        driver.get("https://edgewordstraining.co.uk/webdriver2/docs/cssXPath.html");
        String floattext = driver.findElement(By.xpath("//div[@id='floater']")).getText();
        assertThat(floattext, containsString("float left"));
    }
    @Test
    void secondTest(){
        // Test name: SelIDEDemo
        // Step # | name | target | value
        // 1 | open | /webdriver2/ |
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        // 2 | setWindowSize | 974x1003 |
        driver.manage().window().setSize(new Dimension(974, 1003));
        // 3 | click | css=.last span |
        driver.findElement(By.cssSelector(".last span")).click();
        // 4 | click | css=li:nth-child(3) span |
        driver.findElement(By.cssSelector("li:nth-child(3) span")).click();
        // 5 | click | id=textInput |
        driver.findElement(By.id("textInput")).click();
        // 6 | type | id=textInput | steve powell
        driver.findElement(By.id("textInput")).sendKeys("steve powell");
        // 7 | click | id=textArea |
        driver.findElement(By.id("textArea")).click();
        // 8 | click | id=textArea |
        driver.findElement(By.id("textArea")).click();
        // 9 | type | id=textArea | was\nhere\n
        driver.findElement(By.id("textArea")).sendKeys("was\nhere\n");
        // 10 | click | id=checkbox |
        driver.findElement(By.id("checkbox")).click();
        // 11 | click | id=select |
        driver.findElement(By.id("select")).click();
        // 12 | select | id=select | label=Selection Two
        {
            WebElement dropdown = driver.findElement(By.id("select"));
            dropdown.findElement(By.xpath("//option[. = 'Selection Two']")).click();
        }
        // 13 | click | id=two |
        driver.findElement(By.id("two")).click();
        // 14 | click | linkText=Submit |
        driver.findElement(By.linkText("Submit")).click();
        // 15 | click | css=tr:nth-child(2) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).click();
        // 16 | assertText | id=textInputValue | steve powell
        assertThat(driver.findElement(By.id("textInputValue")).getText(), is("steve powell"));
        // 17 | click | css=tr:nth-child(3) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(3)")).click();
        // 18 | verifyText | id=textAreaValue | was here
        try{
            //driver.findElement(By.linkText("Not there"));
            assertThat(driver.findElement(By.id("textAreaValue")).getText(), is("was not here"));
        } catch (AssertionError e){
            verificationerrors.append(e.toString());
        }

        // 19 | click | linkText=Back to form |
        driver.findElement(By.linkText("Back to form")).click();
        // 20 | click | linkText=CSS/XPath |
        driver.findElement(By.linkText("CSS/XPath")).click();

        //Drag drop using actions
        WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().moveByOffset(100,0).release();
        builder.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 21 | mouseDownAt | css=.ui-slider-handle | 5.546875,16.453125
//        {
//            WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element).clickAndHold().perform();
//        }
//        // 22 | mouseMoveAt | css=.ui-slider-handle | 5.546875,16.453125
//        {
//            WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element).perform();
//        }
//        // 23 | mouseUpAt | css=.ui-slider-handle | 5.546875,16.453125
//        {
//            WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(element).release().perform();
//        }
        // 24 | click | css=.ui-slider-handle |
        driver.findElement(By.cssSelector(".ui-slider-handle")).click();
        // 25 | click | css=li:nth-child(1) span |
        driver.findElement(By.cssSelector("li:nth-child(1) span")).click();
    }
}
