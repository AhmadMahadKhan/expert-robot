package NotificationReminder;

public class SMSNotification implements Notifiable {

    @Override
    public void send(String to, String subject, String message) {
        System.out.println("📱 SMS Sent to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
