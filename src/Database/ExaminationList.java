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
public class ExaminationList extends ArrayList <Examination>{
    public ExaminationList(){
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
                String examID = stk.nextToken().trim();
                String doctorID = stk.nextToken().trim();
                String patientID = stk.nextToken().trim();
                String result = stk.nextToken().trim();
//                Date examDate = df.parse(stk.nextToken().trim());
                String examDateStr = stk.nextToken().trim();
                Date examDate = null;
                if (!examDateStr.equals("null")) {
                    examDate = df.parse(examDateStr);
                }
                Examination exam = new Examination(examID, doctorID, patientID, result, examDate);
                this.add(exam);
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
            for(Examination exam : this) {
            	pw.println(exam.toString());
            }
            pw.close();
            fw.close();  
            System.out.println("New examination data has been saved.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
