package UserManagment;

import AppointmentScheduling.Appointment;
import AppointmentScheduling.AppointmentManager;
import ChatVedioConsultation.ChatClient;
import ChatVedioConsultation.ChatServer;
import ChatVedioConsultation.VideoCall;
import DoctorPatientInteraction.Feedback;
import DoctorPatientInteraction.MedicalHistory;
import DoctorPatientInteraction.Prescription;
import EmergencyAlert.EmergencyAlert;
import HealthDataHandling.VitalSign;
import HealthDataHandling.VitalsDatabase;
import NotificationReminder.EmailSender;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends User implements ChatClient {

    //constructor
    Instant timestamp ;
    public Patient(String name , String id , String email ){
        //initializing parent class attributes
        super(name, id , email);
         timestamp = Instant.now();
    }
    Scanner scanner = new Scanner(System.in);
    public String display(){
        return super.display();
    }
    //getter method
    @Override
    public String getId() {
        return super.getId();
    }
    public void uploadVitals(VitalsDatabase vitalsDatabase){
        System.out.print("Enter your oxygen level: ");
        int oxygenLevel = scanner.nextInt();

        System.out.print("Enter your heart rate: ");
        int heartRate = scanner.nextInt();
        //scanner.next();
        System.out.print("Enter your temperature: ");
        double temp = scanner.nextDouble();

        scanner.nextLine(); // Consume newline before reading blood pressure
        System.out.print("Enter your systolic blood pressure: ");
        int systolic = scanner.nextInt();

        System.out.print("Enter your diastolic blood pressure: ");
        int diastolic = scanner.nextInt();
        String bloodPressure = String.format("%03d/%03d", systolic, diastolic);
        System.out.println("checking yo upload");
        VitalSign vitalSign = new VitalSign(oxygenLevel, heartRate, temp, this.getId(),systolic,diastolic);
        vitalsDatabase.addVitalSign(vitalSign);


        System.out.println("Vital sign uploaded successfully!");
    }
    public void viewMyVitalData(VitalsDatabase vitalsDatabase){
        for(VitalSign vitalSign : vitalsDatabase.getVitalDatabase()){
            if(vitalSign.getPatientId().equals(this.getId())){
                System.out.println(vitalSign.detail());
            }
        }
    }
//    public void viewMyAppointments(AppointmentManager appointmentManager){
//        for (Appointment appointment : appointmentManager.getAppointmentsByPatient(this.getId() ) ) {}
//    }
//    @Override
//    public void chatMessage(String receiver, String chat) {
//        timestamp = Instant.now();
//        ChatServer.getInstance().addChat(this.getName(), receiver, chat, timestamp);
//    }
    @Override
    public void chatMessage(String receiver, String message) {
    Instant timestamp = Instant.now();
    ChatServer.getInstance().addChat(this.getId(), receiver, message, timestamp);
    }
    public void viewMyChats() {
        ChatServer.getInstance().showChatsForUser(this.getId());
    }
    public void sendVideoLink(String email, String url,Administrator admin) {
        VideoCall.sendVideoCallLink(email, url,admin);
    }
    public void viewFeedback( String doctorId,MedicalHistory feedbacks){

        System.out.println("check feedback");
        System.out.println(feedbacks.getFeedbacks());

        for(Feedback feedback : feedbacks.getFeedbacks()){
            System.out.println("searcing");
        if(feedback.getPatientId().equals(this.getId()) && feedback.getDoctorId().equals(doctorId)){
            System.out.println(feedback.detail());
        }
        else{
            System.out.println("No feedback available for this doctor");
        }
        }
        System.out.println("not found");
        System.out.println("sw");
    }
    public void viewPrescription( String doctorId,MedicalHistory prescriptions){

        for(Prescription prescription : prescriptions.getPrescriptions()){
        if(prescription.getPatientId().equals(this.getId()) && prescription.getDoctorId().equals(doctorId)){
            System.out.println(prescription.detail());
        }
        }
    }
    public void requestAppointment(Administrator doctors, AppointmentManager appointments) {
        // Display all doctors
        for (Doctor doctor : doctors.getDoctors()) {
            System.out.println("Doctor Name: " + doctor.getName());
            System.out.println("Doctor ID: " + doctor.getId());
        }

        System.out.print("Enter Doctor ID: ");
        String selectedDoctorId = scanner.nextLine();

        // Find the selected doctor and get email
        String doctorEmail = null;
        for (Doctor doctor : doctors.getDoctors()) {
            if (doctor.getId().equals(selectedDoctorId)) {
                doctorEmail = doctor.getEmail();
                break;
            }
        }

        if (doctorEmail == null) {
            System.out.println("Invalid Doctor ID. Appointment not created.");
            return;
        }

        // Get appointment date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();

        try {
            LocalDateTime dateTime = LocalDateTime.parse(input, formatter);

            // Create appointment
            Appointment appointment = new Appointment(this.getId(), selectedDoctorId, dateTime);
            appointments.addAppointment(appointment);

            // Email notifications
            EmailSender.sendEmail(this.getEmail(), "Appointment Request",
                    "Your appointment request has been sent to the doctor.");
            System.out.println("Mail send to the user..");
            EmailSender.sendEmail(doctorEmail, "New Appointment",
                    "You have a new appointment request from patient ID: " + this.getId());
            System.out.println("Mail send to the doctor..");

            System.out.println("Appointment request sent and emails delivered.");
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm");
        }
    }

    //
//    public void requestAppointment(Administrator doctors, AppointmentManager appointments){
//
//        String doctorMail ="";
//        //displaying all the doctors to the user
//        for(Doctor doctor : doctors.getDoctors()){
//            System.out.println("Doctor name : "+doctor.getName());
//            System.out.println("Doctor Id: "+doctor.getId());
//            doctorMail = doctor.getEmail();
//        }
//
//        System.out.println("Enter doctor Id: ");
//        String id = scanner.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
//        String input = scanner.nextLine();
//        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
//
//
//        Appointment appointment = new Appointment(this.getId(),id ,dateTime);
//        appointments.addAppointment(appointment);
//        EmailSender.sendEmail(this.getEmail(),"Appointment Request", "Your appointment request has been sent to the doctor. Please check your email for confirmation.");
//        System.out.println("Mail send to the user..");
//
//        EmailSender.sendEmail(doctorMail,"New Appointment","Confirm the appointent");
//
//
//
//
//
//
//
//    }
//
    public void getAppointments(AppointmentManager appointments){
        for(Appointment appointment : appointments.getAppointmentsByPatient(this.getId())){
            System.out.println(appointment.detail());
        }
    }
}
