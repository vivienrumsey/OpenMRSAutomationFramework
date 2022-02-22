package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPatientPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By pageName = By.xpath("//h2[contains(text(),'Register a patient')]");

    private By gName = By.name("givenName");
    private By fName = By.name("familyName");
    private By nextBtn = By.id("next-button");
    private By gender = By.id("gender-field");
    private By male = By.xpath("//option[@value='M']");
    private By female = By.xpath("//option[@value='F']");
    private By bDay = By.id("birthdateDay-field");
    private By bMonth = By.id("birthdateMonth-field");
    private By bYear = By.id("birthdateYear-field");
    private By address = By.id("address1");
    private By address2 = By.id("address2");
    private By city = By.id("cityVillage");
    private By state = By.id("stateProvince");
    private By country = By.id("country");
    private By postalCode = By.id("postalCode");
    private By phoneNumber = By.name("phoneNumber");
    private By confirm = By.id("submit");
    private By patientIdLink = By.xpath("//em[text()='Patient ID']");
    private By homeIcon = By.xpath("//i[@class='icon-home small']");
    private By registerPatientLink = By.linkText("Register a patient");
    private By logoutLink = By.linkText("Logout");

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String validatePageName() {
        return elementUtil.doGetText(pageName);
    }


    public RegisterPatientPage registerNewPatient(String givenName, String familyName, String gender, String bDay, String bMonth, String bYear,
                                          String address, String city, String state, String country, String postalCode, String phoneNumber) {
        elementUtil.doSendKeys(this.gName, givenName);
        elementUtil.doSendKeys(this.fName, familyName);
        elementUtil.doClick(nextBtn);
        if (gender.equalsIgnoreCase("male")) {
            elementUtil.doClick(male);
        } else {
            elementUtil.doClick(female);
        }
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(this.bDay, bDay);
        elementUtil.doSendKeys(this.bMonth, bMonth);
        elementUtil.doSendKeys(this.bYear, bYear);
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(this.address, address);
        elementUtil.doSendKeys(this.city, city);
        elementUtil.doSendKeys(this.state, state);
        elementUtil.doSendKeys(this.country, country);
        elementUtil.doSendKeys(this.postalCode, postalCode);
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(this.phoneNumber, phoneNumber);
        elementUtil.doClick(nextBtn);
        elementUtil.doClick(nextBtn);
        elementUtil.doClick(confirm);
        elementUtil.waitFor(2000);
        elementUtil.doClick(homeIcon);
        elementUtil.waitFor(2000);
        elementUtil.doClick(registerPatientLink);

        return new RegisterPatientPage(driver);
    }

}
