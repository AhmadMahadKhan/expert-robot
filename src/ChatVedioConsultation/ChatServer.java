package ChatVedioConsultation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private static ChatServer instance;
    private List<ChatMessage> chats;

    public ChatServer(){
        chats = new ArrayList<>();
    }

    public static ChatServer getInstance() {
        if (instance == null) {
            instance = new ChatServer();
        }
        return instance;
    }

    //adding chats to the server
//    public void addChat(){
//
//    }
    public  void addChat(String sender, String receiver, String message, Instant timestamp) {
        chats.add(new ChatMessage(sender, receiver, message, timestamp));
    }
    public void showAllChats() {
        for (ChatMessage chat : chats) {
            System.out.println(chat);
        }
    }
    // For displaying all messages
    public void showChatsForUser(String userName) {
        for (ChatMessage chat : chats) {
            if (chat.getSender().equals(userName) || chat.getReceiver().equals(userName)) {
                System.out.println(chat);
            }
        }
    }

}



