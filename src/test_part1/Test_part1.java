/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test_part1;
import java.util.Scanner;
/**
 *
 * @author Rhula
 */
public class Test_part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        
        String Storeusrname;
        String Storeusrpassword;
        String Inputusrname;
        String Inputusrpassword;
        
        System.out.println("Create user name ");
        Storeusrname=scanner.nextLine();
        
        System.out.println("Create user password");
        Storeusrpassword=scanner.nextLine();
        
         System.out.println("Input user name ");
        Inputusrname=scanner.nextLine();
        
        System.out.println("Input password");
       Inputusrpassword=scanner.nextLine();
       
       
       if(Storeusrname.equals(Inputusrname)&&Storeusrpassword.equals( Inputusrpassword)){
           
           System.out.println("Succesfuly loged in");
        
    
    }
       else {
           System.out.println("Password and user name are incorrect!");
       }}
    
}
