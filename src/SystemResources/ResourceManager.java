package SystemResources;

import AppointmentScheduling.AppointmentManager;
import DoctorPatientInteraction.MedicalHistory;
import HealthDataHandling.VitalsDatabase;
import UserManagment.Administrator;

public class ResourceManager {
    public static VitalsDatabase vitalsDatabase = new VitalsDatabase();
    public static MedicalHistory medicalHistory = new MedicalHistory();
    public static AppointmentManager appointmentManager = new AppointmentManager();
    public static Administrator admin = Administrator.getInstance(); // Singleton
}
