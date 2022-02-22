package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PatientPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By gActionsLink = By.xpath("//h3[contains(text(),'General Actions')]");
    private By gActionsList = By.xpath("//div[@class='col-11 col-lg-10']");

    public PatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public boolean verifyGActionsLink() {
        return elementUtil.doIsDisplayed(gActionsLink);
    }

    public List<String> getGActionName() {
        List<String> gActionName = new ArrayList<>();
        List<WebElement> gActionsListElement = elementUtil.getElements(gActionsList);
        for (WebElement e : gActionsListElement) {
            gActionName.add(e.getText());
        }
        return gActionName;
    }

}
