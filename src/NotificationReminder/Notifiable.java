package NotificationReminder;

public interface Notifiable {


    void send(String to, String subject, String message);
}