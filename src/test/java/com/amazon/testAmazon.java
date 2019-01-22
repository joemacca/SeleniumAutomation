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
        System.out.println("Typed in search box");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.RETURN);
        System.out.println("Down arrow and enter keys pressed");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("The Hitchhiker's Guide to the Galaxy")).click();
        System.out.println("Clicked on book link");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-cart-button")).click();
        System.out.println("Added book to cart");


        sleep(1000);
//        driver.quit();
    }

    public static String USERNAME = "josephmcmanamon1";
    //    public static String AUTOMATE_KEY = "jHiuD4CFHSS3AB8sQQN3";
    public static String AUTOMATE_KEY = "1phFD1iYuBv4H3k6hzJp";
    public static String BSURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    @Category(RegressionTests.class)
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

        java.net.URL browserStackURL = new URL(BSURL);
        WebDriver driver = new RemoteWebDriver(browserStackURL, caps);
        driver.manage().window().maximize();

        driver.get(URL);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("hitchhikers");
        System.out.println("Typed in search box");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.RETURN);
        System.out.println("Down arrow and enter keys pressed");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.linkText("The Hitchhiker's Guide to the Galaxy")).click();
        System.out.println("Clicked on book link");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-cart-button")).click();
        System.out.println("Added book to cart");


        sleep(1000);

        driver.quit();


    }

}

