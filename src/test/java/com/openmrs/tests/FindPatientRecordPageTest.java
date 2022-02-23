package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindPatientRecordPageTest extends BaseTest {

    @BeforeClass
    public void findPatientPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass"));
        elementUtil.waitFor(1000);
        findPatientRecordPage = adminDashBoardPage.goToFindPatientRecordPage();
    }

    @Test(priority = 1)
    public void validatePageNameTest() {
        Assert.assertEquals(findPatientRecordPage.validatePageName(), Constants.FIND_PATIENT_RECORD_PAGE_NAME);
    }

    @Test(priority = 2)
    public void verifyPatientSearchStatusTest() {
        Assert.assertTrue(findPatientRecordPage.verifyPatientSearchStatus());
    }

    @Test(priority = 3)
    public void searchPatientTest() {
        Assert.assertTrue(findPatientRecordPage.searchPatient("tom").verifyGActionsLink());
    }

    @Test(priority = 4)
    public void goToPatientPageTest() {
        Assert.assertTrue(findPatientRecordPage.goToPatientPage().verifyGActionsLink());
    }
}
