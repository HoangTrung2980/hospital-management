/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuAndOps;
import Database.*;
import Tools.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.lang.*;
import Database.*;

/**
 *
 * @author Win
 */
public class HospitalManager {
    DepartmentList depList;
    DoctorList docList;
    ExaminationList examList;
    PatientList paList;
    Scanner sc = new Scanner(System.in);
    
    public HospitalManager(){
        depList = new DepartmentList();
        docList = new DoctorList();
        examList = new ExaminationList();
        paList = new PatientList();
    }

    public HospitalManager(DepartmentList depList, DoctorList docList, ExaminationList examList, PatientList paList) {
        this.depList = depList;
        this.docList = docList;
        this.examList = examList;
        this.paList = paList;
    }

       
    public void ShowDoctor(){
        if(docList.isEmpty())
            System.out.println("List is empty.");
        else{
            System.out.println(docList.toString());
        }
    }
    
    public void ShowDepartment(){
        if(depList.isEmpty())
            System.out.println("List is empty.");
        else{
            System.out.println(depList.toString());
        }
    }

    public void addDoctor() throws ParseException{
        String docID, depID;
        int pos1, pos2;
        do{
            docID=MyUtil.inputNonBlankStr("Doctor ID: ");
            pos1=docList.indexOf(new Doctor(docID));
            if(pos1>=0){
                System.out.println("Doctor ID duplicated.");
            }
        }while(pos1>=0);
        String docName = MyUtil.inputNonBlankStr("Doctor's name: ");
        boolean Sex;
        String userInput1 = MyUtil.inputNonBlankStr("Sex ('true' for male): ");
            if (userInput1 == "true") {
                Sex = true;
                } else {
                    Sex = false;
                }
        String docAddress = MyUtil.inputNonBlankStr("Doctor's address: ");
        do{    
        depID=MyUtil.inputNonBlankStr("Doctor's department ID: ");
        pos2 = depList.indexOf(new Department(depID));
        if(pos2<0){
            System.out.println("Invalid, department doesn't exist.");
        }
        }while(pos2<0);
        final Date createDate = new Date();
        Date lastUpdatedDate = null;
        Doctor doc = new Doctor(docID, docName, Sex, docAddress, depID, createDate, lastUpdatedDate);
        docList.add(doc);
        System.out.println("A doctor was added.");
        String cont;
        System.out.println("Do you want to continue, or back to main menu?");
        cont = MyUtil.inputNonBlankStr("Enter 'Yes' to continue: ");
        if (cont.toUpperCase().equals("YES"))
            addDoctor();
    }
    
    public void addDepartment() throws ParseException{
        String depID;
        int pos;
        do{
            depID = MyUtil.inputNonBlankStr("Department ID: ");
            pos = depList.indexOf(new Department(depID));
            if(pos>=0){
                System.out.println("Department ID duplicated.");
            }
        }while (pos>=0);
        String depName = MyUtil.inputNonBlankStr("Department Name: ");
        final Date createDate = new Date();
        Date lastUpdatedDate = null;
        Department dep = new Department(depID, depName, createDate, lastUpdatedDate);
        depList.add(dep);
        System.out.println("A department was added.");
        String cont;
        System.out.println("Do you want to continue, or back to main menu?");
        cont = MyUtil.inputNonBlankStr("Enter 'Yes' to continue: ");
        if (cont.toUpperCase().equals("YES"))
            addDepartment();
    }
    
