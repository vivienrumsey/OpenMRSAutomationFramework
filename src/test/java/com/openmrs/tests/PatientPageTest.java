package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PatientPageTest extends BaseTest {

    @BeforeClass
    public void patientPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findPatientRecordPage = adminDashBoardPage.goToFindPatientRecordPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        patientPage = findPatientRecordPage.goToPatientPage();
    }

    @Test(priority = 1)
    public void verifyGActionsLinkTest() {
        Assert.assertTrue(patientPage.verifyGActionsLink());
    }

    @Test(priority = 2)
    public void validateGActionsListTest() {
        Assert.assertEquals(patientPage.getGActionName(), Constants.actualGActionsList());
    }


}
