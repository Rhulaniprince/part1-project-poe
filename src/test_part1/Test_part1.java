
package test_part1;
import java.util.Scanner;

public class Test_part1 {
  
    public static void main(String[] args) {
         Scanner scanner =new Scanner(System.in);
        login login =new login();
        
        System.out.println("=========Register========");
        //prompts the user to input their first Name
        System.out.println("Enter you firstname");
        String firstname= scanner.nextLine();
        
        //prompts the user to input their last Name
        System.out.println("Enter lastname");
        String lastname= scanner.nextLine();
        
        
        //prompts the user to creates  the username
        System.out.println("Create user name "+
                "\n"+ "USERNAME MUST CONTAINS  AN UNDERSCORE AND IS NO MORE THAN FIVE CHARACTERS LONG! ");
        String username=scanner.nextLine();
        
        
        //prompts the user to creates the password
        System.out.println("Create user password"+
                "\nPASSWORD MUST CONTAINS AT LEAST EIGHT CHARACTERS,A CAPITAL LETTER,A NUMBER AND A SPECIAL CHARACTER ");
        String password=scanner.nextLine();
        
        //prompts the user to input their Phone Number 
        System.out.println("Enter phone number:");
        String phone=scanner.nextLine();
        
        
        System.out.println(login.registerUser(username, password, phone, scanner, firstname,lastname));
    
        System.out.println("========Login========");
        
        //prompts the user to input the user name they created
        System.out.println("Enter username:");
        String inputUsername = scanner.nextLine();
        
        //prompts the user to input the Password they created
        System.out.println("Enter password:");
        String inputPassword = scanner.nextLine();

        
        
        System.out.println(login.returnLogingStatus(inputUsername, inputPassword, firstname, lastname));
        
        scanner.close();
    }
}
    
