/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chat;

import java.util.Scanner;

/**
 *
 * @author Rhula
 */
public class Login {
       //this  store the user's registered information
    String Storeusrname;
    String Storeusrpassword;
    String StorePhoneNumber;
    String firstName;
    String LastName;
    
    //Checks if the username is valid
    //Username must contain an underscore and be no more than 5 characters to be valid 
    public boolean checkUserName(String username){
    
       return username.contains("_") && username.length()<= 5;
       
    }
    
    
    //Checks if the password meets complexity requirements
    //Password must be at least 8 characters and contain uppercase,lowercase, a number and a special character to be valid
     public boolean checkPasswordComplexity(String password ){
     
        return password.length() >= 8 
                && password.matches(".*[A-Z].*") 
                && password.matches(".*[a-z].*") 
                && password.matches(".*[0-9].*")
                && password.matches(".*[!@#$%^&*()_{}:<>?';].*");
     }
     
     
     //Checks if the phone number is a valid South African number
     //Must start with +27 or 0, followed by a digit 1-8, then 8 more digits to be valid 
     public boolean checkCellPhoneNumber(String phoneNumber){
         // Regex pattern for valid SA phone numbers
          String valid = "(\\+27|0)[1-8][0-9]{8}$";
          return phoneNumber.matches(valid);
          
     }
     
     //Registers a new user by validating and storing their details
     //Keeps prompting the user until all inputs are valid
     //it call other methods to validate the details
     public String registerUser(String username ,String password, String phoneNumber,Scanner scanner,String firstname,String secondname){
        
         
        // Keep asking until user inputs the correctly formated user name 
         while(!checkUserName(username)){
             System.out.println("The username is incorrectly formatterd PLEASE ENSURE YOUR USERNAME CONTAINS AN UNDERSCORE AND IS NO MORE THAN FIVE CHARACTERS LONG! ");
             System.out.println("TRY AGAIN!!"+" username: ");
             username = scanner.nextLine();
            
         }
         // Keep asking until user inputs the correctly formated password  
        while(!checkPasswordComplexity(password)){
             System.out.println("Password is not correctly formatted! PLEASE ENSURE THAT THE PASSWORD CONTAINS AT LEAST EIGHT CHARACTERS,A CAPITAL LETTER,A NUMBER AND A SPECIAL CHARACTER ");
              System.out.print("Re-enter password: ");
            password = scanner.nextLine();
            
        } 
        
        // Keep asking until user inputs the correctly formated password 
        while(!checkCellPhoneNumber(phoneNumber)){
            System.out.println("Phone number incorrectly formatted!");
            System.out.print("Re-enter phone number: ");
            phoneNumber = scanner.nextLine();
            
            
         }
         // Stores all valid detail
            this.Storeusrname = username;
            this.Storeusrpassword = password;
            this.StorePhoneNumber = phoneNumber;
            this.firstName = firstname;
            this.LastName = secondname;
            return"USERNAME AND PASSWORD SUCCESSFULLY CAPTURED";
        }
         
     
     
     //Checks if the entered username and password match the stored details for the username and password
     public boolean loginUser(String inputUserName, String inputpassword){
        return Storeusrname.equals(inputUserName) 
               && Storeusrpassword.equals(inputpassword);
         
        
     }
     //outputs a message if the entered username and password match the stored details and if they are not correct 
     public String returnLogingStatus(String inputUserName ,String inputpassword){
         
        // Check if the details match the stored details
        if (loginUser(inputUserName,inputpassword)&& firstName.contains(firstName)&& LastName.contains(LastName) ){
           return "SUCCESSFULLY LOGED IN."+"\n"+"Welcom "+firstName+" "+LastName+" it is great to see you.";
           
        }else{
            
          return "Failed Login! try again.";
          
        }
        
        
    
    }
    
}
