//package Logins;
//
//import UserManagment.*;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class LoginManager {
//
//    ArrayList<User> users ;
//    Scanner scanner  = new Scanner(System.in);
//
//    public LoginManager(){
//       users =  new ArrayList<>();
//    }
//    //not asking about the user about his role
//    //they are defined by the administrator
//    //who gives them id
//    public void signup(){
//        System.out.println("Enter your name :");
//        String name = scanner.nextLine();
//        System.out.println("Enter you Id : ");
//        String id = scanner.nextLine();
//        System.out.println("Enter your email : ");
//        String email = scanner.nextLine();
//        System.out.println("Enter your password : ");
//        String password = scanner.nextLine();
//    }
//    public void login(){
//        System.out.println("Enter your email : ");
//        String email = scanner.nextLine();
//        System.out.println("Enter your password : ");
//        String password = scanner.nextLine();
//    }
//
//
//
//
//
//
//}

//=================
//package Logins;
//
//import UserManagment.*;
//import UserManagment.User;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class LoginManager {
//    private ArrayList<User> users;
//    private Scanner scanner;
//    private ArrayList<User> loginUser;
//
//
//    //constructor
//    public LoginManager() {
//        users = new ArrayList<>();
//        loginUser = new ArrayList<>();
//        scanner = new Scanner(System.in);
//
//    }
//
//   //loads all the data from the admin ==> all doctors and patients
//    public void loadUsersFromAdmin(Administrator admin) {
//       try{
//           for (Patient p : admin.getPatients()) {
//               users.add(p); // adds each patient
//           }
//           for (Doctor d : admin.getDoctors()) {
//               users.add(d); // adds each doctor
//           }
//
//       }
//       catch(Exception e){
//           System.out.println("Error in loading data.");
//       }
//        System.out.println("Users loaded from admin successfully.");
//    }
//
//
//    // Admin calls this to add a user (no password yet)
//    //to the login user list
//
//    //after which to check whether the user has entered or not
//    public void addUser(User user) {
//        loginUser.add(user);
//        //adding user to the new database after which to check he does not try to singup again
//    }
//
//    // Users set their own password using this
//    public  void signup() {
//        System.out.println("=== Signup ===");
//        System.out.print("Enter your email: ");
//        String email = scanner.nextLine();
//
//        User foundUser = null;
//        for (User user : loginUser) {
//            if (user.getEmail().equals(email)) {
//                foundUser = user;
//                break;
//            }
//        }
//
//        if (foundUser == null) {
//            System.out.println("User not found. Please contact Administrator.");
//            return;
//        }
//
//        if (!foundUser.getPassword().isEmpty()) {
//            System.out.println("Password already set. You can login instead.");
//            return;
//        }
//
//        System.out.print("Set your password: ");
//        String password = scanner.nextLine();
//        foundUser.setPassword(password);
//        System.out.println("Signup completed. You can now log in.");
//    }
//
//    // Regular login
//    public  static void login(String email,String password) {
//        System.out.println("=== Login ===");
//        System.out.print("Enter your email: ");
//     //   String email = scanner.nextLine();
//
//        System.out.print("Enter your password: ");
//     //   String password = scanner.nextLine();
//
//        for (User user : loginUser) {
//            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//                System.out.println("Login successful. Welcome, " + user.getName() + "!");
//                return;
//            }
//        }
//
//        System.out.println("Invalid credentials. Try again.");
//    }
//
//    // For testing/debugging
//    public void listAllUsers() {
//        System.out.println("=== Registered Users ===");
//        for (User user : users) {
//            System.out.println(user);
//            System.out.println("Password Set: " + (!user.getPassword().isEmpty()));
//            System.out.println();
//        }
//    }
//}
//
//
//
//



//===========
package Logins;
//loadUsersFromAdmin ===> resource clear
import AppointmentScheduling.AppointmentManager;
import DoctorPatientInteraction.MedicalHistory;
import HealthDataHandling.VitalsDatabase;
import RoleMenus.MenuHandler;
import SystemResources.ResourceManager;
import UserManagment.*;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginManager {

    //attributes
    private ArrayList<User> users;
    private ArrayList<User> loginUser;
    private Scanner scanner;

    //constructor
    public  LoginManager() {
        users = new ArrayList<>();
        loginUser = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    //load all the users which admin has added in the hospital database and then saves them to its own system
    public void loadUsersFromAdmin(Administrator admin) {
        try {
            for (Patient p : admin.getPatients()) {
                users.add(p);
                loginUser.add(p);
            }
            for (Doctor d : admin.getDoctors()) {
                users.add(d);
                loginUser.add(d);
            }
            loginUser.add(admin);
            System.out.println("Users loaded from admin successfully.");
        } catch (Exception e) {
            System.out.println("Error in loading users.");
        }
    }

    public  void signup() {
        System.out.println("=== Signup ===");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        //user instance created ==> set to null
        User foundUser = null;
        for (User user : loginUser) {
            if (user.getEmail().equals(email)) {
                foundUser = user;
                break;
            }
        }

        if (foundUser == null) {
            System.out.println("User not found. Please contact administrator.");
            return;
        }
        //if the password is already set ===> user already registered in out system
        if (!foundUser.getPassword().isEmpty()) {
            System.out.println("Password already set. Try logging in.");
            return;
        }

        System.out.print("Set your password: ");
        String password = scanner.nextLine();
        foundUser.setPassword(password);
        System.out.println("Signup successful. You may now log in.");
    }

    public void login() {
        System.out.println("=== Login ===");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : loginUser) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + user.getName() + "!");
                // After login is successful:
                if (user instanceof Patient) {
                    MenuHandler.handlePatientMenu(
                            (Patient) user,
                            ResourceManager.vitalsDatabase,
                            ResourceManager.medicalHistory,
                            ResourceManager.admin,
                            ResourceManager.appointmentManager
                    );
                } else if (user instanceof Doctor) {
                    MenuHandler.handleDoctorMenu((Doctor) user,
                            ResourceManager.vitalsDatabase,
                            ResourceManager.medicalHistory,
                            ResourceManager.appointmentManager,
                            ResourceManager.admin);
                } else if (user instanceof Administrator) {
                    MenuHandler.handleAdminMenu((Administrator) user);
                }
                return;
            }
        }

        System.out.println("Invalid credentials.");
    }

    public void listAllUsers() {
        System.out.println("=== Registered Users ===");
        for (User user : users) {
            System.out.println(user.getName() + " | Email: " + user.getEmail() + " | Password Set: " + !user.getPassword().isEmpty());
        }
    }



    private Patient findPatientById(String id) {
        for (User u : users) {
            if (u instanceof Patient && u.getId().equals(id)) {
                return (Patient) u;
            }
        }
        return null;
    }
}
