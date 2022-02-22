package com.openmrs.utils;

import com.openmrs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;

public class ElementUtil {
    public WebDriver driver;


    public ElementUtil(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        /*if(BasePage.highlight.equalsIgnoreCase("true")) {
            javaScriptUtil.flash(element);
        }*/
        return element;
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }
    public void doClear(By locator) {
        getElement(locator).clear();
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator) {

        return getElement(locator).isDisplayed();
    }

    public boolean doIsEnabled(By locator) {

        return getElement(locator).isEnabled();
    }

    public String doGetText(By locator) {

        return getElement(locator).getText();
    }

    public void doSelectDropDownByVisibleTest(By locator, String text){
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public void waitForElementPresent(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitFor(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String randomString(int len) {
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i <len; i++ ) {
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }

    public List<WebElement> getAllDropdownOptions(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> options = select.getOptions();
        return options;
    }

    public boolean compareDropdownOptions(By locator, String[] expected) {
        List<WebElement> options = getAllDropdownOptions(locator);
        int i = 0;
        for (WebElement opt : options) {
            if(!opt.getText().equals(expected[i])) {
                return false;
            }
            i = i + 1;
        }
        return true;

    }




}
