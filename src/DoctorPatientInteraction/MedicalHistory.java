package DoctorPatientInteraction;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistory {

    //attributes
    private String patientId;
    private String doctorId;
    private List<Feedback> feedbacks;
    private List<Prescription> prescriptions;

    //constructor
    public MedicalHistory(){
//        this.patientId = patientId ;
//        this.doctorId = doctorId  ;
        this.feedbacks = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        if (feedback != null) {
            this.feedbacks.add(feedback);
        } else {
            System.out.println("Invalid feedback entry.");
        }
    }
    public void addPrescription(Prescription prescription) {
        if (prescription != null) {
            this.prescriptions.add(prescription);
        } else {
            System.out.println("Invalid prescription entry.");
        }
    }

    //getter methods for feedback
    public  List<Feedback> getFeedbacks(){
        return feedbacks;
    }public  List<Prescription> getPrescriptions(){
        return prescriptions;
    }
    //get all feedback by the doctor to a patient
    public void getFeedback(String patientId, String doctorId){
        boolean found = false;
        for (Feedback feedback : feedbacks) {
            if (feedback.getPatientId().equals(patientId) && feedback.getDoctorId().equals(doctorId)) {
                System.out.println("Feedback: " + feedback.getFeedback());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No feedback found for this doctor and patient.");
        }
    }

}
