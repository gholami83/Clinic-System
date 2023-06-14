package org.example.Manager.Personnel;

import org.example.Manager.Personnel.Doctor;
import org.example.Manager.Personnel.Patient;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {
     Patient patient;
     Doctor doctor;
     String prescription;
     Date dateAppointment;
    public static int VisitId = 1;
    int visitId;

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getPrescription() {
        return prescription;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public Visit(Patient patient, Doctor doctor, String prescription) {
        this.patient = patient;
        this.doctor = doctor;
        this.prescription = prescription;
        dateAppointment = new Date();
        visitId = VisitId;
        VisitId++;
    }

    @Override
    public String toString() {
        return String.format("\nVisit,%s,%s,%s,registered at:%s\n", doctor.toString(), patient.toString(), prescription, dateAppointment);
    }
}
