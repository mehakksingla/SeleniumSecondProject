package io.pragra.learning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CNTesting {

    WebDriver driver;

    @Parameters("browser")

    @BeforeSuite
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mehak Singla\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }


    @Test(enabled = false)
    public void ourServices(){
        driver.get("https://www.cn.ca/en/");
        System.out.println(driver.getCurrentUrl());
        WebElement ourServicesLink = driver.findElement(By.xpath("//a[@id = 'ctl06__7b92477bca6ee5_repMainNav_topLevelLink_1']"));
        WebElement trucking = driver.findElement(By.id("ctl06__7b92477bca6ee5_repMainNav_repSecondLevel_1_secondLevelLink_2"));
        WebElement terminal = driver.findElement(By.id("ctl06__7b92477bca6ee5_repMainNav_repSecondLevel_1_repThirdLevel_2_thirdLevelLink_1"));

        Actions actions = new Actions(driver);
        actions.
                moveToElement(ourServicesLink).
                pause(2000).
                moveToElement(trucking).
                pause(2000).
                moveToElement(terminal).
                pause(2000).
                click().
                build().
                perform();

    }

    @Test(enabled = false)
    public void dblclk(){
        driver.get("http://pragra.co/sel.html");
        WebElement dblclick = driver.findElement(By.id("dblclik"));
        dblclick.click();


//        ((JavascriptExecutor) driver).executeScript("window.scroll(400,900);");

        Actions actions = new Actions(driver);
        actions.moveToElement(dblclick).pause(3000).doubleClick().pause(2000).build().perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void testSample() throws IOException {
        driver.get("http://pragra.co/sel.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        System.out.println(draggable.getText());

        Actions actions = new Actions(driver);
//        actions.dragAndDropBy(draggable, 500,100).build().perform();
        actions.dragAndDrop(draggable, droppable).build().perform();
        driver.manage().window().maximize();

        File screenshot = droppable.getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("screenshot.png"));

        driver.quit();

    }
}
