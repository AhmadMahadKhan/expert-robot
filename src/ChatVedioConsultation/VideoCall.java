package ChatVedioConsultation;

import NotificationReminder.EmailSender;
import UserManagment.Administrator;
import UserManagment.Doctor;
import UserManagment.Patient;

import javax.print.Doc;
import javax.print.DocFlavor;

public interface VideoCall {

    //interface ==> for doctor and patient to share vedio link via email
    public static   void sendVideoCallLink(String to  , String URL, Administrator admin){
        for(Doctor doctor : admin.getDoctors()){
           if(doctor.getId().equals(to)){
               to = doctor.getEmail();
           }
        }
        for(Patient patient : admin.getPatients()){
            if(patient.getId().equals(to)){
                to = patient.getEmail();
            }

        }
        EmailSender.sendEmail(to , "Video Chat Link" ,URL);
    }
}
