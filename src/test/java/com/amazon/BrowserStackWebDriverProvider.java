package com.amazon;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackWebDriverProvider implements WebDriverProvider {

    public WebDriver createDriver(String browserName, String browser, String os, String os_version, String browser_version, String resolution, String device,
                                  String platform, String realMobile, String acceptSslCerts, String browserTesting) {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserTesting.equals("false")) {

            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("platform", platform);
            capabilities.setCapability("realMobile", realMobile);

        }
        if (browserTesting.equals("true")) {
            capabilities.setCapability("resolution", resolution);
        }
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("browser_version", browser_version);
        capabilities.setCapability("os", os);
        capabilities.setCapability("os_version", os_version);
        capabilities.setCapability("device", device);
        capabilities.setCapability("acceptSslCerts", acceptSslCerts);

        return (WebDriver) capabilities;
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return null;
    }

}