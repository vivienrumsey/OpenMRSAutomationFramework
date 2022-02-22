package com.openmrs.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String LOGIN_PAGE_TITLE = "Login";
    public static final String CANT_LOGIN_MESSAGE = "Please contact your System Administrator.";
    public static final String LOGIN_ERROR_MESSAGE = "Invalid username/password. Please try again.";
    public static final String LOCATION_ERROR_MESSAGE = "You must choose a location!";
    public static final String ADMIN_PAGE_NAME = "Logged in as Super User (admin) at Registration Desk.";
    public static final String REGISTER_PATIENT_PAGE_NAME = "Register a patient";
    public static final String FIND_PATIENT_RECORD_PAGE_NAME = "Find Patient Record";
    public static final String PATIENT_ID_TEXT = "Patient ID";

    public static List<String> actualLocationsList() {
        List<String> list = new ArrayList<>();

        list.add("Inpatient Ward");
        list.add("Isolation Ward");
        list.add("Laboratory");
        list.add("Outpatient Clinic");
        list.add("Pharmacy");
        list.add("Registration Desk");

        return list;

    }

    public static List<String> actualAppsList() {
        List<String> list = new ArrayList<>();

        list.add("Find Patient Record");
        list.add("Active Visits");
        list.add("Register a patient");
        list.add("Capture Vitals");
        list.add("Appointment Scheduling");
        list.add("Reports");
        list.add("Data Management");
        list.add("Configure Metadata");
        list.add("System Administration");

        return list;

    }

    public static List<String> actualGActionsList() {
        List<String> list = new ArrayList<>();

        list.add("Start Visit");
        list.add("Add Past Visit");
        list.add("Merge Visits");
        list.add("Schedule Appointment");
        list.add("Request Appointment");
        list.add("Mark Patient Deceased");
        list.add("Edit Registration Information");
        list.add("Delete Patient");
        list.add("Attachments");

        return list;

    }

}
