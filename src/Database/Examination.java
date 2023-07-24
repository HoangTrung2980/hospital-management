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
public class Examination {

    public String examID;
    public String doctorID;
    public String patientID;
    public String result;
    public Date examDate;

    public Examination(String examID, String doctorID, String patientID, String result, Date examDate) {
        this.examID = examID;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.result = result;
        this.examDate = examDate;
    }
    
    public Examination(String examID) {
        this.examID = examID;
    }
    
    public Examination(String doctorID, String patientID) {
        this.doctorID = doctorID;
        this.patientID = patientID;
    }
    
    @Override
    public boolean equals (Object obj){
        return examID.equals(((Examination)obj).examID);
    }
    
    @Override
    public String toString(){
        String exDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(examDate!=null)
            exDate = formatter.format(examDate);
        return examID + " | " + doctorID + " | " + patientID + " | " + result + " | " + exDate + "\n";
        
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
