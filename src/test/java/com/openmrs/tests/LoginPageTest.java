package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyApplicationLogoTest() {
        Assert.assertTrue(loginPage.verifyApplicationLogo());
    }

    @Test(priority = 2)
    public void validatePageTitleTest() {
        Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 3)
    public void validateLocationsListTest() {
        Assert.assertEquals(loginPage.getLocationName(), Constants.actualLocationsList());
    }

    @Test(priority = 4)
    public void verifyLoginButtonStatusTest() {
        Assert.assertTrue(loginPage.verifyLoginButtonStatus());
    }

    @Test(priority = 5)
    public void verifyCantLoginLinkTest() {
        Assert.assertTrue(loginPage.verifyCantLoginLink());
    }

    @Test(priority = 6)
    public void validateCantLoginMessageTest() {
        Assert.assertEquals(loginPage.validateCantLoginMessage(), Constants.CANT_LOGIN_MESSAGE);

    }

    @Test(priority = 7)
    public void validateLoginWithoutLocationTest() {
        Assert.assertEquals(loginPage.validateLoginWithoutLocation(prop.getProperty("id"), prop.getProperty("pass")),
                Constants.LOCATION_ERROR_MESSAGE);
    }

    @Test(priority = 8)
    public void validateLoginOnlyWithLocationTest() {
        Assert.assertEquals(loginPage.validateLoginOnlyWithLocation(), Constants.LOGIN_ERROR_MESSAGE);
    }

    @Test(priority = 9)
    public void validateUserLoginTest()  {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass"));
        Assert.assertEquals(adminDashBoardPage.validateAdminPageName(), Constants.ADMIN_PAGE_NAME);

    }


}
