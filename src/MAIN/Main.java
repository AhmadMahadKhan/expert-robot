package MAIN; ////package MAIN;
////
////import Logins.LoginManager;
////import UserManagment.Administrator;
////import UserManagment.Doctor;
////import UserManagment.Patient;
////import UserManagment.User;
////
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Scanner;
////
////public class Main {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        User user ;
////        System.out.println("1.login ");
////        System.out.println("2.sign up");
////        System.out.println("3.exit ");
////        int choice = scanner.nextInt();
////        scanner.next();
////        switch (choice){
////            case 1:
////                System.out.println("Enter you id: ");
////                String email = scanner.next();
////                System.out.print("Enter your password: ");
////                String password = scanner.nextLine();
////                LoginManager.login();
////                break;
////        }
////
////
////        try {
////            // Create the one and only Administrator
////            Administrator admin = Administrator.getInstance("Admin Ali", "A001", "admin@hospital.com");
////            // Try to create a second admin (this will throw an exception)
////           // Administrator anotherAdmin = Administrator.getInstance("Fake Admin", "A002", "another@hospital.com");
////
////            admin.addDoctor("doc1","doc1","doc1@gmail.com");
////            admin.addDoctor("doc2","doc2","doc2@gmail.com");
////            admin.addDoctor("doc3","doc3","doc3@gmail.com");
////            admin.addDoctor("doc4","doc4","doc4@gmail.com");
////            admin.addDoctor("doc5","doc5","doc5gmail.com");
////            admin.addPatient("p1","p1","p1@gmail.com");
////            admin.addPatient("p2","p2","p1@gmail.com");
////            admin.addPatient("p3","p3","p1@gmail.com");
////            admin.addPatient("p4","p4","p1@gmail.com");
////            admin.addPatient("p5","p5","p1@gmail.com");
////            admin.getDoctors();
////
////            ArrayList<User> users = new ArrayList<>();
////            for (Doctor doc : admin.getDoctors()) {
////                users.add(doc); // this works because Doctor is a User
////            }
////            for (User u : users) {
////                System.out.println(u.getName());
////                System.out.println(u.getId());
////            }
////            System.out.println("the number of doc is: "+users.toArray().length);
////            users.clear();
////
////            admin.getPatients();
////            for (Patient pat : admin.getPatients()) {
////                users.add(pat); // this works because Doctor is a User
////            }
////            for (User u : users) {
////                System.out.println(u.getName());
////                System.out.println(u.getId());
////            }
////            System.out.println("the number of patients is: "+users.toArray().length);
////        } catch (RuntimeException e) {
////            System.out.println("Exception: " + e.getMessage());
////        }
////
////
////
////    }
////}
//package MAIN;
//
//import AppointmentScheduling.Appointment;
//import AppointmentScheduling.AppointmentManager;
//import ChatVedioConsultation.ChatMessage;
//import ChatVedioConsultation.ChatServer;
//import DoctorPatientInteraction.MedicalHistory;
//import EmergencyAlert.EmergencyAlert;
//import EmergencyAlert.PanicButton;
//import HealthDataHandling.VitalSign;
//import HealthDataHandling.VitalsDatabase;
//import Logins.LoginManager;
//import UserManagment.Administrator;
//import UserManagment.Doctor;
//import UserManagment.Patient;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            // Initialize Administrator and data
//            Administrator admin = Administrator.getInstance("Admin Ali", "A001", "admin@hospital.com");
//
//            // Add Doctors
//            admin.addDoctor("Dr. Smith", "D001", "smith@hospital.com");
//            admin.addDoctor("Dr. John", "D002", "john@hospital.com");
//
//            Doctor doctor = new Doctor("Dr. Smith", "D001", "smith@hospital.com");
//            // Add Patients
//            admin.addPatient("Alice", "P001", "alice@hospital.com");
//            admin.addPatient("Bob", "P002", "bob@hospital.com");
//
//           Patient patient1 = new Patient("Alice", "P001", "alice@hospital.com");
//           Patient patient2= new Patient("Alice", "P002", "alice@hospital.com");
//            ChatServer server = new ChatServer();
//            System.out.println("chats");
//            server.showAllChats();
//            System.out.println("chatting");
//           patient1.chatMessage("D001","hello i am getting hory");
//           patient2.chatMessage("D001","hhw");
//           patient1.chatMessage("D001","heldasasdfadfaslo i am getting hory");
//
//            System.out.println("patient1===");
//            patient1.viewMyChats();
//            System.out.println("=======patient2");
//            patient2.viewMyChats();
//            patient1.sendVideoLink("P002","asd",admin);
//
//
////            System.out.println("creating object ofvitaldatabase");
////            VitalsDatabase vitalsDatabase = new VitalsDatabase();
////            System.out.println("created object ofvitaldatabase");
////            System.out.println("creating object appointmentmanager");
////            AppointmentManager manager = new AppointmentManager();
////            System.out.println("created object appointmentmanager");
//////            patient1.requestAppointment(admin.getDoctors(), manager.getAppointments());
////            System.out.println("enter app data");
////            patient1.requestAppointment(admin, manager);
////            System.out.println("app data entered");
////            System.out.println("doctor viewing appointment");
////            doctor.ViewAllAppointments(manager);
////            EmergencyAlert emergencyAlert = new EmergencyAlert();
////            emergencyAlert.Alert(vitalsDatabase.getVitalDatabase(),manager,admin);
////            ArrayList<String> relatedDoctorEmails = new ArrayList<>();
////            for (Appointment appt : manager.getAppointmentsByPatient("P001")) {
////                String doctorId = appt.getDoctorId();
////                for (Doctor doc : admin.getDoctors()) {
////                    if (doc.getId().equals(doctorId)) {
////                        relatedDoctorEmails.add(doc.getEmail());
////                    }
////                }
////            }
//
//            // Simulate panic press
////            PanicButton panicButton = new PanicButton("P001", relatedDoctorEmails);
////            panicButton.press();
//         //   System.out.println("settinh appointment");
////
////            doctor.SetAppointment("P001",true,manager);
////            System.out.println("view appointment");
////            System.out.println("check===");
////            patient1.getAppointments(manager);
//            // patient1.requestAppointment(admin, manager);
//
////            MedicalHistory feedbacks =new MedicalHistory();
////            MedicalHistory prescriptions =new MedicalHistory();
////            System.out.println("==feedback");
////            doctor.uploadFeedback(feedbacks);
////           // doctor.uploadFeedback(prescriptions);
////            System.out.println("precriptiosad====");
////            doctor.uploadPrescription(prescriptions);
////            patient1.viewFeedback("D001",feedbacks);
////            patient2.viewFeedback("D001",feedbacks);
////            patient2.viewPrescription("D001",prescriptions);
////            patient1.viewPrescription("D001",prescriptions);
//
//            // Setup login manager
////            LoginManager loginManager = new LoginManager();
////            loginManager.loadUsersFromAdmin(admin);
////
////            // Menu Loop
////            boolean running = true;
////            while (running) {
////                System.out.println("\n=== Hospital Management System ===");
////                System.out.println("1. Sign up");
////                System.out.println("2. Log in");
////                System.out.println("3. List All Users (debug)");
////                System.out.println("4. Exit");
////                System.out.print("Choose an option: ");
////                String choice = scanner.nextLine();
////
////                switch (choice) {
////                    case "1":
////                        loginManager.signup();
////                        break;
////                    case "2":
////                        loginManager.login();
////                        break;
////                    case "3":
////                        loginManager.listAllUsers();
////                        break;
////                    case "4":
////                        System.out.println("Goodbye!");
////                        running = false;
////                        break;
////                    default:
////                        System.out.println("Invalid option.");
///                }
////
////            }
//
//        } catch (RuntimeException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
//    }
//}
import Logins.LoginManager;
import SystemResources.ResourceManager;
import UserManagment.Administrator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming ResourceManager.admin is already initialized as a Singleton
        Administrator admin = new Administrator("name","id","email");
        Administrator.setInstance(admin);

        // Initialize LoginManager and load users from admin
        LoginManager loginManager = new LoginManager();


        // Simple main loop
        while (true) {
            loginManager.loadUsersFromAdmin(admin);
            System.out.println("\n=== Remote Patient Monitoring System ===");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            //  int choice = Integer.parseInt(scanner.nextLine());

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        loginManager.signup();
                        break;
                    case 2:
                        loginManager.login();
                        break;
                    case 3:
                        System.out.println("Exiting system. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
            }

        }
    }
}
