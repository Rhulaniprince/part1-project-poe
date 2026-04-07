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
    
       return username.contains("_") && username.length()<= 5;
       
    }
     public boolean checkPasswordComplexity(String password ){
     
        return password.length() >= 8 
                && password.matches(".*[A-Z].*") 
                && password.matches(".*[a-z].*") 
                && password.matches(".*[0-9].*")
                && password.matches(".*[!@#$%^&*()_{}:<>?';].*");
     }
     public boolean checkCellPhoneNumber(String phoneNumber){
          String valid = "(\\+27|0)[1-8][0-9]{8}$";
          return phoneNumber.matches(valid);
          
     }
     public String registerUser(String username ,String password, String phoneNumber){
        if (checkUserName(username)!= true){
           return"The username is incorrectly formatterd PLEASE ENSURE YOUR USERNAME CONTAINS AN UNDERSCORE AND IS NO MORE THAN FIVE CHARACTERS LONG! ";
        }
        else if (checkPasswordComplexity(password)!= true){
            return"Password is not correctly formatted! PLEASE ENSURE THAT THE PASSWORD CONTAINS AT LEAST EIGHT CHARACTERS,A CAPITAL LETTER,A NUMBER AND A SPECIAL CHARACTER ";
        }else if (!checkCellPhoneNumber(phoneNumber)){
            return "Phone number incorrectly formatted!";}
        else {
            this.Storeusrname = username;
            this.Storeusrpassword = password;
            this.StorePhoneNumber = phoneNumber;
            return"USERNAME AND PASSWORD SUCCESSFULLY CAPTURED ";
        }
         
     
     
     }
     public boolean loginUser(String inputUserName, String inputpassword , String phoneNumber  ){
        return Storeusrname.equals(inputUserName) 
               && Storeusrpassword.equals(inputpassword) 
               && StorePhoneNumber.equals(phoneNumber);
         
        
     }
     public String returnLogingStatus(String inputUserName ,String inputpassword ,String phoneNumber){
         
        if (loginUser(inputUserName,inputpassword,phoneNumber) ){
           return "SUCCESSFULLY LOGED IN.";
        }else{
            
          return "Failed Login! try again.";
        }
        
        
        
    }
}
