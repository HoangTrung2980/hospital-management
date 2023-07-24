/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuAndOps;

import java.text.ParseException;
import java.util.*;
import Database.*;

/**
 *
 * @author Win
 */
public class ManagerProgram {
    public static void main (String[] args) throws ParseException{
        ArrayList<String> ops = new ArrayList<>();
        ArrayList<String> ops1 = new ArrayList<>();
        ArrayList<String> ops2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your action: ");
        ops.add("1/ LAB2 functions.");
        ops.add("2/ LAB3 functions.");
        ops.add("Others - quit.");
        System.out.println();
        
        DepartmentList depList = new DepartmentList();
        DoctorList docList = new DoctorList();
        ExaminationList examList = new ExaminationList();
        PatientList paList = new PatientList();
        
        HospitalManager manager = new HospitalManager(depList, docList, examList, paList);
        
        docList.loadFromFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\doctor.dat");
        depList.loadFromFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\department.dat");
        examList.loadFromFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\examination.dat");
        paList.loadFromFile("C:\\Users\\Win\\Documents\\NetBeansProjects\\LAB201\\LAB3 (LAB2 Extension)\\patient.dat");
        
        int mainMenuChoice;
        int subMenuChoice;
        int subMenuChoice2;
        Menu menu = new Menu();
        do {
    		mainMenuChoice = menu.int_getChoice(ops);
                switch (mainMenuChoice){
                    case 1:{
                        ops1.clear();
                        ops1.add("1.1/ Show information.");
                        ops1.add("1.2/ Add new.");
                        ops1.add("1.3/ Update information.");
                        ops1.add("1.4/ Delete.");
                        ops1.add("1.5/ Search information.");
                        ops1.add("1.6/ Store data to file.");
                        ops1.add("Others - Quit.");
                        System.out.println();
                        do{
                            subMenuChoice = menu.int_getChoice(ops1);
                            switch (subMenuChoice){
                            case 1:{
                                ops2.clear();
                                ops2.add("1.1.1/ Show doctor list.");
                                ops2.add("1.1.2/ Show department list.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                        switch (subMenuChoice2){
                                            case 1:
                                                manager.ShowDoctor();
                                                break;
                                            case 2:
                                                manager.ShowDepartment();
                                                break;
                                            default:
                                                break;
                                        }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                            }
                        
                            case 2:{
                                ops2.clear();
                                ops2.add("1.2.1/ Add new doctor.");
                                ops2.add("1.2.2/ Add new department.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                    switch (subMenuChoice2){
                                        case 1:
                                            manager.addDoctor();
                                            break;
                                        case 2:
                                            manager.addDepartment();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                            }
                            case 3:{
                                ops2.clear();
                                ops2.add("1.3.1/ Update doctor.");
                                ops2.add("1.3.2/ Update department.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                    switch (subMenuChoice2){
                                        case 1:
                                            manager.updateDoctor();
                                            break;
                                        case 2:
                                            manager.updateDepartment();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                            }
                            case 4:{
                                ops2.clear();
                                ops2.add("1.4.1/ Delete doctor.");
                                ops2.add("1.4.2/ Delete department.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                    switch (subMenuChoice){
                                        case 1:
                                            manager.deleteDoctor();
                                            break;
                                        case 2:
                                            manager.deleteDepartment();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                            }
                            case 5:{
                                ops2.clear();
                                ops2.add("1.5.1/ Search doctor by name.");
                                ops2.add("1.5.2/ Search department by ID.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                    switch (subMenuChoice2){
                                        case 1:
                                            manager.searchDocName();
                                            break;
                                        case 2:
                                            manager.searchDepID();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                            }
                            case 6:{
                                ops2.clear();
                                ops2.add("1.6.1/ Store new doctor data.");
                                ops2.add("1.6.2/ store new department data.");
                                ops2.add("Others - Back to main menu.");
                                System.out.println();
                                do{
                                    subMenuChoice2 = menu.int_getChoice(ops2);
                                    switch (subMenuChoice2){
                                        case 1:
                                            manager.saveToFileDoc();
                                            break;
                                        case 2:
                                            manager.saveToFileDep();
                                            break;
                                        default:
                                            break;
                                    }
                                } while (subMenuChoice2 > 0 && subMenuChoice2 <= ops2.size());
                                break; 
                                }
                            }
                        }while (subMenuChoice > 0 && subMenuChoice <= ops1.size());
                        break;
                        }
                    
                    case 2:{
                        ops1.clear();
                        ops1.add("2.1/Show medical examination result.");
                        ops1.add("2.2/Add new patient and medical examination.");
                        ops1.add("2.3/Record medical examination.");
                        ops1.add("Others - Return.");
                        System.out.println();
                        do{
                            subMenuChoice = menu.int_getChoice(ops1);
                            switch(subMenuChoice){
                                case 1: 
                                    manager.showExaminationResult();
                                    break;
                                case 2:
                                    manager.addNewPatient();
                                    break;
                                case 3:
                                    manager.recordExamination();
                                    break;
                                default:
                                    break;
                            }
                        }while (subMenuChoice > 0 && subMenuChoice <= ops1.size());
                        break;
                    }
                }
        }while (mainMenuChoice > 0 && mainMenuChoice <= ops.size());
    }
}
