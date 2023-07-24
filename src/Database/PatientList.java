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
import java.text.*;
import java.util.*;

/**
 *
 * @author Win
 */
public class PatientList extends ArrayList<Patient> {
    public PatientList(){
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
                StringTokenizer stk = new StringTokenizer(details,"|");
                String patientID = stk.nextToken().trim();
                String patientName = stk.nextToken().trim();
                int patientAge = Integer.parseInt(stk.nextToken().trim());
                String patientAddress = stk.nextToken().trim();
                Patient pat = new Patient(patientID, patientName, patientAge, patientAddress);
                this.add(pat);
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
            for(Patient pat : this) {
            	pw.println(pat.toString());
            }
            pw.close();
            fw.close();  
            System.out.println("New patient data has been saved");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
