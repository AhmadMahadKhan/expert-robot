package AppointmentScheduling;

import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {
    private List<Appointment> appointments;

    //the list of all the appointments for the appointment manager
    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    //methods ==> adding all the appointment array list
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    public List<Appointment> getAppointments(){
        return appointments;
    }

    //a method to set the apointment
    public void setAppointmentDecision(String patientId,String doctorId, boolean status) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(patientId) && appointment.getDoctorId().equals(doctorId)) {
                appointment.setStatus(status);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    //viewing all the appointmnets of the patient ==> himself
    public List<Appointment> getAppointmentsByPatient(String patientId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientId().equals(patientId)) {
                result.add(a);
            }
        }
        return result;
    }

    //doctor viewing his appointments
    public List<Appointment> getAppointmentsByDoctor(String doctorID){
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctorID)) {
                result.add(a);
            }
        }
        return result;
    }


}
