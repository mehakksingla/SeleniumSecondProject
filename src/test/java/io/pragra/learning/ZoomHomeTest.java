package io.pragra.learning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

public class ZoomHomeTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void setUp(String browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mehak Singla\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void homeTest() throws InterruptedException {
        driver.get("https://zoom.us/");
        Thread.sleep(2000);

        driver.findElement(By.id("truste-consent-button")).click();

        WebElement elm = driver.findElement(By.linkText("Contact Sales"));
        elm.click();
// or (run either above command to open contact sale or the below mentioned)

        //it will open contact sale in new tab whereas the above command will open in the same tab.
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.linkText("Contact Sales"))).build().perform();
        Thread.sleep(5000);
        driver.close();

        driver.quit();

        WebElement sigupButton = driver.findElement(By.cssSelector("#signupfree>a"));

        sigupButton.click();
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        driver.navigate().to("https://www1.oanda.com/currency/converter/");
        Thread.sleep(2000);

        driver.findElement(By.id("base_currency_input")).sendKeys("INR");
        driver.findElement(By.id("base_currency_input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.manage().deleteCookieNamed("base_currency_0");

        Cookie cookie = new Cookie("base_currency_0", "CAD");
        driver.manage().addCookie(cookie);

        Thread.sleep(2000);
        driver.navigate().refresh();

        driver.manage().window().fullscreen();

        WebDriver.Window window = driver.manage().window();
        window.setSize(new Dimension(375,900));
        window.setPosition(new Point(600,300));



//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).click(sigupButton).build().perform();
//        Thread.sleep(5000);
//
//        String parent = driver.getWindowHandle();  //getwindow will get current window id where you are pointing
//        Set<String> handles = driver.getWindowHandles();
//        for (String window : handles) {
//            if (!window.equals(parent)) {
//                driver.switchTo().window(window);
//                driver.findElement(By.id("select-0")).click();
//                Thread.sleep(2000);
//                driver.close();
//            }
//        }

//        driver.switchTo().window(parent);
//        ((JavascriptExecutor) driver).executeScript("alert('Hello Guys')");
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.dismiss();
//
//    }


//        public void tearDown () throws InterruptedException {
//            Thread.sleep(5000);
//            driver.quit();
//        }
    }


    @Test
    public void testSample2() throws InterruptedException {
//        WebElement elm = driver.findElement(By.xpath("//div[@class='searchContainer']//input[contains(@placeholder)]"));
//        elm.sendKeys("Momos");
//        Thread.sleep(2000);
//        elm.clear();
//        elm.sendKeys("Dal Makhani");
//        elm.getAttribute("class");
//        elm.getCssValue("font-family");
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].style.display='none'", elm);
//
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].setAttribute('disabled','disabled')", elm);
//
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].value = 'Manchurian'", elm);
//
//
//        Thread.sleep(2000);
//
//        System.out.println(elm.isDisplayed());
//        System.out.println(elm.isEnabled());
//
//        elm.click();
//
//        elm.getRect();
//
//
//        WebElement elm1 = driver.findElement(By.xpath("//div[@class='searchContainer']//div[@aria-label='search button']"));
//        elm1.click();





        //    //*[@class = '']
        //

        //What are the ways to write in input boxes?
        // one way is send keys
        //u can use javscript executor as well if send keys wont work.

    }
}
