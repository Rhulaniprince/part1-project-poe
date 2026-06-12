/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.quick_chat;

import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhula
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
   
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "Rhu_l";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkPasswordComplexity method, of class login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "06Rhul@ninkuna";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of checkCellPhoneNumber method, of class login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String phoneNumber = "+27655802731";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registerUser method, of class login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "Rhu_l";
        String password = "06Rhul@ninkuna";
        String phoneNumber = "+27655802731";
        Scanner scanner = new Scanner(System.in);
        String firstname = "Rhulani";
        String secondname = "Nkuna";
        Login instance = new Login();
        String expResult = "USERNAME AND PASSWORD SUCCESSFULLY CAPTURED";
        String result = instance.registerUser(username, password, phoneNumber, scanner, firstname, secondname);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of loginUser method, of class login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String inputUserName = "Rhu_l";
        String inputpassword = "06Rhul@ninkuna";
        Login instance = new Login();
        instance.Storeusrname = "Rhu_l";
        instance.Storeusrpassword = "06Rhul@ninkuna";
        boolean expResult = true;
        boolean result = instance.loginUser(inputUserName, inputpassword);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnLogingStatus method, of class login.
     */
    @Test
    public void testReturnLogingStatus() {
        System.out.println("returnLogingStatus");
        String inputUserName = "Rhu_l";
        String inputpassword = "06Rhul@ninkuna";
        String firstname = "Rhulani";
        String secondname = "Nkuna";
        Login instance = new Login();
        instance.Storeusrname = "Rhu_l";
        instance.Storeusrpassword = "06Rhul@ninkuna";
        instance.firstName = "Rhulani";
        instance.LastName = "Nkuna";
        String expResult = "SUCCESSFULLY LOGED IN."+"\n"+"Welcom "+firstname+" "+secondname+" it is great to see you.";
        String result = instance.returnLogingStatus(inputUserName, inputpassword);
        assertEquals(expResult, result);
       
    }
    
}