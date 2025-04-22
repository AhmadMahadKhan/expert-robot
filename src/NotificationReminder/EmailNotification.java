package NotificationReminder;


public class EmailNotification implements Notifiable {

    @Override
    public void send(String to, String subject, String message) {
        EmailSender.sendEmail(to, subject, message); // Reusing your EmailSender
    }
}