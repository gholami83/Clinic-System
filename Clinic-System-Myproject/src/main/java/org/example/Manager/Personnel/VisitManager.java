package org.example.Manager.Personnel;

import org.example.Manager.Personnel.Doctor;
import org.example.Manager.Personnel.Employee;
import org.example.Manager.Personnel.Nurse;
import org.example.Manager.Personnel.Patient;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VisitManager implements Serializable {
    private static final String doctorPath = "src/test/Doctor.txt";
    private static final String patientPath = "src/test/Patient.txt";
    private static final String nursePath = "src/test/Nurse.txt";
    private static final String employerPath = "src/test/Employee.txt";
    private static final String visitPath = "src/test/Visit.txt";
    private static final String managerPath = "src/test/Manager.txt";

    static ArrayList<Visit> visits = new ArrayList<>();
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Nurse> nurses = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Manager> managers = new ArrayList<>();

    public VisitManager() {
    }

    public static Doctor getDoctorById(String nationalID) {
        Doctor doctor = null;
        for (Doctor doctor1 : doctors) {
            if (Objects.equals(doctor1.nationalID, nationalID)) {
                doctor = doctor1;
                break;
            }
        }
        return doctor;
    }

    public static Employee getEmployeeById(String nationalID) {
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (Objects.equals(employee1.nationalID, nationalID)) {
                employee = employee1;
                break;
            }
        }
        return employee;
    }

    public static Manager getManagerById(String username, String password) {
        Manager manager = null;
        for (Manager manager1 : managers) {
            if (Objects.equals(manager1.getUsername(), username) && Objects.equals(manager1.getPassword(), password)) {
                return manager1;
            }
        }
        return null;
    }

    public static Patient getPatientById(String nationalID) {
        Patient patient = null;
        for (Patient patient1 : patients) {
            if (Objects.equals(patient1.nationalID, nationalID)) {
                patient = patient1;
                break;
            }
        }
        return patient;
    }

    public static Nurse getNurseById(String nationalID) {
        Nurse nurse = null;
        for (Nurse nurse1 : nurses) {
            if (Objects.equals(nurse1.nationalID, nationalID)) {
                nurse = nurse1;
                break;
            }
        }
        return nurse;
    }

    public static ArrayList<Visit> getDoctorVisitById(String doctorNationalID) {
        ArrayList<Visit> visit = null;
        for (Visit visit1 : visits) {
            if (Objects.equals(visit1.getDoctor().nationalID, doctorNationalID)) {
                visit.add(visit1);
                break;
            }
        }
        return visit;
    }

    public static void showManager() {
        for (Manager manager : managers)
            System.out.println(manager);

    }

    public static void showDoctor() {
        try {
            if (!doctors.isEmpty()) {
                for (Doctor doctor : doctors)
                    System.out.println(doctor);
            } else
                System.out.println("\nDoctor didn't added\n");
        }
        catch (Exception e){
        }
    }

    public static void showEmployee() {
        try {
            if (!employees.isEmpty()) {
                for (Employee e : employees)
                    System.out.println(e);
            } else
                System.out.println("\nEmployee didn't added\n");
        }
        catch (Exception e){
        }
    }

    public static void showPatient() {
        try {
            if (!patients.isEmpty()) {
                for (Patient patient : patients)
                    System.out.println(patient);
            } else
                System.out.println("\nPatient didn't added\n");
        }
        catch (Exception e){
        }
    }

    public static void showNurses() {
        try {
            if (!nurses.isEmpty()) {
                for (Nurse nurse : nurses)
                    System.out.println(nurse);
            } else
                System.out.println("\nNurse didn't added\n");
        }
        catch (Exception e){
        }
    }

    public static void showVisits() {
        try {
            if (!visits.isEmpty()) {
                for (Visit visit : visits)
                    System.out.println(visit);
            } else
                System.out.println("\nVisit didn't added\n");
        }
        catch (Exception e){
        }
    }

    public static void WriteManager() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(managerPath, true);
            ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
            for (Manager manager : managers) {
                fileWriter.writeObject(manager);
            }
            fileWriter.close();
        } catch (NotSerializableException e) {

        }
    }

    public static void ReadManager() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(managerPath));
            while (true) {
                Manager manager = (Manager) objectInputStream.readObject();
                managers.add(manager);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } catch (StreamCorruptedException e) {
        } finally {
            if (managers.size() != 0) {
                int n = managers.size() - 1;
                Manager.ManagerId = managers.get(n).managerId + 1;
            }
        }
    }

    public static void WriteDoctor() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(doctorPath, true);
        ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
        for (Doctor doctor : doctors) {
            fileWriter.writeObject(doctor);
        }
        fileWriter.close();
    }

    public static void ReadDoctor() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(doctorPath));
            while (true) {
                Doctor doctor = (Doctor) objectInputStream.readObject();
                doctors.add(doctor);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } finally {
            if (doctors.size() != 0) {
                int n = doctors.size() - 1;
                Doctor.DoctorId = doctors.get(n).doctorId + 1;
            }
        }
    }

    public static void WritePatient() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(patientPath, true);
        ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
        for (Patient patient : patients) {
            fileWriter.writeObject(patient);
        }
        fileWriter.close();
    }

    public static void ReadPatient() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(patientPath));
            while (true) {
                Patient patient = (Patient) objectInputStream.readObject();
                patients.add(patient);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } finally {
            if (patients.size() != 0) {
                int n = patients.size() - 1;
                Patient.PatientId = patients.get(n).patientID + 1;
            }
        }
    }

    public static void WriteEmployee() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(employerPath, true);
        ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
        for (Employee employee : employees) {
            fileWriter.writeObject(employee);
        }
        fileWriter.close();
    }

    public static void ReadEmployee() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(employerPath));
            while (true) {
                Employee employee = (Employee) objectInputStream.readObject();
                employees.add(employee);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } finally {
            if (employees.size() != 0) {
                int n = employees.size() - 1;
                Employee.EmployeeId = employees.get(n).employeeId + 1;
            }
        }
    }

    public static void WriteNurse() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nursePath, true);
        ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
        for (Nurse nurse : nurses) {
            fileWriter.writeObject(nurse);
        }
        fileWriter.close();
    }

    public static void ReadNurse() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nursePath));
            while (true) {
                Nurse nurse = (Nurse) objectInputStream.readObject();
                nurses.add(nurse);
            }
        } catch (EOFException e) {
            System.out.println("end of File");
        } finally {
            if (nurses.size() != 0) {
                int n = nurses.size() - 1;
                Nurse.NurseId = nurses.get(n).nurseId + 1;
            }
        }
    }

    public static void WriteVisit() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(visitPath, true);
        ObjectOutputStream fileWriter = new ObjectOutputStream(fileOutputStream);
        for (Visit visit : visits) {
            fileWriter.writeObject(visit);
        }
        fileWriter.close();
    }

    public static void ReadVisit() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(visitPath));
            while (true) {
                Visit visit = (Visit) objectInputStream.readObject();
                visits.add(visit);
            }
        } catch (Exception e) {
            System.out.println("end of File");
        } finally {
            if (visits.size() != 0) {
                int n = visits.size() - 1;
                Visit.VisitId = visits.get(n).visitId + 1;
            }
        }
    }

    public static void save(Manager manager) throws IOException {
        managers.add(manager);
        WriteManager();
    }

    public static void save(Doctor doctor) throws IOException {
        doctors.add(doctor);
        WriteDoctor();
    }

    public static void save(Nurse nurse) throws IOException {
        nurses.add(nurse);
        WriteNurse();
    }

    public static void save(Employee employee) throws IOException {
        employees.add(employee);
        WriteEmployee();
    }

    public static void save(Patient patient) throws IOException {
        patients.add(patient);
        WritePatient();
    }

    public static void save(Visit visit) throws IOException {
        visits.add(visit);
        WriteVisit();
    }

    public static void delete(Doctor doctor) throws IOException {
        doctors.remove(doctor);
        WriteDoctor();
    }

    public static void delete(Nurse nurse) throws IOException {
        nurses.remove(nurse);
        WriteNurse();
    }

    public static void delete(Employee employee) throws IOException {
        employees.remove(employee);
        WriteEmployee();
    }

    public static void delete(Patient patient) throws IOException {
        patients.remove(patient);
        WritePatient();
    }


    public static void visitDoctor(Patient patient, Doctor doctor, String prescription) throws IOException {
        try {
            Visit visit = new Visit(patient, doctor, prescription);
            save(visit);
            doctor.relatedPatients.add(patient);
        }
        catch (Exception e){
        }
    }

    public static ArrayList<Visit> ShowVisitOfPatient(Patient patient) {
        try {
            ArrayList<Visit> visits1 = new ArrayList<>();
            for (Visit visit : visits) {
                if (visit.getPatient().equals(patient)) {
                    visits1.add(visit);
                }
            }
            return visits1;
        }
        catch (Exception e){
            System.out.println("Patient didn't visit!");
        }
        return null;
    }

    public static ArrayList<Visit> getVisits() {
        return getVisits();
    }
}
