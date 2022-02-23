package com.openmrs.base;

import com.openmrs.pages.*;

import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    public  WebDriver driver;
    public Properties prop;
    public ElementUtil elementUtil;
    public BasePage basePage;
    public LoginPage loginPage;
    public AdminDashBoardPage adminDashBoardPage;
    public FindPatientRecordPage findPatientRecordPage;
    public PatientPage patientPage;
    public RegisterPatientPage registerPatientPage;

    @BeforeTest
    public void setup() {
        basePage = new BasePage();
        prop = basePage.init_prop();
        driver = basePage.init_driver(prop.getProperty("browser"));
        loginPage = new LoginPage(driver);
        driver.get(prop.getProperty("url"));

    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }





}
