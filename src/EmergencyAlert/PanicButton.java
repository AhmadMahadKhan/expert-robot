package EmergencyAlert;

import java.util.List;

//to do add panic send mail
//public class PanicButton {
//    public PanicButton(){
//    }
//    private String patientId;
//    public PanicButton(String patientId) {
//        this.patientId = patientId;
//    }
//    public void press() {
//        System.out.println("PANIC BUTTON PRESSED!");
//        triggerEmergencyAlert();
//    }
//    private void triggerEmergencyAlert() {
//        // You can integrate with NotificationService here
//        System.out.println("Alert: Emergency alert triggered for patient ID: " + patientId);
//        //send mail to the doctors to send emergeny to the patient
//    }
//}
public class PanicButton {

    private String patientId;
    private List<String> doctorEmails; // From appointmentManager via patient ID

    public PanicButton(String patientId, List<String> doctorEmails) {
        this.patientId = patientId;
        this.doctorEmails = doctorEmails;
    }

    public void press() {
        System.out.println("🚨 PANIC BUTTON PRESSED by patient: " + patientId);
        triggerEmergencyAlert();
    }

    private void triggerEmergencyAlert() {
        String subject = "PANIC ALERT – Patient ID: " + patientId;
        String message = "⚠️ The patient has manually triggered an emergency. Please respond immediately.";

        NotificationService service = new NotificationService();
        service.sendEmergencyAlerts(doctorEmails, subject, message);
    }
}
