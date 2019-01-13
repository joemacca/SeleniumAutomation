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

public class testTheHomePage extends baseTestTheHomePage {

//    public static String USERNAME = "robert1049";
public static String USERNAME = "robertoureta3";
//    public static String AUTOMATE_KEY = "jHiuD4CFHSS3AB8sQQN3";
public static String AUTOMATE_KEY = "WcHno2SvoajJzy25LzkK";
    public static String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


//    The following test runs successfully using browserStack & Data is retrieved from CSV file...Date:18/12/2018

    @Test
    @Category(RegressionTests.class)
    @FileParameters("src/test/resources/NewEmployeeTestParameters.csv")
    public void SAPSFCreateNewEmployeeViaBrowserStackUseCSV(String username001, String password001, String FirstName, String MiddleName, String LastName) throws MalformedURLException, InterruptedException {
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

        java.net.URL browserStackURL = new URL(URL);
        WebDriver driver = new RemoteWebDriver(browserStackURL, caps);
        driver.manage().window().maximize();
//        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//        driver.get("http://www.google.com");

        driver.get("https://pmsalesdemo8.successfactors.com/login?company=SFPART016109#/login");
        sleep(10000);
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

        //      Select Company "ACME New Zealand (1001)"

        driver.findElement(By.id("__box0-arrow")).click();
        System.out.println("***Clicked on __box0-arrow");
        sleep(3000);
        WebElement mySelectElement1 = driver.findElement(By.id("__box0-inner"));
        mySelectElement1.click();
        System.out.println("***Clicked on __box0-inner");
        mySelectElement1.sendKeys("ACME New Zealand");
        System.out.println("***sendKeys ACME New Zealand");
        sleep(5000);
        WebElement mySelectElement2 = driver.findElement(By.id("__box0-inner"));
        mySelectElement2.sendKeys(Keys.DOWN, Keys.RETURN);
        System.out.println("***sendKeys DOWN & RETURN");
        sleep(3000);

//      Event Reason "NEW HIRE"

        driver.findElement(By.id("__box1-arrow")).click();
        System.out.println("***Clicked on __box1-arrow");
        sleep(3000);
        WebElement myEventReasonElement1 = driver.findElement(By.id("__box1-inner"));
        myEventReasonElement1.click();
        System.out.println("***Clicked on __box1-inner");
        myEventReasonElement1.sendKeys("New Hire");
        System.out.println("***sendKeys New Hire");
        sleep(5000);
        WebElement myEventReasonElement2 = driver.findElement(By.id("__box1-inner"));
        myEventReasonElement2.sendKeys(Keys.DOWN, Keys.RETURN);
        System.out.println("***sendKeys DOWN & RETURN");
        sleep(3000);



//      First name
        driver.findElement(By.id("__input0-inner")).sendKeys(FirstName);
        sleep(5000);
        driver.findElement(By.id("__input0-inner")).sendKeys(Keys.TAB);
//        Actions action = new Actions(driver);
//        action.moveToElement("__input1-inner");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("__input1-inner")).sendKeys(MiddleName);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        action.moveToElement((By.id("__input2-inner"));
        driver.findElement(By.id("__input2-inner")).sendKeys(LastName);
        sleep(5000);



        //        Complete New Employee application form from this point...
//        Display Name
        driver.findElement(By.id("__input3-inner")).sendKeys(MiddleName);
//        Birth Name
        driver.findElement(By.id("__input4-inner")).sendKeys(MiddleName);
//        Date of Birth
        driver.findElement(By.id("__picker1-inner")).sendKeys("01/10/77");
//        Country of Birth
        driver.findElement(By.id("__box3-arrow")).click();
        sleep(2000);
        driver.findElement(By.id("__item5-__box3-11")).click();
//        Region Of Birth
        driver.findElement(By.id("__input5-inner")).sendKeys(MiddleName);



//        driver.quit();
    }



//    The following test runs successfully using browserStack...Date:18/12/2018
    @Test
    @Category(RegressionTests.class)
    public void SAPSFCreateNewEmployeeViaBrowserStack() throws MalformedURLException, InterruptedException {

//        GetDesiredCapabilities();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", browser_version);
        caps.setCapability("os", os);
        caps.setCapability("os_version", os_version);
        caps.setCapability("resolution", resolution);

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

        java.net.URL browserStackURL = new URL(URL);
        WebDriver driver = new RemoteWebDriver(browserStackURL, caps);
        driver.manage().window().maximize();

        driver.get("https://pmsalesdemo8.successfactors.com/login?company=SFPART016109#/login");
        sleep(10000);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.id("__input1-inner")).sendKeys("crichardson");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("__input2-inner")).sendKeys("Zag2018!");
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("__input0-inner")).sendKeys("James");
        System.out.println("***typed in First Name");
        sleep(5000);
        driver.findElement(By.id("__input0-inner")).sendKeys(Keys.TAB);
//        Actions action = new Actions(driver);
//        action.moveToElement("__input1-inner");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("__input1-inner")).sendKeys("Tiberius");
        System.out.println("***typed in Middle Name");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        action.moveToElement((By.id("__input2-inner"));
        driver.findElement(By.id("__input2-inner")).sendKeys("Kirk");
        System.out.println("***typed in Last Name");
        sleep(5000);
//
        driver.quit();
    }

    @Test
    @Category(RegressionTests.class)
    public void SAPSFCreateNewEmployeeViaLocalChrome() throws MalformedURLException, InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "C:.\\drivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://pmsalesdemo8.successfactors.com/login?company=SFPART016109#/login");
        sleep(10000);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//        driver.findElement(By.id("__input1-inner")).sendKeys("crichardson");
        driver.findElement(By.id("__input1-inner")).sendKeys("crichardson");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.id("__input2-inner")).sendKeys("Zag2018!");
        driver.findElement(By.id("__input2-inner")).sendKeys("Zag2018!");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.id("__button2-content")).click();
//        sleep(7000);

//        Send the Enter Key twice
//        WebElement textbox = driver.findElement(By.id("bizXSearchField-I"));
//        sleep(3000);
//        textbox.sendKeys(Keys.RETURN);
//        System.out.println("***sendKeys 1st RETURN");
//        sleep(3000);
//        textbox.sendKeys(Keys.RETURN);
//        System.out.println("***sendKeys 2nd RETURN");
        // Click on the search button
//        driver.findElement(By.xpath("//input[@value='Go']")).click();
//        driver.findElement(By.xpath("//*[@id='submit-search']")).click();
//        System.out.println("***clicked on the search button");
        sleep(10000);


//        driver.quit();
    }

}
