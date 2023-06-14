package org.example.Manager.Personnel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements java.io.Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            VisitManager.ReadVisit();
            VisitManager.ReadManager();
            VisitManager.ReadDoctor();
            VisitManager.ReadEmployee();
            VisitManager.ReadNurse();
            VisitManager.ReadPatient();
            System.out.println("""
                    *********************** Welcome to Clinic ***********************
                    1. Log in
                    2. Sign up
                    3. Exit""");
            System.out.print(">");
            String choice0 = scanner.nextLine();
            switch (choice0) {
                case "1" -> Login();
                case "2" -> signUp();
                case "3" -> System.exit(0);
            }
        }
    }

    public static void Login() throws IOException {
        boolean b = true;
        while (b) {
            System.out.println("---------------------Login Manager---------------------\n0. back\nenter Username: ");
            Scanner scanner1 = new Scanner(System.in);
            String username = scanner1.nextLine();
            String password = null;
            if (!username.equals("0")) {
                System.out.println("enter password: ");
                password = scanner1.nextLine();
                if (!password.equals("0")) {
                    Manager manager = VisitManager.getManagerById(username, password);
                    if (manager != null) {
                        System.out.println(manager);
                        menu();
                        b=false;
                    } else
                        System.out.println("First you should Sign up!");
                }
            }
            if (username.equals("0") || password.equals("0")) {
                b = false;
            }
        }
    }

    public static void signUp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------New Manager--------------------------\n0. back");
        String username;
        String password;
        System.out.println("enter username:");
        String bool = scanner.nextLine();
        if (!bool.equals("0")) {
            username = bool;
            System.out.println("enter password:");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                password = bool;
                Manager manager = new Manager(username, password);
                VisitManager.save(manager);
            }
        }
    }

    ////////////////////////////////////////////////////
    public static Doctor loginDoctor() {
        boolean b = true;
        while (b) {
            System.out.println("---------------------Login doctor---------------------\n0. exit\nenter Doctor's nationalId: ");
            Scanner scanner1 = new Scanner(System.in);
            String nationalID = scanner1.nextLine();
            if (!nationalID.equals("0")) {
                Doctor doctorToString = VisitManager.getDoctorById(nationalID);
                if (doctorToString != null) {
                    return doctorToString;
                } else {
                    System.out.println("nationalId did not found!");
                }
            } else {
                b = false;
            }
        }
        return null;
    }

    public static Nurse loginNurse() {
        boolean b = true;
        while (b) {
            System.out.println("---------------------Login nurse---------------------\n0. exit\nenter Nurse's nationalId: ");
            Scanner scanner1 = new Scanner(System.in);
            String nationalID = scanner1.nextLine();
            if (!nationalID.equals("0")) {
                Nurse nurseToString = VisitManager.getNurseById(nationalID);
                if (nurseToString != null) {
                    return nurseToString;
                } else {
                    System.out.println("nationalId did not found!");
                }
            } else {
                b = false;
            }
        }
        return null;
    }

    public static Patient loginPatient() {
        boolean b = true;
        while (b) {
            System.out.println("---------------------Login patient---------------------\n0. exit\nenter patient's nationalId: ");
            Scanner scanner1 = new Scanner(System.in);
            String nationalID = scanner1.nextLine();
            if (!nationalID.equals("0")) {
                Patient patientToString = VisitManager.getPatientById(nationalID);
                if (patientToString != null) {
                    return patientToString;
                } else {
                    System.out.println("nationalId did not found!");
                }
            } else {
                b = false;
            }
        }
        return null;
    }

    public static Employee loginEmployee() {
        boolean b = true;
        while (b) {
            System.out.println("---------------------Login employee---------------------\n0. exit\nenter employee's nationalId: ");
            Scanner scanner1 = new Scanner(System.in);
            String nationalID = scanner1.nextLine();
            if (!nationalID.equals("0")) {
                Employee employeeToString = VisitManager.getEmployeeById(nationalID);
                if (employeeToString != null) {
                    return employeeToString;
                } else {
                    System.out.println("nationalId did not found!");
                }
            } else {
                b = false;
            }
        }
        return null;
    }

    /////////////////////////////////////
    public static void doctorMenu() {
        Doctor doctor = Main.loginDoctor();
        if (doctor != null) {
            Scanner scanner1 = new Scanner(System.in);
            boolean b1 = true;
            while (b1) {
                System.out.println("""
                        ******************************************
                        1. show doctor's information
                        2. show all patients of doctor
                        3. search patient of doctor by nationalId
                        4. visits of doctor
                        5. Exit""");
                System.out.print("DoctorMenu> ");
                String choice1 = scanner1.nextLine();
                //////////////////////////////////
                switch (choice1) {
                    case "1":
                        System.out.println(doctor);
                        break;
                    case "2":
                        System.out.println("\n--------------------------show doctors--------------------------\n");
                        System.out.println(doctor.getRelatedPatients());
                        break;
                    case "3":
                        System.out.println("\n-------------------search patient-------------------\n0.back\nenter patient's nationalId: ");
                        boolean b = true;
                        while (b) {
                            String nationalID = scanner1.nextLine();
                            if (!nationalID.equals("0")) {
                                Visit visit = doctor.getVisitPatientOfDoctorByNationalId(nationalID);
                                if (visit != null) {
                                    System.out.println(visit);
                                } else
                                    System.out.println("No visit found!");
                            } else {
                                b = false;
                            }
                        }
                        break;
                    case "4":
//                        System.out.println(doctor.getVisitsOfDoctor());
                        break;
                    case "5":
                        b1 = false;
                        break;
                }
            }
        }
    }

    public static void patientMenu() {
        Patient patient = Main.loginPatient();
        if (patient != null) {
            Scanner scanner1 = new Scanner(System.in);
            boolean b1 = true;
            while (b1) {
                System.out.println("""
                        ******************************************
                        1. show patient's information
                        2. show visit of patient
                        3. Exit""");
                System.out.print("PatientMenu> ");
                String choice1 = scanner1.nextLine();
                //////////////////////////////////
                switch (choice1) {
                    case "1" -> System.out.println(patient);
                    case "2" -> {
                        ArrayList<Visit> arrayList = VisitManager.ShowVisitOfPatient(patient);
                        if (!arrayList.isEmpty()) {
                            System.out.println(arrayList);
                        } else
                            System.out.println("\nPatient didn't visit!\n");
                    }
                    case "3" -> b1 = false;
                }
            }
        }
    }

    public static void employeeMenu() {
        Employee employee = Main.loginEmployee();
        if (employee != null) {
            Scanner scanner1 = new Scanner(System.in);
            boolean b1 = true;
            while (b1) {
                System.out.println("""
                        ******************************************
                        1. show employee's information
                        2. Exit""");
                System.out.print("EmployeeMenu> ");
                String choice1 = scanner1.nextLine();
                //////////////////////////////////
                switch (choice1) {
                    case "1":
                        System.out.println(employee);
                        break;
                    case "2":
                        b1 = false;
                        break;
                }
            }
        }
    }

    public static void nurseMenu() {
        Nurse nurse = Main.loginNurse();
        if (nurse != null) {
            Scanner scanner1 = new Scanner(System.in);
            boolean b1 = true;
            while (b1) {
                System.out.println("""
                        ******************************************  
                        1. show nurse's information
                        2. Exit""");
                System.out.print("NurseMenu> ");
                String choice1 = scanner1.nextLine();
                //////////////////////////////////
                switch (choice1) {
                    case "1":
                        System.out.println(nurse);
                        break;
                    case "2":
                        b1 = false;
                        break;
                }
            }
        }
    }

    public static void addDoctor() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------Add doctor--------------------------\n0. exit");
        String bool;
        String name = null;
        String nationalId = null;
        String phone = null;
        String major = null;
        String levelOfEducation = null;
        String workdays = null;
        System.out.println("enter name:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            name = bool;
            System.out.println("enter nationalId:");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                nationalId = bool;
                System.out.println("enter phone:");
                bool = scanner.nextLine();
                if (!bool.equals("0")) {
                    phone = bool;
                    System.out.println("enter major:");
                    bool = scanner.nextLine();
                    if (!bool.equals("0")) {
                        major = bool;
                        System.out.println("enter levelOfEducation:");
                        bool = scanner.nextLine();
                        if (!bool.equals("0")) {
                            levelOfEducation = bool;
                            System.out.println("enter workDays:(separate with comma,)");
                            workdays = scanner.nextLine();
                            String[] arrayList = workdays.split(",");
                            Doctor doctor = new Doctor(name, nationalId, phone, major, levelOfEducation, arrayList, null);
                            VisitManager.save(doctor);
                        }
                    }
                }
            }

        }
    }

    public static void deleteDoctor() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------delete doctor--------------------------\n0. exit");
        VisitManager.showDoctor();
        String bool;
        String nationalId = null;
        System.out.println("enter nationalId:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            nationalId = bool;
            Doctor doctor = VisitManager.getDoctorById(nationalId);
            if (doctor != null) {
                VisitManager.delete(doctor);
                System.out.println("Doctor deleted!");
            } else
                System.out.println("doctor didn't found!");
        }
    }

    public static void addPatient() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------Add patient--------------------------\n0. exit");
        String bool;
        String name = null;
        String nationalId = null;
        String phone = null;
        String disease = null;
        String illnessDescription = null;
        System.out.println("enter name:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            name = bool;
            System.out.println("enter nationalId:");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                nationalId = bool;
                System.out.println("enter phone:");
                bool = scanner.nextLine();
                if (!bool.equals("0")) {
                    phone = bool;
                    System.out.println("enter disease:");
                    bool = scanner.nextLine();
                    if (!bool.equals("0")) {
                        disease = bool;
                        System.out.println("enter illnessDescription:");
                        bool = scanner.nextLine();
                        if (!bool.equals("0")) {
                            illnessDescription = bool;
                            Patient patient = new Patient(name, nationalId, phone, disease, illnessDescription);
                            VisitManager.save(patient);
                        }
                    }
                }
            }

        }
    }

    public static void deletePatient() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------delete patient--------------------------\n0. exit");
        VisitManager.showPatient();
        String bool;
        String nationalId = null;
        System.out.println("enter nationalId:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            nationalId = bool;
            Patient patient = VisitManager.getPatientById(nationalId);
            if (patient != null) {
                VisitManager.delete(patient);
                System.out.println("Patient deleted!");
            } else
                System.out.println("patient didn't found!");
        }
    }

    public static void addEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------Add employee--------------------------\n0. exit");
        String bool;
        String name = null;
        String nationalId = null;
        String phone = null;
        String major = null;
        String workdays = null;
        System.out.println("enter name:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            name = bool;
            System.out.println("enter nationalId:");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                nationalId = bool;
                System.out.println("enter phone:");
                bool = scanner.nextLine();
                if (!bool.equals("0")) {
                    phone = bool;
                    System.out.println("enter major:");
                    bool = scanner.nextLine();
                    if (!bool.equals("0")) {
                        major = bool;
                        System.out.println("enter workdays:(separate with comma,)");
                        bool = scanner.nextLine();
                        workdays = bool;
                        String[] arraylist = workdays.split(",");
                        Employee employee = new Employee(name, nationalId, phone, major, arraylist);
                        VisitManager.save(employee);
                    }
                }
            }

        }
    }

    public static void deleteEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------delete employee--------------------------\n0. exit");
        VisitManager.showEmployee();
        String bool;
        String nationalId = null;
        System.out.println("enter nationalId:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            nationalId = bool;
            Employee employee = VisitManager.getEmployeeById(nationalId);
            if (employee != null) {
                VisitManager.delete(employee);
                System.out.println("Employee deleted!");
            } else
                System.out.println("employee didn't found!");
        }
    }

    public static void addNurse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------Add nurse--------------------------\n0. exit");
        String bool;
        String name = null;
        String nationalId = null;
        String phone = null;
        String major = null;
        String levelOfEducation = null;
        String workdays = null;
        System.out.println("enter name:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            name = bool;
            System.out.println("enter nationalId:");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                nationalId = bool;
                System.out.println("enter phone:");
                bool = scanner.nextLine();
                if (!bool.equals("0")) {
                    phone = bool;
                    System.out.println("enter major:");
                    bool = scanner.nextLine();
                    if (!bool.equals("0")) {
                        major = bool;
                        System.out.println("enter level of education: ");
                        bool = scanner.nextLine();
                        if (!bool.equals("0")) {
                            levelOfEducation = bool;
                            System.out.println("enter workdays:(separate with comma,)");
                            bool = scanner.nextLine();
                            workdays = bool;
                            String[] arraylist = workdays.split(",");
                            Nurse nurse = new Nurse(name, nationalId, phone, major, levelOfEducation, arraylist);
                            VisitManager.save(nurse);
                        }
                    }
                }
            }

        }
    }

    public static void deleteNurse() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------delete nurse--------------------------\n0. exit");
        VisitManager.showNurses();
        String bool;
        String nationalId = null;
        System.out.println("enter nationalId:");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            nationalId = bool;
            Nurse nurse = VisitManager.getNurseById(nationalId);
            if (nurse != null) {
                VisitManager.delete(nurse);
                System.out.println("Nurse deleted!");
            } else
                System.out.println("nurse didn't found!");
        }
    }

    public static void addVisit() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------Make a visit--------------------------\n0. exit");
        String bool;
        String doctorNationalId = null;
        String patientNationalId = null;
        String prescription = null;
        System.out.println("enter doctor's nationalId: ");
        bool = scanner.nextLine();
        if (!bool.equals("0")) {
            doctorNationalId = bool;
            System.out.println("enter patient's nationalId: ");
            bool = scanner.nextLine();
            if (!bool.equals("0")) {
                patientNationalId = bool;
                System.out.println("enter prescription: ");
                bool = scanner.nextLine();
                prescription = bool;
                Doctor doctor = VisitManager.getDoctorById(doctorNationalId);
                Patient patient = VisitManager.getPatientById(patientNationalId);
                if (doctor != null && patient != null) {
                    VisitManager.visitDoctor(patient, doctor, prescription);
                } else
                    System.out.println("doctor or patient didn't found!");
            }
        }
    }

    public static void menu() throws IOException {
        boolean b0 = true;
        while (b0) {
            System.out.println("""
                    ******************* menu *******************
                    1. doctor
                    2. patient
                    3. employee
                    4. nurse
                    5. visit Patient
                    6. Log out""");
            System.out.print("menu> ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            ////////////////////////////////////////
            switch (choice) {
                case "1" -> {
                    boolean b = true;
                    while (b) {
                        System.out.println("""
                                *********************** Doctor menu ***********************\s
                                1. Log in\s
                                2. add doctor
                                3. delete doctor
                                4. back""");
                        System.out.print(">");
                        String choice0 = scanner.nextLine();
                        switch (choice0) {
                            case "1" -> doctorMenu();
                            case "2" -> addDoctor();
                            case "3" -> deleteDoctor();
                            case "4" -> b = false;
                        }
                    }
                }
                case "2" -> {
                    boolean b = true;
                    while (b) {
                        System.out.println("""
                                *********************** Patient menu ***********************\s
                                1. Log in\s
                                2. add Patient
                                3. delete Patient
                                4. back""");
                        System.out.print(">");
                        String choice0 = scanner.nextLine();
                        switch (choice0) {
                            case "1" -> patientMenu();
                            case "2" -> addPatient();
                            case "3" -> deletePatient();
                            case "4" -> b = false;
                        }
                    }
                }
                case "3" -> {
                    boolean b = true;
                    while (b) {
                        System.out.println("""
                                *********************** Employee menu ***********************\s
                                1. Log in\s
                                2. add employee
                                3. delete employee
                                4. back""");
                        System.out.print(">");
                        String choice0 = scanner.nextLine();
                        switch (choice0) {
                            case "1" -> employeeMenu();
                            case "2" -> addEmployee();
                            case "3" -> deleteEmployee();
                            case "4" -> b = false;
                        }
                    }
                }
                case "4" -> {
                    boolean b = true;
                    while (b) {
                        System.out.println("""
                                *********************** Nurse menu ***********************\s
                                1. Log in\s
                                2. add nurse
                                3. delete nurse
                                4. back""");
                        System.out.print(">");
                        String choice0 = scanner.nextLine();
                        switch (choice0) {
                            case "1" -> nurseMenu();
                            case "2" -> addNurse();
                            case "3" -> deleteNurse();
                            case "4" -> b = false;
                        }
                    }
                }
                case "5" -> {
                    boolean b = true;
                    while (b) {
                        System.out.println("""
                                *********************** Visit menu ***********************\s
                                1. make a visit\s
                                2. show visits
                                3. back""");
                        System.out.print(">");
                        String choice0 = scanner.nextLine();
                        switch (choice0) {
                            case "1" -> addVisit();
                            case "2" -> VisitManager.showVisits();
                            case "3" -> b = false;
                        }
                    }
                }
                case "6" -> b0 = false;
            }
        }
    }
}
