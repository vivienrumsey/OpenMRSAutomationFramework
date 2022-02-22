package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPatientRecordPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By pageName = By.xpath("//div[@id='content']/h2");
    private By patientSearch = By.id("patient-search");
    private By patientTableRow1 = By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]");
    private By patientIdLink = By.xpath("//em[text()='Patient ID']");
    private By homeIcon = By.xpath("//i[@class='icon-home small']");
    private By findPatientRecordLink = By.linkText("Find Patient Record");

    public FindPatientRecordPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String validatePageName() {
        return elementUtil.doGetText(pageName);
    }

    public boolean verifyPatientSearchStatus() {
        return elementUtil.doIsEnabled(patientSearch);
    }

    public PatientPage searchPatient(String name) {
        elementUtil.doSendKeys(patientSearch, name);
        elementUtil.doClick(patientTableRow1);
        return new PatientPage(driver);
    }

    public PatientPage goToPatientPage() {
        elementUtil.doClick(homeIcon);
        elementUtil.waitFor(2000);
        elementUtil.doClick(findPatientRecordLink);
        elementUtil.doClick(patientTableRow1);
        return new PatientPage(driver);
    }
}
