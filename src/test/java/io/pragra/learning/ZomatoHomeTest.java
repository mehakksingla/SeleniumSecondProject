package io.pragra.learning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class ZomatoHomeTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeSuite
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mehak Singla\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("FIREFOX")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mehak Singla\\Downloads\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

    }


    @BeforeTest
    @Parameters("siteUrl")
    public void setUp2(String url){
        driver.get(url);
    }

//    @Test
//    public void testSample() throws InterruptedException {
//        String title = driver.getTitle();
//        System.out.println(title);
//        Assert.assertTrue(title.contains("NCR"));
//        WebElement community = driver.findElement(By.cssSelector("div[name='For Foodies']>nav>a:nth-child(2)"));

//        ((JavascriptExecutor)driver).executeScript(
//                "arguments[0].scrollIntoview()", community
//        );
//
//        ((JavascriptExecutor)driver).executeScript(
//                "arguments[0].click()", community
//        );
//
//        Thread.sleep(2000);
//        System.out.println(driver.getCurrentUrl());
//
//        Assert.assertEquals("https://community.zomato.com/", driver.getCurrentUrl());
//
//        System.out.println(driver.getPageSource());

//        WebElement elm = driver.findElement(By.linkText("Contact Sales"));
//        elm.click();
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.linkText("Contact Sales"))).build().perform();
//        Thread.sleep(5000);
//        driver.close();
//    }

    @Test(enabled = false)
    public void testSample3() throws InterruptedException{
        driver.get("https://www.zomato.com/ncr");

//        WebElement country = driver.findElement(By.xpath("//footer//div[@aria-labelledby='country-dropdown-label'] "));
//        country.click();
//
//        driver.findElement(By.id("country-canada")).click();
//
//       WebElement fb = driver.findElement(By.xpath("//div[@name ='Social links']//a[@href='https://www.facebook.com/zomato']"));
//       Thread.sleep(5000);
//       fb.click();


        WebElement mb= driver.findElement(By.xpath("//div//a[@href='https://www.zomato.com/mumbai/']"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div//a[@href='https://www.zomato.com/mumbai/']"))).build().perform();
        driver.switchTo().window("https://www.zomato.com/mumbai");
        Thread.sleep(8000);



        //WebElement genders = driver.findElement(By.xpath("//select[@name='cars']"));
        //WebElement lang = driver.findElement(By.xpath("//select[@id='language']"));
       // WebElement chkbx = driver.findElement(By.xpath("//input[@type = 'checkbox' and @value='java']"));

//        if (!chkbx.isSelected()){
//            chkbx.click();
//        }
//

        //Select select = new Select(lang);

//        if (select.isMultiple()){
//            System.out.println("Yes, its a multiple select");
//        }

//        select.selectByValue("en");
//        select.selectByValue("hi");
//
//        Thread.sleep(3000);



        Thread.sleep(5000);
       // select.deselectAll();Thread.sleep(8000);


//        WebElement elm2 = driver.findElement(By.xpath("//*[@class = 'rbbb40-1 MxLSp sc-bEjcJn iTYxnG']//*[@aria-labelledby = 'icon-svg-title-DownTriangle icon-svg-desc-DownTriangle']"));
//        elm2.click();
//        Thread.sleep(2000);

    }

    @Test
    public void test(){
        driver.get("http://pragra.co/sel.html");
        WebElement dclickButton = driver.findElement(By.id("dblclik"));
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView);",dclickButton);

        ((JavascriptExecutor) driver).executeScript("window.scroll(0,980);");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDropBy(draggable, 100,100).build().perform();

        actions.dragAndDrop(draggable, droppable).build().perform();


    }

//    @AfterSuite
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(10000);
//        driver.quit();
//
//    }



}
