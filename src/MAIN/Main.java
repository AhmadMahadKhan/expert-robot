package MAIN;
import Logins.LoginManager;

import UserManagment.Administrator;

import java.util.Scanner;

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
