
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

    scanner.nextLine();
     // Main menu loop
    while (running) {
        // Display menu options
        System.out.println("\n===== MENU =====");
        System.out.println("1. Send Messages");
        System.out.println("2. Show recently sent messages");
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
                if (Message.returnTotalMessages() >= maxMessages) {
                    System.out.println("You have reached your message limit of "
                            + maxMessages + ".");
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
                    System.out.println("Invalid recipient number. Must start with '+' and be no more than 10 characters.");
                    break;
                }
                // Send/store/disregard message
                //calls SentMessage method
                String result = message.SentMessage(scanner);
                 // Display result
                System.out.println(result);

                break;

            case 2:
                
                System.out.println("\n--- COMMING SOON ---");
                
                break;
                // Exit program
            case 0:
                running = false;
                break;
                // Invalid menu option
            default:
                System.out.println("Invalid option. Please choose 1, 2, or 0.");
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
scanner.close();

System.out.println("Goodbye!");
  
     
    }
}
    
