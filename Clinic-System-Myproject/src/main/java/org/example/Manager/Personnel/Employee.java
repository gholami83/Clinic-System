package org.example.Manager.Personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Employee implements Serializable {
    String name;
    String nationalID;
    String phone;
    String major;
    String[] workDays = new String[7];
    Date dateRegistered;
    public static int EmployeeId = 1;
    int employeeId;

    public Employee(String name, String nationalID, String phone, String major, String[] workDays) {
        this.name = name;
        this.nationalID = nationalID;
        this.phone = phone;
        this.major = major;
        this.workDays = workDays;
        this.dateRegistered = new Date();
        employeeId = EmployeeId;
        EmployeeId++;
        System.out.println("Employee added successfully!\n");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setWorkDays(String[] workDays) {
        this.workDays = workDays;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMajor() {
        return major;
    }

    public String[] getWorkDays() {
        return workDays;
    }

    @Override
    public String toString() {
        return String.format("\nEmployee,%s,%s,%s,%s,%s,registered at:%s\n", name, nationalID, phone, major, Arrays.toString(workDays), dateRegistered);
    }

}
