package RoleMenus;

import AppointmentScheduling.AppointmentManager;
import DoctorPatientInteraction.MedicalHistory;
import EmergencyAlert.EmergencyAlert;
import HealthDataHandling.VitalSign;
import HealthDataHandling.VitalsDatabase;
import UserManagment.Administrator;
import UserManagment.Doctor;
import UserManagment.Patient;

import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private static Scanner scanner = new Scanner(System.in);


    public static void handleDoctorMenu(Doctor doctor,
                                        VitalsDatabase vitalsDatabase,
                                        MedicalHistory medicalHistory,
                                        AppointmentManager appointmentManager,
                                        Administrator admin) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Doctor Menu ---");
            System.out.println("1. View Patient Vital Data");
            System.out.println("2. Upload Feedback");
            System.out.println("3. Upload Prescription");
            System.out.println("4. View My Appointments");
            System.out.println("5. Set Appointment Decision");
            System.out.println("6. Send Chat Message");
            System.out.println("7. Send Video Call Link");
            System.out.println("8. Logout");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Patient ID: ");
                    String patientId1 = scanner.nextLine();
                    doctor.getPatientVitalData(patientId1, vitalsDatabase);
                    break;

                case "2":
                    doctor.uploadFeedback(medicalHistory);
                    break;

                case "3":
                    doctor.uploadPrescription(medicalHistory);
                    break;

                case "4":
                    doctor.ViewAllAppointments(appointmentManager);
                    break;

                case "5":
                    System.out.print("Enter Patient ID: ");
                    String patientId2 = scanner.nextLine();
                    System.out.print("Enter decision (true = accept, false = reject): ");
                    boolean status = Boolean.parseBoolean(scanner.nextLine());
                    doctor.SetAppointment(patientId2, status, appointmentManager);
                    break;

                case "6":
                    System.out.print("Enter Receiver ID: ");
                    String receiverId = scanner.nextLine();
                    System.out.print("Enter Message: ");
                    String message = scanner.nextLine();
                    doctor.chatMessage(receiverId, message);
                    break;

                case "7":
                    System.out.print("Enter Patient Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Video Call URL: ");
                    String url = scanner.nextLine();
                    doctor.sendVideoLink(email, url, admin);
                    break;

                case "8":
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static void handlePatientMenu(Patient patient,
                                         VitalsDatabase vitalsDatabase,
                                         MedicalHistory medicalHistory,
                                         Administrator admin,
                                         AppointmentManager appointmentManager) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Patient Menu ---");
            System.out.println("1. Upload Vitals");
            System.out.println("2. View Doctor Feedback");
            System.out.println("3. View Prescriptions");
            System.out.println("4. Request Appointment");
            System.out.println("5. View My Appointments");
            System.out.println("6. Send Chat Message");
            System.out.println("7. View My Chats");
            System.out.println("8. Send Video Call Link");
            System.out.println("9. Logout");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    patient.uploadVitals(vitalsDatabase);
                    System.out.println("testing vitals");

                    List<VitalSign> vitals = vitalsDatabase.getVitalDatabase();
                    VitalSign vital ;
                    for(VitalSign vitalSign : vitals){
                        vital = vitalSign.getPatientId().equals(patient.getId()) ? vitalSign : null;
                    }
                    EmergencyAlert.alert(vitals, appointmentManager, admin);


                    break;

                case "2":
                    System.out.print("Enter Doctor ID: ");
                    String docId1 = scanner.nextLine();
                    patient.viewFeedback(docId1, medicalHistory);
                    break;

                case "3":
                    System.out.print("Enter Doctor ID: ");
                    String docId2 = scanner.nextLine();
                    patient.viewPrescription(docId2, medicalHistory);
                    break;

                case "4":
                    patient.requestAppointment(admin, appointmentManager);
                    break;

                case "5":
                    patient.getAppointments(appointmentManager);
                    break;

                case "6":
                    System.out.print("Enter Receiver ID: ");
                    String receiverId = scanner.nextLine();
                    System.out.print("Enter Message: ");
                    String message = scanner.nextLine();
                    patient.chatMessage(receiverId, message);
                    break;

                case "7":
                    patient.viewMyChats();
                    break;

                case "8":
                    System.out.print("Enter Recipient Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Video Call URL: ");
                    String url = scanner.nextLine();
                    patient.sendVideoLink(email, url, admin);
                    break;

                    case "9":
                        System.out.println("View My Vital Data");
                        patient.viewMyVitalData(vitalsDatabase);
                case "10":
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static void handleAdminMenu(Administrator admin) {
        while (true) {
            System.out.println("\n=== Administrator Menu ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Remove Patient");
            System.out.println("4. Remove Doctor");
            System.out.println("5. View All Patients");
            System.out.println("6. View All Doctors");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String pId = scanner.nextLine();
                    System.out.print("Enter Patient Email: ");
                    String pEmail = scanner.nextLine();
                    admin.addPatient(pName, pId, pEmail);
                    break;

                case "2":
                    System.out.print("Enter Doctor Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    String dId = scanner.nextLine();
                    System.out.print("Enter Doctor Email: ");
                    String dEmail = scanner.nextLine();
                    admin.addDoctor(dName, dId, dEmail);
                    break;

                case "3":
                    System.out.print("Enter Patient Name to Remove: ");
                    String rpName = scanner.nextLine();
                    System.out.print("Enter Patient ID to Remove: ");
                    String rpId = scanner.nextLine();
                    admin.removePatient(rpName, rpId);
                    System.out.println("Patient removed (if exists).");
                    break;

                case "4":
                    System.out.print("Enter Doctor Name to Remove: ");
                    String rdName = scanner.nextLine();
                    System.out.print("Enter Doctor ID to Remove: ");
                    String rdId = scanner.nextLine();
                    admin.removeDoctor(rdName, rdId);
                    System.out.println("Doctor removed (if exists).");
                    break;

                case "5":
                    System.out.println("All Patients:");
                    for (Patient p : admin.getPatients()) {
                        System.out.println(p.getName() + " | ID: " + p.getId() + " | Email: " + p.getEmail());
                    }
                    break;

                case "6":
                    System.out.println("All Doctors:");
                    for (Doctor d : admin.getDoctors()) {
                        System.out.println(d.getName() + " | ID: " + d.getId() + " | Email: " + d.getEmail());
                    }
                    break;

                case "7":
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
