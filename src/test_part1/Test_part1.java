
package test_part1;
import java.util.Scanner;

public class Test_part1 {
  
    public static void main(String[] args) {
         Scanner scanner =new Scanner(System.in);
        login login =new login();
        
        
        //prompts the user to creates and stores the username
        System.out.println("Create user name ");
        String username=scanner.nextLine();
        
        
        //prompts the user to creates and stores the password
        System.out.println("Create user password");
        String password=scanner.nextLine();
        
        System.out.println("Enter phone number:");
        String phone=scanner.nextLine();
        
        
        System.out.println(login.registerUser(username, password, phone, scanner));
    
        
        System.out.println("Login username:");
        String inputUsername = scanner.nextLine();

        System.out.println("Login password:");
        String inputPassword = scanner.nextLine();

        System.out.println("Login phone number:");
        String inputPhone = scanner.nextLine();
    
        System.out.println(login.returnLogingStatus(inputUsername, inputPassword, inputPhone));
    }
}
    