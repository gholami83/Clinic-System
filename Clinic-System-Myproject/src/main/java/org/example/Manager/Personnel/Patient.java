package org.example.Manager.Personnel;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Patient implements Serializable {
    String name;
    String nationalID;
    String phone;
    String disease;
    String illnessDescription;
    Date dateRegistered;
    public static int PatientId;
    int patientID;

    public Patient(String name, String nationalID, String phone, String disease, String illnessDescription) {
        this.name = name;
        this.nationalID = nationalID;
        this.phone = phone;
        this.disease = disease;
        this.illnessDescription = illnessDescription;
        dateRegistered = new Date();
        patientID = PatientId;
        PatientId++;
        System.out.println("Patient added successfully!\n");
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisease() {
        return disease;
    }

    public String getIllnessDescription() {
        return illnessDescription;
    }

    public String getNationalID() {
        return nationalID;
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

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setIllnessDescription(String illnessDescription) {
        this.illnessDescription = illnessDescription;
    }

    @Override
    public String toString() {
        return String.format("\nPatient,%s,%s,%s,%s,%s,registered at:%s\n", name, nationalID, phone, disease, illnessDescription, dateRegistered);
    }
}