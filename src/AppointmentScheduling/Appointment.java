package AppointmentScheduling;

import java.time.LocalDateTime;
import java.util.Date;

public class Appointment {
    private final LocalDateTime dateTime ;
    private final String patientId;
    private final String doctorId ;
    private Boolean status ;

    //constructor
    public Appointment(String patientId , String doctorId , LocalDateTime dateTime  ){
        //by default status is pending ==> false
        this.status = false ;
        this.patientId = patientId ;
        this.doctorId = doctorId ;
        this.dateTime = dateTime;
    }
    public  String getPatientId(){
        return patientId;
    }
    public String getDoctorId(){
        return doctorId;
    }
    public void setStatus(Boolean status){
        this.status =  status ;
    }
    public Boolean getStatus(){
        return  status;
    }

    //detail of appointment
    public String detail(){
        return "=== Appointment ===" +
                "\nPatient ID: " + patientId +
                "\nDoctor ID: " + doctorId +
                "\nDate: " + dateTime +
                "\nStatus: " + (status ? "Approved" : "Pending");
    }

}
