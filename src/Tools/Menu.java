/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuAndOps;

/**
 *
 * @author Win
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public int int_getChoice(ArrayList options) throws ParseException {
        int response = 0;
        for (int i=0; i<options.size(); i++) {
            System.out.println((i+1) + "- " + options.get(i));   
        }
        System.out.print("Choose 1 ... " + (options.size() - 1) + ": ");
        Scanner sc = new Scanner(System.in);
        try{
        response = Integer.parseInt(sc.nextLine());
        } 
        catch (Exception e){
            response = 0;
        }
        return response;
    }
    
    public Object ref_getChoice(ArrayList options) throws ParseException {
        int response;
        int n;
        n = options.size();
       do{
           response = int_getChoice(options);
       }
       while (response<0 || response>n);
       return options.get(response-1);
    }

}
