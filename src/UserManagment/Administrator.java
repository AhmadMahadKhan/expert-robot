package UserManagment;


import java.util.ArrayList;

public class Administrator extends User{

    //controls patients and doctors creation and removal
    //the administrator ==> store patients and doctors

    //setting the instance to null
    //in the method, the INSTANCE ENUM will be null
   private static Administrator instance = null ;

   //an arraylist for adding patients and doctors
    ArrayList<Patient> patients ;
    ArrayList<Doctor> doctors ;
    Patient patient ;
    Doctor doctor;

    //admin constructor creating its own arraylist
    //new admins meaning new arraylists
    public Administrator(String name , String id , String email ){
        super(name, id , email);
        System.out.println("admin is created");
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }
    // Public method to get the single instance
    public static Administrator getInstance(String name, String id,String email) {
        if (instance != null) {
            throw new RuntimeException("Only one Administrator can be created!");
        }
        instance = new Administrator(name, id,email);
        System.out.println("Administrator account created.");
        return instance;
    }

    public static Administrator getInstance() {
        if (instance == null) {
            throw new RuntimeException("Administrator account has not been created yet!");
        }
        return instance;
    }

    public static void setInstance(Administrator admin) {
        instance = admin;
    }

    //methods to add the patients and doctor
    public void addPatient(String name , String id,String email){
        for(Patient patient : patients){
            if(patient.getId().equals(id)){
                System.out.println("Patient already exists");
                return;
            }
            else if(patient.getEmail().equals(email)){
                System.out.println("Email already exists");
                return;
            }
        }
        patient = new Patient(name, id , email);
        patients.add(patient);
        System.out.println("patient added");
    }



    public void addDoctor(String name ,String id,String email){
        for(Doctor doctor : doctors){
            if(doctor.getId().equals(id)){
                System.out.println("Doctor already exists");
                return;
            }
            else if(patient.getEmail().equals(email)){
                System.out.println("Email already exists");
                return;
            }
        }
        doctor = new Doctor(name, id , email);
        doctors.add(doctor);
        System.out.println("doctor added");
    }

    //methods to remove doctor and patient
    public void removePatient(String name, String id) {
        patients.removeIf(p -> p.getName().equals(name) && p.getId().equals(id));
    }

    public void removeDoctor(String name, String id) {
        doctors.removeIf(d -> d.getName().equals(name) && d.getId().equals(id));
    }

    // In Administrator.java

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }


    @Override
    public String toString(){

        return super.toString();
    }
}

