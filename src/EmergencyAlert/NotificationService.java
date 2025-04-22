package EmergencyAlert;

import NotificationReminder.EmailSender;

import java.util.List;

public class NotificationService {

    public void sendEmergencyAlerts(List<String> doctorEmails, String subject, String message) {
        if (doctorEmails == null || doctorEmails.isEmpty()) {
            System.out.println("No doctors to notify. Patient may not have appointments.");
            return;
        }

        for (String email : doctorEmails) {
            EmailSender.sendEmail(email, subject, message);
        }

        System.out.println("✅ Emergency alert emails sent to assigned doctors.");
    }
//
//    public  void  sendEmergencyAlerts(boolean response){
//        if(!response){
//            System.out.println("trial");
//            System.out.println("email not send");
//            System.out.println("patient stable");
//        }
//        if(response){
//            //send mail to the doctor if the vitals of the patiend are critcal
//            EmailSender.sendEmail("random.@gmail.com","he","haha");
//        }
//
//    }


}
