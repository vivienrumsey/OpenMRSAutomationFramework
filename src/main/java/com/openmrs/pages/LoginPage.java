package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private By logo = By.xpath("//div[@class='logo']/a/img");
    private By loginPageName = By.className("w-auto");
    private By userName = By.id("username");
    private By passWord = By.id("password");
    private By locationsList = By.xpath("//ul[@id='sessionLocation']/li");

    private By inpatientWard = By.id("Inpatient Ward");
    private By isolationWard = By.id("Isolation Ward");
    private By laboratory = By.id("Laboratory");
    private By outpatientClinic = By.id("Outpatient Clinic");
    private By pharmacy = By.id("Pharmacy");
    private By registrationDesk = By.id("Registration Desk");


    private By loginBtn = By.id("loginButton");
    private By cantLoginLink = By.id("cantLogin");
    private By cantLoginMessage = By.xpath("//div[@class='dialog-content']/p");
    private By cantLoginConfirmBtn = By.xpath("//button[@class='confirm']");
    private By loginErrorMessage = By.id("error-message");
    private By locationErrorMessage = By.xpath("//span[@id='sessionLocationError']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public boolean verifyApplicationLogo() {
        return elementUtil.doIsDisplayed(logo);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getLocationName() {
        List<String> locationName = new ArrayList<>();
        List<WebElement> locationsListElement = elementUtil.getElements(locationsList);
        for (WebElement e : locationsListElement) {
            locationName.add(e.getText());
        }
        return locationName;
    }

    public boolean verifyRegisterLink() {
        return elementUtil.doIsDisplayed(registrationDesk);
    }

    public boolean verifyLoginButtonStatus() {
        return elementUtil.doIsEnabled(loginBtn);
    }

    public boolean verifyCantLoginLink() {
        return elementUtil.doIsDisplayed(cantLoginLink);
    }

    public String validateCantLoginMessage() {
        elementUtil.doClick(cantLoginLink);
        return elementUtil.doGetText(cantLoginMessage);
    }

    public String validateLoginWithoutLocation(String userID, String password) {
        elementUtil.doClick(cantLoginConfirmBtn);
        elementUtil.doSendKeys(userName, userID);
        elementUtil.doSendKeys(passWord, password);
        elementUtil.doClick(loginBtn);

        return elementUtil.doGetText(locationErrorMessage);
    }

    public String validateLoginOnlyWithLocation() {
        elementUtil.doClear(userName);
        elementUtil.doClear(passWord);

        elementUtil.doClick(registrationDesk);
        elementUtil.doClick(loginBtn);

        return elementUtil.doGetText(loginErrorMessage);
    }

    public AdminDashBoardPage doLogin(String userID, String password) {
        elementUtil.doSendKeys(userName, userID);
        elementUtil.doSendKeys(passWord, password);
        elementUtil.doClick(registrationDesk);
        elementUtil.waitForElementPresent(loginBtn, 5);
        elementUtil.doClick(loginBtn);
        return new AdminDashBoardPage(driver);
    }

}
