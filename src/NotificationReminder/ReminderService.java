package NotificationReminder;



public class ReminderService {

    private Notifiable notifier;

    public ReminderService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void sendAppointmentReminder(String to, String appointmentDetails) {
        String subject = "📅 Appointment Reminder";
        String message = "Reminder: You have an appointment coming up.\n\nDetails:\n" + appointmentDetails;
        notifier.send(to, subject, message);
    }

    public void sendMedicationReminder(String to, String medicationDetails) {
        String subject = "💊 Medication Reminder";
        String message = "Don't forget to take your medicine:\n" + medicationDetails;
        notifier.send(to, subject, message);
    }
}
