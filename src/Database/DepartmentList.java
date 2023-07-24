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
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Win
 */
public class DepartmentList extends ArrayList<Department> {
    public DepartmentList(){
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
                String depID = stk.nextToken().trim();
                String depName = stk.nextToken().trim();
                Date createDate = df.parse(stk.nextToken().trim());
                String lastUpdateDateStr = stk.nextToken().trim();
                Date lastUpdateDate = null;
                if (!lastUpdateDateStr.equals("null")) {
                    lastUpdateDate = df.parse(lastUpdateDateStr);
                }
                Department dep = new Department(depID, depName, createDate, lastUpdateDate);
                this.add(dep);
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
            for(Department dep : this) {
            	pw.println(dep.toString());
            }
            pw.close(); fw.close();  
            System.out.println("The department list has been saved to the file.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
