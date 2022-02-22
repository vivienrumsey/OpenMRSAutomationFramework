package com.openmrs.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public Properties prop;

    /*public WebDriver init_driver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }*/

    public WebDriver init_driver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                //init remote webdrive
                init_remoteDriver("chrome");
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                //init remote webdrive
                init_remoteDriver("firefox");
            } else {
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }

    private void init_remoteDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            //dc.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());

            try {
                driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            DesiredCapabilities dc = DesiredCapabilities.firefox();
            //dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getFirefoxOptions());
            try {
                driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), dc);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public Properties init_prop() {

        prop = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("./src/main/java/com/openmrs/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}

