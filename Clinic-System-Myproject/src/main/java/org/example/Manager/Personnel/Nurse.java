package org.example.Manager.Personnel;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Nurse implements Serializable {
    String name;
    String nationalID;
    String phone;
    String major;
    String levelOfEducation;
    Date dateRegistered;
    String[] workDays = new String[7];
    public static int NurseId = 1;
    int nurseId;

    public Nurse(String name, String nationalID, String phone, String major, String levelOfEducation, String[] workDays) {
        this.name = name;
        this.nationalID = nationalID;
        this.phone = phone;
        this.major = major;
        this.levelOfEducation = levelOfEducation;
        this.workDays = workDays;
        this.dateRegistered = new Date();
        nurseId = NurseId;
        NurseId++;
        System.out.println("Nurse added successfully!\n");
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getPhone() {
        return phone;
    }

    public String getMajor() {
        return major;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public String[] getWorkDays() {
        return workDays;
    }

    @Override
    public String toString() {
        return String.format("\nNurse,%s,%s,%s,%s,%s,registered at:%s\n", name, nationalID, phone, major, levelOfEducation, Arrays.toString(workDays));
    }
}
