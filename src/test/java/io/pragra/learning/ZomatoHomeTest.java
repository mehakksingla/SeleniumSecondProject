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
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mehak Singla\\Downloads\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

    }

    @BeforeTest
    @Parameters("siteUrl")
    public void setUp2(String url) {
        driver.get(url);
    }

    @Test(enabled = false)
    public void testSample() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        Assert.assertTrue(title.contains("NCR"));

        //how to inspect element using css selector
        WebElement community = driver.findElement(By.cssSelector("div[name='For Foodies']>nav>a:nth-child(2)"));
        community.click();

        ((JavascriptExecutor) driver).executeScript(                     //use javascript executor when simple community.click command doesnt work
                "arguments[0].scrollIntoview()", community
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click()", community
        );

        Thread.sleep(2000);     //give some time to browser to load the community website so that it matches with actual and expected url

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("https://community.zomato.com/", driver.getCurrentUrl()); //use assert here to match url with community.zomato.com

        System.out.println(driver.getPageSource());
    }

// to show the difference between void close and void quit : open zoom.us

    @Test(enabled = false)
    public void testSample3() throws InterruptedException {
        //driver.get("https://www.zomato.com/ncr");

        WebElement search = driver.findElement(By.xpath("//div[@class = 'searchContainer']//input[@placeholder ='Search for restaurant, cuisine or a dish']"));
        search.sendKeys("Momos");
        Thread.sleep(2000);
        search.clear();

        search.sendKeys("Manchurian");
        Thread.sleep(2000);

        System.out.println(search.getAttribute("class"));

        System.out.println(search.getCssValue("font-family"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.display='none'", search
        );

        System.out.println(search.isDisplayed());

        ((JavascriptExecutor) driver).executeScript(     //it is a hack that we use in selenium to force run the things
                "arguments[0].setAttribute('disabled' , 'disabled')", search
        );
        System.out.println(search.isEnabled());
    }

    @Test(enabled = false)
        public void testButton(){

            WebElement searchButton = driver.findElement(By.xpath("//div[@class = 'searchContainer']//div[@aria-label = 'search button']"));
            searchButton.click();
    }

    @Test(enabled = false)
    public void dropDownButton() throws InterruptedException {
        WebElement triangle = driver.findElement(By.xpath("//div[@class = 'searchContainer']//i[2]"));
        triangle.click();
        Thread.sleep(2000);


//    @Test(enabled = true)
//    public void testGender() throws InterruptedException {
//
//        driver.get("https://semantic-ui.com/modules/dropdown.html");
//        WebElement gender = driver.findElement(By.xpath("//div[contains(@class, 'another')]/div[@class = 'ui dropdown selection']/select"));
//        Select select = new Select(gender);
//
////        ((JavascriptExecutor) driver).executeScript(
////                "arguments[0].scrollIntoview()", gender
////        );
//
////        ((JavascriptExecutor) driver).executeScript(
////                "arguments[0].click()", gender
////        );
//
//        select.selectByIndex(1);
//        Thread.sleep(2000);
//
//    }

        WebElement country = driver.findElement(By.xpath("//footer//div[@aria-labelledby='country-dropdown-label'] "));
        country.click();

        driver.findElement(By.id("country-canada")).click();

        WebElement fb = driver.findElement(By.xpath("//div[@name ='Social links']//a[@href='https://www.facebook.com/zomato']"));
        Thread.sleep(5000);
        fb.click();


        WebElement mb = driver.findElement(By.xpath("//div//a[@href='https://www.zomato.com/mumbai/']"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div//a[@href='https://www.zomato.com/mumbai/']"))).build().perform();
        driver.switchTo().window("https://www.zomato.com/mumbai");
        Thread.sleep(8000);
    }

    @Test
    public void multiSelection() throws InterruptedException {
        driver.get("http://pragra.co/sel.html");
        WebElement multi = driver.findElement(By.xpath("//select[@name ='cars']"));
        Select select = new Select(multi);
        if (select.isMultiple()){
            System.out.println("Its a multi selection");
        }
        select.selectByValue("vo");
        select.selectByIndex(3);

        select.deselectAll();

        WebElement rbutton = driver.findElement(By.xpath("//input[@class = 'rbutton' and @value = 'f']"));
        rbutton.click();
        Thread.sleep(5000);

        WebElement chkbx = driver.findElement(By.xpath("//input[@class = 'input' and @value = 'java']"));
        if (!chkbx.isSelected()) {
            chkbx.click();
        }
    }

}

//    @Test
//    public void test(){
//        driver.get("http://pragra.co/sel.html");
//        WebElement dclickButton = driver.findElement(By.id("dblclik"));
//        Actions actions = new Actions(driver);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView);",dclickButton);
//
//        ((JavascriptExecutor) driver).executeScript("window.scroll(0,980);");
//
//        WebElement draggable = driver.findElement(By.id("draggable"));
//        WebElement droppable = driver.findElement(By.id("droppable"));
//
//        actions.dragAndDropBy(draggable, 100,100).build().perform();
//
//        actions.dragAndDrop(draggable, droppable).build().perform();
//
//
//    }

//    @AfterSuite
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(10000);
//        driver.quit();
//
//    }
