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
public class Doctor {
    public String doctorID;
    public String doctorName;
    public Boolean sex;
    public String address;
    public String depID;
    public Date createDate;
    public Date lastUpdateDate;

    public String getDoctorID() {
        return doctorID;
    }
    
    public Doctor(String doctorID, String doctorName, Boolean sex, String address, String depID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.depID = depID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Doctor(String doctorID) {
        this.doctorID = doctorID;
    }
    
    @Override
    public boolean equals(Object obj){
        return doctorID.equals(((Doctor)obj).doctorID);
    }
    
    @Override
    public String toString(){
        String crDate;
        String laDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        crDate = formatter.format(createDate);
        if(lastUpdateDate!=null)
            laDate = formatter.format(lastUpdateDate);
        return doctorID + " | " + doctorName + " | " + (sex == true? "Male":"Female") + " | " + address + " | " + depID + " | " + crDate + " | " + laDate + "\n";
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
