
package test_part1;
import java.util.Scanner;

public class Test_part1 {
  
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        //Stores the username and password 
        String Storeusrname;
        String Storeusrpassword;
        String Inputusrname;
        String Inputusrpassword;
        String phoneNumber;
        String StoreNumber;
        
        //prompts the user to creates and stores the username
        System.out.println("Create user name ");
        Storeusrname=scanner.nextLine();
        
        
        //prompts the user to creates and stores the password
        System.out.println("Create user password");
        Storeusrpassword=scanner.nextLine();
        
        System.out.println("Input users Phone Number  ");
        StoreNumber=scanner.nextLine();
        
        //prompts the user to input the username he/she created 
         System.out.println("Input user name ");
        Inputusrname=scanner.nextLine();
        
        //prompts the user to input the password he/she created 
        System.out.println("Input password");
       Inputusrpassword=scanner.nextLine();
       
       System.out.println("Input Phone Number");
       phoneNumber=scanner.nextLine();
       
       if(Storeusrname.equals(Inputusrname)&&Storeusrpassword.equals( Inputusrpassword) && checkuser(Storeusrname) &&checkuserpassword(Storeusrpassword)&&StoreNumber.equals(phoneNumber) && checkCellPhoneNumber(phoneNumber)){
           
           System.out.println("Succesfuly loged in");
    }
       else {
           System.out.println("Password and user name are incorrect!");
       }
       
    }
    
    static boolean checkuser(String Storeusrname){
    
        return Storeusrname.contains("_") && Storeusrname.length()==5;
     
       
    }
    
      static boolean checkuserpassword(String Storeusrpassword ){
     
     if (Storeusrpassword.length() >= 8 && Storeusrpassword.matches(".*[A-Z].*") 
             && Storeusrpassword.matches(".*[a-z].*") && Storeusrpassword.matches(".*[0-9].*")
             && Storeusrpassword.matches(".*[!@#$%^&*()_{}:<>?';].*")) {
         return true;
     } else {
         return false;
     }
     }
     
      static boolean checkCellPhoneNumber(String phoneNumber){
          String valid = "^$|(\\+27|0)[1-8][0-9]{8}$";
          return phoneNumber.matches(valid);
     }

}

