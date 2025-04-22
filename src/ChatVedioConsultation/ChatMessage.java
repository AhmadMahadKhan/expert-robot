package ChatVedioConsultation;
import java.time.Instant;

public class ChatMessage {

    private String sender;
    private String receiver;
    private String message;
    private Instant timestamp;

    public ChatMessage(String sender, String receiver, String message, Instant timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
    public String toString() {
        return timestamp + " [" + sender + " ➜ " + receiver + "]: " + message;
    }
}
