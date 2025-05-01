package MAIN;
import Logins.LoginManager;

import UserManagment.Administrator;

import java.util.Scanner;

//main method
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming ResourceManager.admin is already initialized as a Singleton
        Administrator admin = new Administrator("name","id","email");
        Administrator.setInstance(admin);

        // Initialize LoginManager and load users from admin
        LoginManager loginManager = new LoginManager();


        // Simple main loop
        while (true) {
            loginManager.loadUsersFromAdmin(admin);
            System.out.println("\n=== Remote Patient Monitoring System ===");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            //  int choice = Integer.parseInt(scanner.nextLine());

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        loginManager.signup();
                        break;
                    case 2:
                        loginManager.login();
                        break;
                    case 3:
                        System.out.println("Exiting system. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
            }

        }
    }
}
//
//package MAIN;
//
//import Logins.LoginManager;
//import UserManagment.Administrator;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Main extends JFrame {
//    private LoginManager loginManager;
//    private Administrator admin;
//
//    public Main() {
//        // Administrator and LoginManager initialization
//        admin = new Administrator("name", "id", "email");
//        Administrator.setInstance(admin);
//
//        loginManager = new LoginManager();
//        loginManager.loadUsersFromAdmin(admin);
//
//        // GUI setup
//        setTitle("Remote Patient Monitoring System");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null); // Center the frame
//
//        // Create buttons
//        JButton signupButton = new JButton("Signup");
//        JButton loginButton = new JButton("Login");
//        JButton exitButton = new JButton("Exit");
//
//        // Set layout
//        setLayout(new GridLayout(4, 1, 10, 10));
//
//        // Add label and buttons
//        add(new JLabel("=== Remote Patient Monitoring System ===", SwingConstants.CENTER));
//        add(signupButton);
//        add(loginButton);
//        add(exitButton);
//
//        // Add action listeners
//        signupButton.addActionListener(e -> loginManager.signup());
//        loginButton.addActionListener(e -> loginManager.login());
//        exitButton.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "Exiting system. Goodbye!");
//            System.exit(0);
//        });
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            Main gui = new Main();
//            gui.setVisible(true);
//        });
//    }
//}
//
