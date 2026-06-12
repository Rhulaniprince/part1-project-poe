/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quick_chat;

import java.util.Scanner;

/**
 *
 * @author Rhula
 */
public class QUICK_CHAT {

    public static void main(String[] args) {
        
        Scanner scanner =new Scanner(System.in);
      
        Login login =new Login();
        
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

        
        
        System.out.println(login.returnLogingStatus(inputUsername, inputPassword));
        
// Check if login details are correct
if (login.loginUser(inputUsername, inputPassword)) {
      
   // Controls the menu loop 
      boolean running = true;

 // Welcome message
    System.out.println("\n--------------Welcome to QuickChat.--------------");
    
   // Ask user how many messages they want to send
    System.out.print("\nHow many messages do you want to send this session? ");
    
    int maxMessages = scanner.nextInt();
    
     // Validate message limit
    while (maxMessages <= 0) {
        System.out.print("Enter a number greater than 0: ");
        maxMessages = scanner.nextInt();
    }
    //Initializing the array size based on how many messages are sent or gonna be sent 
     Message.initialiseArrays(maxMessages+1);
     
    scanner.nextLine();
     // Main menu loop
    while (running) {
        // Display menu options
        System.out.println("\n===== MENU =====");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
        System.out.println("3  Stored messages");
        System.out.println("0. Quit");
        // User chooses menu option
        System.out.print("\nChoose option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
         // Menu selection
        switch (option) {
            // Send message option
            case 1:
                // Check if user reached message limit
                     if (Message.sentCount >= maxMessages ) {
                        System.out.println("You have reached your message limit of " + maxMessages + ".");
                    break;
                }
                // Ask for recipient number
                System.out.print("Enter recipient number: ");
                String recipient = scanner.nextLine();
                // Stores message text
                String messageText = "";
                // Controls message validation
                boolean validLength = false;
                // Controls message validation
                while (!validLength) {

                    System.out.print("Enter message (max 250 characters): ");
                    messageText = scanner.nextLine();
                     // Check if message is valid
                    if (messageText.length() <= 250) {
                        validLength = true;
                    } else {
                        System.out.println("Please enter a message of less than 250 characters.");
                    }
                }
                // Create Message object
                Message message = new Message(recipient, messageText);
                // Validate recipient cellphone number
                if (!message.checkRecipientCell(recipient)) {
                    System.out.println("Invalid recipient number. Must start with '+' or '0'and be no more than 10 characters.");
                    break;
                }
                // Send/store/disregard message
                //calls SentMessage method
                String result = message.SentMessage(scanner);
                 // Display result
                System.out.println(result);

                break;

            case 2:
                
                System.out.println(Message.printMessages());
                
                break;
                // Exit program
            case 3:
                boolean inStoredMenu = true;
                    while (inStoredMenu) {
                        System.out.println("\n===== STORED MESSAGES MENU =====");
                        System.out.println("a. Display sender and recipient of all stored messages");
                        System.out.println("b. Display the longest stored message");
                        System.out.println("c. Search for a message by ID");
                        System.out.println("d. Search messages by recipient");
                        System.out.println("e. Delete a message by hash");
                        System.out.println("f. Display full report of all stored messages");
                        System.out.println("g. Back to main menu");
                        System.out.print("Choose option: ");
 
                        String subOption = scanner.nextLine().trim().toLowerCase();
 
                        switch (subOption) {
                            case "a":
                                System.out.println(Message.displayStoredSenderRecipient());
                                break;
 
                            case "b":
                                System.out.println(Message.displayLongestStoredMessage());
                                break;
 
                            case "c":
                                System.out.print("Enter Message ID to search: ");
                                String searchID = scanner.nextLine();
                                System.out.println(Message.searchByMessageID(searchID));
                                break;
 
                            case "d":
                                System.out.print("Enter recipient number to search: ");
                                String searchRecipient = scanner.nextLine();
                                System.out.println(Message.searchByRecipient(searchRecipient));
                                break;
 
                            case "e":
                                System.out.print("Enter message hash to delete: ");
                                String hash = scanner.nextLine();
                                System.out.println(Message.deleteByMessageHash(hash));
                                break;
 
                            case "f":
                                System.out.println(Message.displayAllStoredMessages());
                                break;
 
                            case "g":
                                inStoredMenu = false;
                                break;
 
                            default:
                                System.out.println("Invalid option. Choose a to g.");
                        }
                    }
                    break;
            case 0:
                running = false;
                break;
                // Invalid menu option
            default:
                System.out.println("Invalid option. Please choose 1, 2,3 or 0.");
        }
    }
    // Display final summary
    System.out.println("\n========= Message Summary =========");
    System.out.println("Total messages sent: " + Message.returnTotalMessages());
    // Display all messages
    System.out.println("\n--- All Sent Messages ---");
    System.out.println(Message.printMessages());

} else {
    System.out.println("Login failed.");
}
// Close scanner
scanner.close();

System.out.println("Goodbye!");
    }
}