    public void updateDoctor(){
        String docID;
        int pos1;
        do{
            docID=MyUtil.inputNonBlankStr("Doctor ID: ");
            String oldDocName, newDocName;
            Boolean oldSex, newSex;
            String oldDocAddress, newDocAddress;
            String oldDepID, newDepID;
            Date lastUpdatedDate;
            pos1 = docList.indexOf(new Doctor(docID));
            if(pos1 < 0){
                System.out.println("Doctor doesn't exist.");
            }
            else{
                Doctor doc = docList.get(pos1);
                oldDocName = doc.doctorName;
                oldSex = doc.sex;
                oldDocAddress = doc.address;
                oldDepID = doc.depID;
                Doctor doct = new Doctor(docID, oldDocName, oldSex, oldDocAddress, oldDepID,doc.createDate, doc.lastUpdateDate);
                
                String msg = "Change name: " + oldDocName + " -> ";
                newDocName = MyUtil.inputStr(msg);
                if (newDocName!=null)
                    doct.setDoctorName(newDocName);
                
                String msg1 = "Change gender: " + oldSex + " -> ";
                msg1 = MyUtil.inputStr("Gender ('true' for male): ");
                if(msg1!=null){
                    if (msg1 == "true") {
                        newSex = true;
                        } else {
                            newSex = false;
                        }
                doct.setSex(newSex);
                }
                
                String msg2 = "Change address" + oldDocAddress + " -> ";
                newDocAddress = MyUtil.inputStr(msg2);
                if (msg2!=null)
                    doct.setAddress(newDocAddress);
                
                String msg3 = "Change department ID: " + oldDepID + " -> ";
                newDepID = MyUtil.inputStr(msg3);
                if (msg3!=null){
                    int pos2 = depList.indexOf(newDepID);
                    while (pos2 <= 0){
                        System.out.println("Invalid department ID.");
                        newDepID = MyUtil.inputStr(msg3);
                    }
                    doct.setDepID(newDepID);
                }
                
                lastUpdatedDate = new Date();
                docList.set(pos1, doct);
            }
        }while (pos1<0);
    }
    
    public void updateDepartment(){
        String depID;
        int pos1;
        do{
            depID=MyUtil.inputNonBlankStr("Department ID: ");
            String oldDepName, newDepName;
            Date lastUpdatedDate;
            pos1 = depList.indexOf(new Department(depID));
            if(pos1 < 0){
                System.out.println("Department doesn't exist.");
            }
            else{
                Department dep = depList.get(pos1);
                oldDepName = dep.depName;
                Department depa = new Department(depID, oldDepName, dep.createDate, dep.lastUpdateDate);
                
                String msg = "Change name: " + oldDepName + " -> ";
                newDepName = MyUtil.inputStr(msg);
                if (newDepName!=null)
                    depa.setDepName(newDepName);

                lastUpdatedDate = new Date();
                depList.set(pos1, depa);
            }
        }while (pos1<0);
    }
    
    public void deleteDoctor(){
        String docID;
        int pos;
        docID = MyUtil.inputNonBlankStr("Doctor ID to be removed: ");
        pos = docList.indexOf(new Doctor(docID));
            if(pos < 0){
                System.out.println("Doctor doesn't exist. Deletion failed.");
                }
            else
                {
                docList.remove(new Doctor(docID));
                System.out.println("Deletion successful.");
                }
    }
    
    public void deleteDepartment(){
        String depID;
        int pos, pos1;
        depID = MyUtil.inputNonBlankStr("Department ID to be removed: ");
        pos = depList.indexOf(new Department(depID));
            if(pos < 0){
                System.out.println("Department doesn't exist. Deletion failed.");
                }
            else{
                pos1 = docList.indexOf(new Doctor(depID));
                if (pos1>=0)
                    System.out.println("There are doctors still working in the department, deletion failed.");
                else
                {
                    depList.remove(new Department(depID));
                    System.out.println("Deltetion successful.");
                }
            }   
    }
    
    public void searchDocName(){
        String searchName;
        boolean check = false;
        searchName = MyUtil.inputNonBlankStr("List doctors with name: ");
        for (Doctor doc: this.docList){
            if(doc.doctorName.contains(searchName)==true){
                System.out.println(doc.toString());
                check = true;
            }
        }
        if (check == false)
            System.out.println("There's no doctor matching the search criteria.");
    }
    
