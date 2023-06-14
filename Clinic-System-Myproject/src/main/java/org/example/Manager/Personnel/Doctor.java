package org.example.Manager.Personnel;

import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import static org.example.Manager.Personnel.VisitManager.*;

public class Doctor implements Serializable {
    String name;
    String nationalID;
    String phone;
    String major;
    String levelOfEducation;
    Date dateRegistered;
    String[] workDays = new String[7];
    ArrayList<Patient> relatedPatients = new ArrayList<>();
    ArrayList<Visit> visitsOfDoctor;
    public static int DoctorId = 1;
    int doctorId;

    public Doctor(String name, String nationalID, String phone, String major, String levelOfEducation, String[] workDays,
                  ArrayList<Patient> relatedPatients) throws IOException {
        this.nationalID = nationalID;
        this.name = name;
        this.phone = phone;
        this.major = major;
        this.levelOfEducation = levelOfEducation;
        this.workDays = workDays;
        this.relatedPatients = relatedPatients;
        this.dateRegistered = new Date();
        doctorId = DoctorId;
        DoctorId++;
        System.out.println("Doctor added successfully!\n");
    }

    public ArrayList<Visit> getVisitsOfDoctor() {
        return visitsOfDoctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public void setWorkDays(String[] workDays) {
        this.workDays = workDays;
    }

    public void setRelatedPatients(ArrayList<Patient> relatedPatients) {
        this.relatedPatients = relatedPatients;
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

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public String[] getWorkDays() {
        return workDays;
    }

    public ArrayList<Patient> getRelatedPatients() {
        return relatedPatients;
    }

    public Visit getVisitPatientOfDoctorByNationalId(String ID) {
        ArrayList<Visit> visits = VisitManager.getVisits();
        for (Visit visit : visits) {
            if (Objects.equals(visit.getPatient().getNationalID(), ID) || Objects.equals(visit.getDoctor().nationalID, this.nationalID)) {
                return visit;
            }
        }
        return null;
    }

    public Patient getPatientOfDoctorByNationalId(String ID) {
        for (Patient patient : relatedPatients) {
            if (Objects.equals(patient.nationalID, ID)) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("\nDoctor,%s, %s, %s, %s, %s, %s,Registered at: %s;\n", this.name, this.nationalID, this.phone, this.major, this.levelOfEducation, Arrays.toString(this.workDays), this.dateRegistered);
    }
}
