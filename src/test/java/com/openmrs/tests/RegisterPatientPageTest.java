package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import com.openmrs.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPatientPageTest extends BaseTest {

    @BeforeClass
    public void registerPatientPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass"));
        registerPatientPage = adminDashBoardPage.goToRegisterPatientPage();
    }

    @Test(dataProvider = "getUserData")
    public void registerNewPatientTest(String givenName, String familyName, String gender, String bDay, String bMonth, String bYear,
                                       String address, String city, String state, String country, String postalCode, String phoneNumber) {
        registerPatientPage.registerNewPatient(givenName, familyName, gender, bDay, bMonth, bYear, address, city, state, country, postalCode, phoneNumber);
        Assert.assertEquals(registerPatientPage.validatePageName(), Constants.REGISTER_PATIENT_PAGE_NAME);

    }

    @DataProvider
    public Object[][] getUserData() {
        Object data[][] = ExcelUtil.getTestData("Sheet2");
        return data;
    }

}
