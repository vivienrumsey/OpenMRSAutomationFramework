package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminDashBoardPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By adminPageName = By.xpath("//h4[contains(text(),'Logged in as Super User (admin) at Registration De')]");
    private By selectedLocation = By.id("selected-location");
    private By appsList = By.xpath("//div[@id='apps']/a");
    private By logoutLink = By.linkText("Logout");
    private By registerPatientLink = By.linkText("Register a patient");
    private By findPatientRecordLink = By.linkText("Find Patient Record");

    public AdminDashBoardPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String validateAdminPageName() {
        return elementUtil.doGetText(adminPageName);
    }

    public boolean verifyLocationLink() {
        return elementUtil.doIsDisplayed(selectedLocation);
    }

    public List<String> getAppName() {
        List<String> appName = new ArrayList<>();
        List<WebElement> appsListElement = elementUtil.getElements(appsList);
        for (WebElement e : appsListElement) {
            appName.add(e.getText());
        }
        return appName;
    }

    public boolean verifyLogoutLink() {
        return elementUtil.doIsDisplayed(logoutLink);
    }

    public LoginPage logout() {
        elementUtil.doClick(logoutLink);
        return new LoginPage(driver);
    }

    public RegisterPatientPage goToRegisterPatientPage() {
        elementUtil.doClick(registerPatientLink);
        return new RegisterPatientPage(driver);
    }

    public FindPatientRecordPage goToFindPatientRecordPage() {
        elementUtil.doClick(findPatientRecordLink);
        return new FindPatientRecordPage(driver);
    }

}
