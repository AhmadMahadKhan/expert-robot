package DoctorPatientInteraction;

public class Feedback {

    //attributes
    private String doctorId;
    private String patientId;
    private String feedback;

    public Feedback(String doctorId  , String patientId , String feedback){
        this.doctorId = doctorId ;
        this.patientId = patientId ;
        this.feedback = feedback ;
    }
public Feedback( String feedback){
   this.feedback = feedback ;
}


//    getter methods
    public String getPatientId() {
        return patientId;
    }
    public String getDoctorId(){
        return  doctorId ;
    }
    public String getFeedback() {
        return feedback;
    }


//    for validation
    private void setPatientId(String patientId){
        this.patientId =patientId ;
    }

    public String detail(){
        String data = "Patient Id: "+getPatientId()+
                "\nDoctor Id: "+getDoctorId()+
                "\nFeedback: "+getFeedback();
        return data ;
    }


}