    public void searchDepID(){
        String searchID;
        searchID = MyUtil.inputNonBlankStr("Input ID information of department: ");
            int i = depList.indexOf(new Department(searchID));
            if (i>=0)
                System.out.println(depList.get(i));
            else System.out.println("Department doesn't exist.");
    }
    
    
    public void saveToFileDoc() {
        docList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB2\\doctor.dat");
    }
    
    public void saveToFileDep() {
        depList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB2\\department.dat");
    }

    
    public void showExaminationResult(){
        String searchID;
        boolean check = false;
        searchID = MyUtil.inputNonBlankStr("List examination records with patient's ID: ");
        for (Examination exam: this.examList){
            if(exam.patientID.contains(searchID)==true){
                System.out.println(exam.toString());
                check = true;
            }
        }
        if (check == false)
            System.out.println("There's no examination record of the searched patient's ID.");
        examList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\examination.dat");
    }
    
    public void addNewPatient(){
        String patientID, docID, examID;
        int pos1, pos2, pos3;
        do{
            patientID = MyUtil.inputNonBlankStr("Patient ID: ");
            pos1 = paList.indexOf(new Patient(patientID));
            if(pos1>=0){
                System.out.println("Patient ID duplicated.");
            }
        }while (pos1>=0);
        
        do{
            docID = MyUtil.inputNonBlankStr("Doctor ID: ");
            pos2 = depList.indexOf(new Department(docID));
            if(pos2<0){
                System.out.println("Doctor doesn't exist.");
            }
        }while (pos2<0);
        
        do{
            examID = MyUtil.inputNonBlankStr("Examination ID: ");
            pos3 = examList.indexOf(new Examination(examID));
            if(pos3>=0){
                System.out.println("Examination ID duplicated.");
            }
        }while (pos3>=0);
        
        String patientName = MyUtil.inputNonBlankStr("Patient Name: ");
        System.out.print("Patient age: ");
        int patientAge = Integer.parseInt(sc.nextLine());
        String patientAddress = MyUtil.inputNonBlankStr("Patient address: ");
        String result = null;
        Date examDate = null;
        Patient pa = new Patient(patientID, patientName, patientAge, patientAddress);
        Examination exam = new Examination(examID, docID, patientID, result, examDate);
        paList.add(pa);
        examList.add(exam);
        System.out.println("A new patient and examination record was added.");
        String cont;
        examList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\examination.dat");
        paList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\patient.dat");
        System.out.println("Do you want to continue, or back to main menu?");
        cont = MyUtil.inputNonBlankStr("Enter 'Yes' to continue: ");
        if (cont.toUpperCase().equals("YES"))
            addNewPatient();
    }
    
    int searchExamination(String targetDoctorID, String targetPatientID) {
        for (int i = 0; i < examList.size(); i++) {
            if ((examList.get(i).doctorID.equals(targetDoctorID)) && (examList.get(i).patientID.equals(targetPatientID))) {
                return i;
            }
        }
        return -1;
    }
    
    public void recordExamination(){
        String docID, patientID;
        int index;
            String oldResult, newResult;
            Date newExDate;
            docID = MyUtil.inputNonBlankStr("Enter doctor's ID: ");
            patientID = MyUtil.inputNonBlankStr("Enter patient's ID: ");
            index = searchExamination(docID, patientID);
            if (index>=0){
                Examination exam = examList.get(index);
                oldResult = exam.result;
                newExDate = new Date();
                Examination ex = new Examination(exam.examID, docID, patientID, oldResult, exam.examDate);
                String msg = "Change result: " +  oldResult + "->";
                newResult = MyUtil.inputStr(msg);
                if (newResult!=null)
                    ex.setResult(newResult);
                ex.setExamDate(newExDate);
                
                System.out.println(ex);
                examList.set(index, ex);
            }
            else
                System.out.println("Examination doesn't exist.");
        
        examList.saveToFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\examination.dat");
    }
}
