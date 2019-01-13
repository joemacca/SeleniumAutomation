package com.amazon;

import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class baseTestTheHomePage {

    public static String browser;
    public static String browserName;
    public static String os;
    public static String os_version;
    public static String browser_version;
    public static String resolution;
    public static String device;
    public static String platform;
    public static String realMobile;
    public static String browserTesting;
    public static String mode;
    public static String acceptSslCerts;
    public static String valueToBeSearched;


        @BeforeClass
        public static void startup() {

            browser = System.getProperty("browser", "");
            browserName = System.getProperty("browserName", "");
            os = System.getProperty("os", "");
            os_version = System.getProperty("os_version", "");
            browser_version = System.getProperty("browser_version", "");
            resolution = System.getProperty("resolution", "");
            device = System.getProperty("device", "");
            platform = System.getProperty("platform", "");
            realMobile = System.getProperty("realMobile", "false");
            browserTesting = System.getProperty("browserTesting", "false");
            valueToBeSearched = System.getProperty("valueToBeSearched", "Add New Employee");


            mode = System.getProperty("mode", "local");

            acceptSslCerts = System.getProperty("acceptSslCerts", "true");

//            if ("stack".equalsIgnoreCase(mode) || "browserstack".equalsIgnoreCase(mode)){
//                setWebDriver(new com.amazon.BrowserStackWebDriverProvider().createDriver(browser, browserName, os, os_version, browser_version, device, platform, realMobile, acceptSslCerts, browserTesting, resolution));
//
//                System.setProperty("selenide.browser","com.amazon.BrowserStackWebDriverProvider");
//            }

            if ("local".equalsIgnoreCase(mode)) {

//                System.setProperty("selenide.reportsFolder", "C:\\dev\\gitProjects\\custOnBoardingImages");

                // only chrome for local for now.
                if (SystemUtils.IS_OS_WINDOWS) {
                    System.setProperty("webdriver.chrome.driver", "C:.\\drivers\\chromedriver.exe");
                }
//            if (SystemUtils.IS_OS_WINDOWS) {
//                System.setProperty("webdriver.ie.driver", "C:\\dev\\gitProjects\\drivers\\ie11\\IEDriverServer.exe");
//            }
                if (SystemUtils.IS_OS_LINUX) {
                    System.setProperty("webdriver.chrome.driver", "C:.\\drivers\\chromedriver.exe");
                }
                if (SystemUtils.IS_OS_MAC) {
                    System.setProperty("webdriver.chrome.driver", "C:.\\drivers\\chromedriver.exe");
                }
            }
        }
    //category marker interface for PerformanceTests
    public interface PerformanceTests {
    }
    //category marker interface for RegressionTests
    public interface RegressionTests {
    }

//        public static void GetDesiredCapabilities() {
//            valueToBeSearched = System.getProperty("valueToBeSearched", "Add New Employee");
//        }
        @AfterClass
        public static void tearDown(){

//            closeWebDriver();
            System.out.println("***closed down browser, Test finished Successfully ");
        }



}


