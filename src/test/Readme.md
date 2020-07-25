1. Update pom.xml with required plugins and dependencies.
2. Create test class using word "test" as suffix.
3. create setup method to open browser like chrome, firefox and safari etc
4. create setup method to open url
5. we use different types of locators to inspect the element
    by id
    class name
    tag name
    css selector
    link
    linktext
    xpath
    partialLinkText

6. Our goal is to find the unique element.
7. How to get title of a website which contains keyword "NCR"
8. WebDriver components:
a) getTitle(); ----
        @Test
            public void testSample() throws InterruptedException {
                String title = driver.getTitle();
                System.out.println(title);
                Thread.sleep(2000);
                Assert.assertTrue(title.contains("NCR"));

b) getCurrentUrl(); by using css selector

         WebElement community = driver.findElement(By.cssSelector("div[name='For Foodies']>nav>a:nth-child(2)"));
                community.click();

//or

                ((JavascriptExecutor)driver).executeScript(                     //use javascript executor when simple community.click command doesnt work
                        "arguments[0].scrollIntoview()", community
                );

                ((JavascriptExecutor)driver).executeScript(
                        "arguments[0].click()", community
                );

                System.out.println(driver.getCurrentUrl());
                Assert.assertEquals("https://community.zomato.com/", driver.getCurrentUrl());

c) getPageSource(); ----least useful method

            WebElement community = driver.findElement(By.cssSelector("div[name='For Foodies']>nav>a:nth-child(2)"));
            community.click();
            System.out.println(driver.getPageSource());


d) void close and quit:  close will close the specific tab that we have mentioned in the program and quit will quit the whole browser.
    In technical language -
    The Close() method closes the currently open browser window, which has the WebDriver's focus.
    All other browser windows remain open, and the webdriver's instance remains open and usable too.
    The Quit() closes all browser windows, and further disposes of the WebDriver instance.

      @Test
            public void homeTest() throws InterruptedException {
                driver.get("https://zoom.us/");
                Thread.sleep(2000);

            driver.findElement(By.id("truste-consent-button")).click();

            WebElement elm = driver.findElement(By.linkText("Contact Sales"));
            elm.click();
    // or (run either above command to open contact sale or the below mentioned)
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).click(driver.findElement(By.linkText("Contact Sales"))).build().perform();
            Thread.sleep(5000);
            driver.close();

            driver.quit();
        }

e) how to find xpath using css selectors:
    // means search from the point you are for example - //section[@id = 'main']//input ---- it will search all input mentioned under section
    / means immediate child not sub child or grand child - for example - //section[@id = 'main']/input - it will go to only immediate input attribute not to all input

f) isDisplayed() The isDisplayed method in Selenium verifies if a certain element is present and displayed.
If the element is displayed, then the value returned is true. ...
   isSelected() This method is often used on radio buttons, checkboxes or options in a menu. ...
   isEnabled() This method verifies if an element is enabled.



###### MULTIPLE SELECTION ######
---use http://pragra.co/sel.html
#### Radio button
#### checkbox
#### dropdowns
#### footer example
#### isEnabled
#### isSelected
#### is displayed
#### getAttribute
####

9. How to access the element which is not visible on the screen (like if link popped up another link).
----use https://www.cn.ca/en/

#### how to double click the icon###
----use  http://pragra.co/sel.html

*********Interview Questions***************
### How to scroll an element to particular height?
### Scrolling an element to view- how you gonna do that?


### DragAndDrop
### DragAndDropBy
----use  http://pragra.co/sel.html
### how to take screenshot