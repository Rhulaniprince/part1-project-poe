
package test_part1;
import java.util.Scanner;

public class Test_part1 {

  
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
       
       
       if(Storeusrname.equals(Inputusrname)&&Storeusrpassword.equals( Inputusrpassword) && checkuser(Storeusrname) &&checkuserpassword(Storeusrpassword)){
           
           System.out.println("Succesfuly loged in");
        
    
    }
       else {
           System.out.println("Password and user name are incorrect!");
       }
       
    }
    
    public static boolean checkuser(String Storeusrname){
    
        return Storeusrname.contains("_") && Storeusrname.length()==5;
     
       
    }
    
     public static boolean checkuserpassword(String Storeusrpassword ){
     
     if (Storeusrpassword.length() >= 8 && Storeusrpassword.matches(".*[A-Z].*") && Storeusrpassword.matches(".*[a-z].*") && Storeusrpassword.matches(".*[0-9].*")&& Storeusrpassword.matches(".*[!@#$%^&*()_{}:<>?';].*")) {
         return true;
     } else {
         return false;
     }
     }

}

