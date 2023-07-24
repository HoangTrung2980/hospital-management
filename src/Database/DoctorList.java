/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Win
 */
public class DoctorList extends ArrayList<Doctor> {
    public DoctorList(){
        super();
    }
    
    public boolean loadFromFile(String fName) {
        try {
            File f = new File(fName); 
            if(!f.exists()) 
                return true;
            FileReader fr = new FileReader(fName);
            BufferedReader bf = new BufferedReader(fr);
            String details; 
            while((details=bf.readLine())!=null) {
                if (details.trim().equals(""))
                    continue;
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                StringTokenizer stk = new StringTokenizer(details,"|");
                String doctorID = stk.nextToken().trim();
                String doctorName = stk.nextToken().trim();
                Boolean sex;
                if(stk.nextToken().trim() == "Male")
                    sex = true;
                else sex = false;
                String address = stk.nextToken().trim();
                String depID = stk.nextToken().trim();
                Date createDate = df.parse(stk.nextToken().trim());
                String lastUpdateDateStr = stk.nextToken().trim();
                Date lastUpdateDate = null;
                if (!lastUpdateDateStr.equals("null")) {
                    lastUpdateDate = df.parse(lastUpdateDateStr);
                }
                Doctor doc = new Doctor(doctorID, doctorName, sex, address, depID, createDate, lastUpdateDate);
                this.add(doc);
            }
            bf.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    
    public boolean saveToFile(String fName) {
        if(this.isEmpty()) {
            System.out.println("Empty list!");
            return true;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Doctor doc : this) {
            	pw.println(doc.toString());
            }
            pw.close();
            fw.close();  
            System.out.println("The doctor list has been saved to the file.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return true;
}
}
