/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.*;
import java.text.*;
/**
 *
 * @author Win
 */
public class Patient {
    
    public String patientID;
    public String patientName;
    public int patientAge;
    public String patientAddress;

    public Patient(String patientID, String patientName, int patientAge, String patientAddress) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
    }
    
    public Patient(String patientID) {
        this.patientID = patientID;
    }
    
    @Override
    public boolean equals (Object obj){
        return patientID.equals(((Patient)obj).patientID);
    }
    
    @Override
    public String toString(){
        return patientID + " | " +  patientName + " | " + patientAge + " | " + patientAddress + "\n";
    }
    

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
     public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
}
