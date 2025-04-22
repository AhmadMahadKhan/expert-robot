package UserManagment;

import AppointmentScheduling.Appointment;
import AppointmentScheduling.AppointmentManager;
import ChatVedioConsultation.ChatClient;
import ChatVedioConsultation.ChatServer;
import ChatVedioConsultation.VideoCall;
import DoctorPatientInteraction.Feedback;
import DoctorPatientInteraction.MedicalHistory;
import DoctorPatientInteraction.Prescription;
import HealthDataHandling.VitalSign;
import HealthDataHandling.VitalsDatabase;

import java.time.Instant;
import java.util.Scanner;

public class Doctor extends User implements ChatClient {

    //constructor
    Instant timestamp ;
    public Doctor(String name , String id , String email ){
        //initializing parent class attributes
        super(name, id , email);
        timestamp = Instant.now();
      //  Instant timestamp = Instant.now();
    }


    @Override
    public String display(){
        return super.display();
    }
    public void getPatientVitalData(String patientId, VitalsDatabase vitalDatabase) {

        for(VitalSign vitalSign : vitalDatabase.getVitalDatabase()){
           if( vitalSign.getPatientId().equals(patientId)){
               System.out.println(vitalSign.detail());
           }
        }
    }
    Scanner scanner = new Scanner(System.in);
    public void uploadFeedback(MedicalHistory feedbacks){
        System.out.println("Enter patient Id: ");
        String id = scanner.nextLine();
       // scanner.next();
        System.out.println("Feedback: ");
        String responce = scanner.nextLine();
        Feedback feedback = new Feedback(this.getId(),id  , responce);
        feedbacks.addFeedback(feedback);
        System.out.println("Feedback uploaded");
    }
    public void uploadPrescription(MedicalHistory prescriptions){
        System.out.println("Enter patient Id : ");
        String id = scanner.nextLine();
        System.out.println("Enter name of medicine : ");
        String medicine = scanner.next();
        System.out.println("Enter the dosage of medicine:");
        String dosage = scanner.next();
        System.out.println("Enter the schedule to take medicine: ");
        String schedule = scanner.next();
        Prescription prescription = new Prescription(medicine,dosage,schedule,id,this.getId());
       prescriptions.addPrescription(prescription);
        System.out.println("Prescription uploaded");
    }
    public void ViewAllAppointments( AppointmentManager appointmentManager){
        for (Appointment appointment : appointmentManager.getAppointmentsByDoctor(this.getId() ) ) {
            System.out.println(appointment.detail());
        }
    }
    public void SetAppointment(String patientId , Boolean status ,AppointmentManager appointmentManager){
        appointmentManager.setAppointmentDecision(patientId, this.getId(),status);
    }
    @Override
    public void chatMessage(String receiver, String chat) {
        timestamp = Instant.now();
        ChatServer.getInstance().addChat(this.getId(), receiver, chat, timestamp);
    }
    public void sendVideoLink(String id, String url,Administrator admin) {
        VideoCall.sendVideoCallLink(id, url,admin);
    }


}
