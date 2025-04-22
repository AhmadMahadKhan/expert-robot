package EmergencyAlert;


import AppointmentScheduling.Appointment;
import AppointmentScheduling.AppointmentManager;
import HealthDataHandling.VitalSign;
import UserManagment.Administrator;
import UserManagment.Doctor;

import java.util.ArrayList;
import java.util.List;


//checks the vitals of the patient at the time of upload
public class EmergencyAlert {

    //attributes
    private boolean criticalCondition = false ;
    public EmergencyAlert(){

    }
    public static void alert(List<VitalSign> vitals, AppointmentManager appointmentManager, Administrator admin){
        Boolean criticalCondition = false;
        for(VitalSign vitalSign : vitals){

            int oxygen = vitalSign.getOxygenLevel();
            int hr = vitalSign.getHeartRate();
            String bp = vitalSign.getBloodPressure();
            double temp = vitalSign.getTemp();
            int systolic = Integer.parseInt(bp.split("/")[0]);
            int diastolic = Integer.parseInt(bp.split("/")[1]);

            if (oxygen < 90 || oxygen >=100 ||
                    hr < 60 || hr >= 100 ||
                    systolic < 90 || systolic >= 120 ||
                    diastolic <= 60 || diastolic >= 80 ||
                    temp < 36.1 || temp > 37.2) {

                criticalCondition = true;
            }

            if (criticalCondition) {
                ArrayList<String> ids = new ArrayList<>();
                ArrayList<String> email = new ArrayList<>();
                //selecting all doctors to which patient has scheduled an appointment
                for(Appointment appointment : appointmentManager.getAppointmentsByPatient(vitalSign.getPatientId())){
                    ids.add(appointment.getDoctorId());
                }
                if(ids.isEmpty()){
                    System.out.println("The patient has no doctor.");
                    System.out.println("Sending Alert to all doctors...");
                    for(Doctor doctor : admin.getDoctors()){
                        email.add(doctor.getEmail());
                    }
                }
                //getting the emails of all the doctors
                for(Doctor doctor : admin.getDoctors()){
                    for(String id : ids){
                        if(doctor.getId().equals(id)){
                            email.add(doctor.getEmail());
                        }
                    }
                }
                String subject = "Emergency Alert for Patient ID: " + vitalSign.getPatientId();
                //System.out.println("EMERGENCY ALERT for Patient ID: " + vitalSign.getPatientId());
                String text = "The patient with ID: " + vitalSign.getPatientId() + " has a critical condition. Please send medical care immediately.";
                NotificationService service = new NotificationService();
                service.sendEmergencyAlerts(email, subject, text);
            }
        }
    }

//    //getter method
//    public boolean getCriticalCondition(){
//
//        return criticalCondition;
//    }

}
