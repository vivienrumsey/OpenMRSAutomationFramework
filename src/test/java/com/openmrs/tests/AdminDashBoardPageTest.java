package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminDashBoardPageTest extends BaseTest {

    @BeforeClass
    public void adminDashBoardPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("id"), prop.getProperty("pass"));
    }

    @Test(priority = 1)
    public void validateAdminPageNameTest() {
        Assert.assertEquals(adminDashBoardPage.validateAdminPageName(), Constants.ADMIN_PAGE_NAME);
    }

    @Test(priority = 2)
    public void verifyLocationLinkTest() {
        Assert.assertTrue(adminDashBoardPage.verifyLocationLink());
    }

    @Test(priority = 3)
    public void validateAppsListTest() {
        Assert.assertEquals(adminDashBoardPage.getAppName(), Constants.actualAppsList());
    }

    @Test(priority = 4)
    public void verifyLogoutLinkTest() {
        Assert.assertTrue(adminDashBoardPage.verifyLogoutLink());
    }

    @Test(priority = 5)
    public void verifyLogoutTest() {
        adminDashBoardPage.logout();
        Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE);
    }

}
