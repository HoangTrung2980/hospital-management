/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Win
 */
public class MyUtil {
    public static Scanner sc = new Scanner(System.in);
    
    public static Date inputDate(String msg) throws ParseException {
        Date data;
        do{
        System.out.print(msg);
        data = new SimpleDateFormat("dd/MM/yyyy").parse(msg);
        }while (data == null);
        return data;
    }
    
    public static String inputStr(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    
    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        }
        while(data.length()==0);
        return data;
    }
}
