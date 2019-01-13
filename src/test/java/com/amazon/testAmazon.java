package com.amazon;


import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@RunWith(JUnitParamsRunner.class)

public class testAmazon extends baseTestTheHomePage {

    public static String URL = "https://www.amazon.com/";

    @Test
    @Category(RegressionTests.class)
    public void amazonSearchForBookViaLocalChrome() throws MalformedURLException, InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "C:.\\drivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("hitchhikers");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("The Hitchhiker's Guide to the Galaxy")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-cart-button")).click();

        sleep(1000);
//        driver.quit();
    }

    public static String USERNAME = "josephmcmanamon1";
    //    public static String AUTOMATE_KEY = "jHiuD4CFHSS3AB8sQQN3";
    public static String AUTOMATE_KEY = "1phFD1iYuBv4H3k6hzJp";
    public static String BSURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    @Category(RegressionTests.class)
    @FileParameters("src/test/resources/NewEmployeeTestParameters.csv")
    public void amazonSearchForBookViaBrowserStack() throws MalformedURLException, InterruptedException {
//        GetDesiredCapabilities();
        DesiredCapabilities caps = new DesiredCapabilities();

        if (browserTesting.equals("true")) {

            caps.setCapability("browser", browser);
            caps.setCapability("browser_version", browser_version);
            caps.setCapability("os", os);
            caps.setCapability("os_version", os_version);
            caps.setCapability("resolution", resolution);
        }




        if (browserTesting.equals("false")) {

            caps.setCapability("browserName", browserName);
            caps.setCapability("device", device);
            caps.setCapability("realMobile", realMobile);
            caps.setCapability("os_version", os_version);
            caps.setCapability("browser", browser);
            caps.setCapability("browser_version", browser_version);
        }
//        For Browser running on a Windows machine...here's an example of the required capabilities
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "62.0");
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("resolution", "1024x768");

//        For Android/IOS device...here's an example of the required capabilities
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browserName", "android");
//        caps.setCapability("device", "Samsung Galaxy S8 Plus");
//        caps.setCapability("realMobile", "true");
//        caps.setCapability("os_version", "7.0");

        java.net.URL browserStackURL = new URL(BSURL);
        WebDriver driver = new RemoteWebDriver(browserStackURL, caps);
        driver.manage().window().maximize();
//        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//        driver.get("http://www.google.com");

        driver.get(URL);
        sleep(2000);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        driver.findElement(By.id("__input1-inner")).sendKeys("crichardson");
        driver.findElement(By.id("__input1-inner")).sendKeys(username001);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.id("__input2-inner")).sendKeys("Zag2018!");
        driver.findElement(By.id("__input2-inner")).sendKeys(password001);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("__button2-content")).click();
        sleep(7000);
        // Type "Add New Employee" in the search field
        driver.findElement(By.id("bizXSearchField-I")).sendKeys(valueToBeSearched);
        System.out.println("***typed the search item");
        sleep(5000);

//        Send the Enter Key twice
        WebElement textbox = driver.findElement(By.id("bizXSearchField-I"));
        sleep(3000);
        textbox.sendKeys(Keys.RETURN);
        sleep(3000);
        textbox.sendKeys(Keys.RETURN);
        // Click on the search button
//        driver.findElement(By.xpath("//input[@value='Go']")).click();
//        driver.findElement(By.xpath("//*[@id='submit-search']")).click();
        System.out.println("***clicked on the search button");
        sleep(10000);


    }

}

