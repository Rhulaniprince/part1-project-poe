/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Message {
    // Creates object from Login class
    Login log = new Login();
   
    private static final String JSON_FILE = "messages.txt";
    // Variables for message details
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    private static Message[] sentMessages;
    private static Message[] disregardedMessages;
    private static Message[] storedMessages;
    private static String[] messageHashes;
    private static String[] messageIDs;
    
    public static int sentCount = 0;
    private static int disregardedCount = 0;
    private static int storedCount = 0;
    private static int hashCount = 0;
    private static int idCount = 0;
    
    // Keeps track of total sent messages
    private static int totalMessages = 0;
   
    
    public static void initialiseArrays(int maxMessages){
        
        sentMessages = new Message[maxMessages];
        disregardedMessages = new Message[100];
        storedMessages = new Message[100];
        messageHashes = new String[100];
        messageIDs = new String[100];
    }
    
    public Message(String recipient, String messageText) {
    this.recipient = recipient;
    this.messageText = messageText;
    this.messageID  = generateMessageID();
    this.messageHash = createMessageHash();
    }
     // Generates random 10-digit message ID
     public String generateMessageID(){
         
       Random random = new Random();
         long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
                  return messageID = String.valueOf(number);
         }
    // Checks if message ID is exactly 10 digits
    public boolean checkMessageID(){
        return messageID.length() == 10 ;
    
    }
     // Validates recipient cellphone number
    public boolean checkRecipientCell( String RecipientCell ){
    
    boolean valid = log.checkCellPhoneNumber(RecipientCell);
    
    return valid;

      }
    // Checks if message is less than or equal to 250 characters
    public boolean checkMessageLength() {

        if (messageText.length() <= 250) {
            return true;
        }else{

        return false;
        }
    }
     // Creates message hash
    public String createMessageHash(){
        // Gets first 2 digits of message ID
        String firstTwoDigits = messageID.substring(0,2);
        // Splits message into words
        String[] words = messageText.split(" ");
         // Gets first and last word
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
         // Returns hash in uppercase
        return (firstTwoDigits + ":" +
                messageNumber + ":" +
                firstWord + lastWord).toUpperCase();
    }
     // Handles sending/storing/disregarding messages
    public String SentMessage(Scanner input){
        
      // Validate message length
      if (!checkMessageLength()) {
            return "Please enter a message of less than 250 characters.";
        }
            // Validate recipient number 
      if (!checkRecipientCell(this.recipient)) {
            return "Invalid recipient number. Must start with '+' and be no more than 10 characters.";
        }
        // Display message options
        System.out.println("\nChoose an option:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message to send later");
        System.out.print("Choice: ");
        
        int choice = input.nextInt();
        input.nextLine();
        
        switch (choice) {
            // Send message
            case 1:
                if (sentCount >= sentMessages.length) {
                 return "You have reached your message limit.";}
                  // Increase total messages count
                 totalMessages++;
                 // Assign message number
                 this.messageNumber = totalMessages;
                 this.messageHash = createMessageHash();
                 sentMessages[sentCount++] = this;
                 messageHashes[hashCount++] = this.messageHash;
                 messageIDs[idCount++] = this.messageID;
                 storeMessage("SENT");
                 return "Message successfully sent.";
                
                // Disregard message  
            case 2:
                 // populate disregarded array
                 disregardedMessages[disregardedCount++] = this;
                return "Message has been deleted.";
                
                 // Store message for later
            case 3:
                // populate stored array
                storedMessages[storedCount++] = this;
                storeMessage("STORED");
                // populate hash array
                messageHashes[hashCount++] = this.messageHash;
                // populate messageID array
                messageIDs[idCount++] = this.messageID;; 
                return "Message successfully stored.";
                
            // Invalid option
            default:
                return "Invalid option.";   
        }
    }
     // Displays all sent messages
    public static String printMessages(){
         // Check if  messages exist
        if (sentCount == 0) {
        return "No messages sent.";
    }

    StringBuilder sb = new StringBuilder();
     // Loop through all messages
    for (int i = 0; i < sentCount; i++) {         // Message not String
        sb.append("Message ID:   ").append(sentMessages[i].messageID).append("\n");
        sb.append("Message Hash: ").append(sentMessages[i].messageHash).append("\n");
        sb.append("Recipient:    ").append(sentMessages[i].recipient).append("\n");
        sb.append("Message:      ").append(sentMessages[i].messageText).append("\n");
        sb.append("-----------------------------------\n");
    }
    return sb.toString();
    }
     // Returns total number of messages sent
    public static int returnTotalMessages(){
       
        return totalMessages;
       
    }
     // Stores messages inside messages.json file
    public void storeMessage(String status) {

    try {FileWriter writer = new FileWriter(JSON_FILE, true);

        writer.write(
                 "Message ID:   " + messageID   + "\n" +
                    "Message Hash: " + messageHash + "\n" +
                    "Recipient:    " + recipient   + "\n" +
                    "Message:      " + messageText + "\n" +
                "\n\n"
        );

        writer.close();
        System.out.println("Message successfully stored.");
    }
    catch (IOException e) {

        System.out.println("Error writing to file.");
    }
}
    // Display sender and recipient of all stored messages
    public static String displayStoredSenderRecipient() {
        if (storedCount == 0) {
            return "No stored messages.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--- Stored Messages: Sender & Recipient ---\n");
       for (int i = 0; i < storedCount; i++) {
            sb.append("Recipient: ").append(storedMessages[i].recipient).append("\n");
            sb.append("Message:   ").append(storedMessages[i].messageText).append("\n");
            sb.append("-----------------------------------\n");
        }
        return sb.toString();
    }
    
    // Display the longest stored message
    public static String displayLongestStoredMessage() {
        if (storedCount == 0) {
            return "No stored messages.";
        }
        Message longest = storedMessages[0];
        for (int i = 1; i < storedCount; i++) {
            if (storedMessages[i].messageText.length() > longest.messageText.length()) {
                longest = storedMessages[i];

            }
        }
        return "Longest stored message:\n" +
               "Recipient: " + longest.recipient + "\n" +
               "Message:   " + longest.messageText + "\n";
    }
 
    // Search for a message by ID and display recipient and message
    public static String searchByMessageID(String searchID) {
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].messageID.equals(searchID)) {
                return "Message found:\n" +
                       "Recipient: " + storedMessages[i].recipient + "\n" +
                       "Message:   " + storedMessages[i].messageText + "\n";
            }
        }
        return "Message ID not found.";
    }
 
    // d. Search for all messages stored for a particular recipient
    public static String searchByRecipient(String searchRecipient) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].recipient.equals(searchRecipient)) {
                sb.append("Message ID: ").append(storedMessages[i].messageID).append("\n");
                sb.append("Message:    ").append(storedMessages[i].messageText).append("\n");
                sb.append("-----------------------------------\n");
            }
        }
        if (sb.length() == 0) {
            return "No messages found for recipient: " + searchRecipient;
        }
        return sb.toString();
    }
 
    //Delete a message using the message hash
    public static String deleteByMessageHash(String hash) {
        for (int i = 0; i < storedCount; i++) {
            if (storedMessages[i].messageHash.equalsIgnoreCase(hash)) {
                // Shift remaining elements left to fill the gap
                for (int j = i; j < storedCount - 1; j++) {
                    storedMessages[j] = storedMessages[j + 1];
                }
                storedMessages[--storedCount] = null; // clear last slot
                return "Message successfully deleted.";
            }
        }
        return "Message hash not found.";
    }
 
    //Display full details of all stored messages
    public static String displayAllStoredMessages() {
        if (storedCount == 0) {
            return "No stored messages.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--- Full Report: All Stored Messages ---\n");
        for (int i = 0; i < storedCount; i++) {
            sb.append("Message ID:   ").append(storedMessages[i].messageID).append("\n");
            sb.append("Message Hash: ").append(storedMessages[i].messageHash).append("\n");
            sb.append("Recipient:    ").append(storedMessages[i].recipient).append("\n");
            sb.append("Message:      ").append(storedMessages[i].messageText).append("\n");
            sb.append("-----------------------------------\n");
        }
        return sb.toString();
    }
 
    // ----------------------------------------------------------------
    // Getters
    // ----------------------------------------------------------------
    public String getMessageID(){ return messageID;}
    public String getMessageHash(){ return messageHash;}
    public String getRecipient(){ return recipient;}
    public String getMessageText(){ return messageText;}
    public int    getMessageNumber(){ return messageNumber;}
    
    public static int getSentMessagesLength() {
    return sentMessages.length;
}

}
 
    

