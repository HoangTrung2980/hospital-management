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
public class Department {
    public String depID;
    public String depName;
    public Date createDate;
    public Date lastUpdateDate;

    public Department(String depID, String depName, Date createDate, Date lastUpdateDate) {
        this.depID = depID;
        this.depName = depName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }
    
    public Department(String depID) {
        this.depID = depID;
    }
    
    @Override
    public boolean equals (Object obj){
        return depID.equals(((Department)obj).depID);
    }
    
    @Override
    public String toString(){
        String crDate;
        String laDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        crDate = formatter.format(createDate);
        if (lastUpdateDate!=null)
            laDate = formatter.format(lastUpdateDate);
        return depID + " | " + depName + " | " + crDate + " | " + laDate + "\n"; 
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
