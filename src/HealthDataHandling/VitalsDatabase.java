package HealthDataHandling;

import java.util.ArrayList;
import java.util.List;

public class VitalsDatabase {

    private List<VitalSign> vitalSigns;

    //constructor
    public VitalsDatabase() {
        System.out.println("Vital database default constructor called");
        this.vitalSigns = new ArrayList<VitalSign>();

    }
    public List<VitalSign> getVitalDatabase(){
        return vitalSigns;
    }

    public void addVitalSign(VitalSign vitalSign){
        vitalSigns.add(vitalSign);
    }


}
