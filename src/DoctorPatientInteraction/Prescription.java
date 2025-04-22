package DoctorPatientInteraction;

public class Prescription {

    //attributs
    private String medicine ;
    private String dosage ;
    private String schedule ;
    private String patientId;
    private String doctorId;

    //constructor
    public Prescription(String medicine, String dosage, String schedule, String patientId, String doctorId){
        this.medicine = medicine;
        this.dosage = dosage;
        this.schedule = schedule;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }


    //setter methods
    public void setSchedule(String schedule){
        if(schedule != null && !schedule.isEmpty()){
            this.schedule = schedule ;
        }
        else {
            System.out.println("Schedule cannot be empty ");
        }
    }
    public void setDosage(String dosage){
        if(dosage != null && !dosage.isEmpty()){
            this.dosage = dosage ;
        }
        else {
            System.out.println("Dosage cannot be empty ");
        }
    }
    public void setMedicine(String medicine){
        if(medicine != null && !medicine.isEmpty()){
            this.medicine = medicine ;
        }
        else {
            System.out.println("Medicine cannot be empty ");
        }
    }

    //getter methods
    public String getPatientId(){
        return patientId ;
    }
    public String getDoctorId(){
        return doctorId ;
    }

    //display method
    public String detail(){
        return "===Prescription==="+
                "\nmedicine: "+medicine +
                "\ndosage: " + dosage +
                "\nschedule: "+schedule ;
    }
}
