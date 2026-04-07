/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_part1;

/**
 *
 * @author Rhula
 */
public class login {
    
    String Storeusrname;
    String Storeusrpassword;
    String StorePhoneNumber;
    
    public boolean checkUserName(String username){
    
       return Storeusrname.contains("_") && Storeusrname.length()==5;
       
    }
     public boolean checkPasswordComplexity(String password ){
     
        return Storeusrpassword.length() >= 8 
                && Storeusrpassword.matches(".*[A-Z].*") 
                && Storeusrpassword.matches(".*[a-z].*") 
                && Storeusrpassword.matches(".*[0-9].*")
                && Storeusrpassword.matches(".*[!@#$%^&*()_{}:<>?';].*");
     }
     public boolean checkCellPhoneNumber(String phoneNumber){
          String valid = "^$|(\\+27|0)[1-8][0-9]{8}$";
          return phoneNumber.matches(valid);
          
     }
     public String registerUser(String username ,String password){
        if (checkUserName(username)!= true){
            System.out.println("The username is incorrectly formatterd");
            System.out.println("PLEASE ENSURE YOUR USERNAME CONTAINS AN UNDERSCORE AND IS NO MORE THAN FIVE CHARACTERS LONG! ");
        }
        else if (checkPasswordComplexity(password)!= true){
            System.out.println("Password is not correctly formatted!");
            System.out.println("PLEASE ENSURE THAT THE PASSWORD CONTAINS AT LEAST EIGHT CHARACTERS,A CAPITAL LETTER,A NUMBER AND A SPECIAL CHARACTER ");
        }
        else {
            this.Storeusrname = username;
            this.Storeusrpassword = password;
            System.out.println("USERNAME AND PASSWORD SUCCESSFULLY CAPTURED ");
        }
        return null;
     
     
     }
     public boolean loginUser(String inputUserName, String inputpassword , String phoneNumber  ){
        return Storeusrname.matches(inputUserName) 
               && Storeusrpassword.matches(inputpassword) 
               && StorePhoneNumber.equals(phoneNumber);
         
        
     }
     public String returnLogingStatus(String inputUserName ,String inputpassword ,String phoneNumber){
         
        if (loginUser(inputUserName,inputpassword,phoneNumber) ){
            System.out.println("SUCCESSFULLY LOGED IN.");
        }else{
            System.out.println("Failed Login! try again.");
        }
        return null;
    }
}
