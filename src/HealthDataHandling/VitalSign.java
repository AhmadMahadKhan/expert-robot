package HealthDataHandling;

import UserManagment.Patient;

public class VitalSign {

    // attributes
    private int oxygenLevel;
    private int heartRate;
    private String bloodPressure;
    private double temp;
    private String patientId;

    // constructor
    public VitalSign(int oxygenLevel, int heartRate, double temp, String patientId, int systolic,int diastolic) {
        setOxygenLevel(oxygenLevel);
        setHeartRate(heartRate);
        setBloodPressure(systolic,diastolic);
        setTemp(temp);
        setPatientId(patientId);
    }

    // setter methods with validation
    public void setOxygenLevel(int oxygenLevel) {
        if (oxygenLevel >= 80 && oxygenLevel <= 100) {
            this.oxygenLevel = oxygenLevel;
        } else {
            throw new IllegalArgumentException("Oxygen level must be between 80 and 100.");
        }
    }

    public void setTemp(double temp) {
        if (temp >=  28.0 && temp <=42) {
            this.temp = temp;
        } else {
            throw new IllegalArgumentException("Temperature must be between 28°C and 42.0°C .");
        }
    }

    public void setHeartRate(int heartRate) {
        if (heartRate >= 40 && heartRate <= 180) {
            this.heartRate = heartRate;
        } else {
            throw new IllegalArgumentException("Heart rate must be between 40 and 140 bpm.");
        }
    }

//    public void setBloodPressure(String bloodPressure) {
//        if (bloodPressure != null && bloodPressure.matches("\\d{2,3}/\\d{2,3}")) {
//            this.bloodPressure = bloodPressure;
//        } else {
//            throw new IllegalArgumentException("Blood pressure must be in format '###/###'.");
//        }
//    }
//public void setBloodPressure(String bloodPressure) {
//    // Allow both 2 or 3 digits before and after the slash (e.g., 120/80, 120/080)
//    if (bloodPressure != null && bloodPressure.matches("\\d{2,3}/\\d{2,3}")) {
//        this.bloodPressure = bloodPressure;
//    } else {
//        throw new IllegalArgumentException("Blood pressure must be in format '###/###' or '##/##'.");
//    }
//}

    public void setBloodPressure(int systolic, int diastolic) {
        // Simple validation for systolic and diastolic ranges
        if (systolic >= 80 && systolic <= 200 && diastolic >= 60 && diastolic <= 130) {
            // If valid, format and assign blood pressure
            this.bloodPressure = systolic + "/" + diastolic;
        } else {
            throw new IllegalArgumentException("Blood pressure values must be within valid ranges: systolic (80-200), diastolic (60-130).");
        }
    }

    public void setPatientId(String patientId) {
        if (patientId != null && !patientId.isBlank()) {
            this.patientId = patientId;
        } else {
            throw new IllegalArgumentException("Patient ID cannot be null or blank.");
        }
    }

    // getter methods
    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public double getTemp() {
        return temp;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public String getPatientId() {
        return patientId;
    }
    public String detail(){
        String data = "Patient ID: "+getPatientId()+
                "\nHeart rate: "+getHeartRate()+
                "\nTemprature: "+getTemp()+" C"+
                "\nBlood pressure: "+getBloodPressure()+
                "\nOxygen level: "+getOxygenLevel();
        return data ;
    }
}
