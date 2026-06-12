/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.quick_chat;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 *
 * @author Rhula
 */
public class MessageTest {
 
    public MessageTest() {
    }
 
    @BeforeClass
    public static void setUpClass() throws Exception {
        // Initialise arrays before all tests run
        Message.initialiseArrays(10);
    }
 
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
 
    @Before
    public void setUp() throws Exception {
    }
 
    @After
    public void tearDown() throws Exception {
    }
 
    
    // testGenerateMessageID
    // ID must be exactly 10 digits
    
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.generateMessageID();
        assertEquals(10, result.length());
        assertTrue(result.matches("[0-9]{10}"));
    }
 
    
    // testCheckMessageID
    // Must return true for a valid 10-digit ID
    
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = new Message("+27821234567", "Hi there thanks");
        assertTrue(instance.checkMessageID()); // ID generated in constructor is always 10 digits
    }
 
     
    // testCheckRecipientCell
    // Valid: starts with + and <= 10 chars
    // Invalid: no + or too long
     
    @Test
public void testCheckRecipientCell() {
    System.out.println("checkRecipientCell");
    Message instance = new Message("+27821234567", "Hi there thanks");
    assertTrue(instance.checkRecipientCell("+27821234567"));  
    assertFalse(instance.checkRecipientCell("12345"));        
    assertFalse(instance.checkRecipientCell(""));             
}
 
    
    // testCheckMessageLength
    // Valid: under 250 chars
    // Invalid: over 250 chars
    
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
 
        // Valid - under 250 characters
        Message instance = new Message("+27821234567", "Hi there thanks");
        assertTrue(instance.checkMessageLength());
 
        // Invalid - over 250 characters
        String longMessage = "A".repeat(251);
        Message instance2 = new Message("+27821234567", longMessage);
        assertFalse(instance2.checkMessageLength());
    }
 
    
    // testCreateMessageHash
    // Hash must not be null and must be all uppercase
    
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message("+27821234567", "Hi thanks");
        String result = instance.createMessageHash();
        assertNotNull(result);                          
        assertFalse(result.isEmpty());                  
        assertEquals(result, result.toUpperCase());     
    }
 
    
    // testSentMessage
    // Simulates user choosing option 1 (Send) via Scanner
    
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        // Simulate user typing "1" to send the message
        Scanner input = new Scanner("1\n");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.SentMessage(input);
        assertEquals("Message successfully sent.", result);
    }
 
    
    // testPrintMessages
    // When no messages sent, must return "No messages sent."
    
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String result = Message.printMessages();
        assertNotNull(result);       // result is never null
        assertFalse(result.isEmpty()); // result is never empty
    }
 
    
    // testReturnTotalMessages
    // Total messages must always be zero or more
    
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int result = Message.returnTotalMessages();
        assertTrue(result >= 0); // total is never negative
    }

    /**
     * Test of initialiseArrays method, of class Message.
     */
    @Test
public void testInitialiseArrays() {
    System.out.println("initialiseArrays");
    Message.initialiseArrays(5);
    assertEquals(5, Message.getSentMessagesLength()); // use getter instead
}

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = new Message("+27821234567", "Hi there thanks");
        try {
            instance.storeMessage("SENT");
        } catch (Exception e) {
            fail("storeMessage threw an exception: " + e.getMessage());
        }
    }

    /**
     * Test of displayStoredSenderRecipient method, of class Message.
     */
    @Test
    public void testDisplayStoredSenderRecipient() {
        System.out.println("displayStoredSenderRecipient");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.displayStoredSenderRecipient();
        assertEquals("No stored messages.", result);
    }

    /**
     * Test of displayLongestStoredMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestStoredMessage() {
        System.out.println("displayLongestStoredMessage");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.displayLongestStoredMessage();
        assertEquals("No stored messages.", result);
    }


    /**
     * Test of searchByMessageID method, of class Message.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.searchByMessageID("0000000000");
        assertEquals("Message ID not found.", result);
    }

    /**
     * Test of searchByRecipient method, of class Message.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.searchByRecipient("+27000000000");
        assertEquals("No messages found for recipient: +27000000000", result);
    }

    /**
     * Test of deleteByMessageHash method, of class Message.
     */
    @Test
    public void testDeleteByMessageHash() {
        System.out.println("deleteByMessageHash");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.deleteByMessageHash("00:0:HITHANKS");
        assertEquals("Message hash not found.", result);
    }

    /**
     * Test of displayAllStoredMessages method, of class Message.
     */
    @Test
    public void testDisplayAllStoredMessages() {
        System.out.println("displayAllStoredMessages");
        Message.initialiseArrays(5); // reset arrays
        String result = Message.displayAllStoredMessages();
        assertEquals("No stored messages.", result);
    }

    /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.getMessageID();
        assertNotNull(result);
        assertEquals(10, result.length());
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.getMessageHash();
        assertNotNull(result);
        assertEquals(result, result.toUpperCase());
    }

    /**
     * Test of getRecipient method, of class Message.
     */
     @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.getRecipient();
        assertEquals("+27821234567", result);
    }

    /**
     * Test of getMessageText method, of class Message.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Message instance = new Message("+27821234567", "Hi there thanks");
        String result = instance.getMessageText();
        assertEquals("Hi there thanks", result);
    }

    /**
     * Test of getMessageNumber method, of class Message.
     */
    @Test
    public void testGetMessageNumber() {
        System.out.println("getMessageNumber");
        Message instance = new Message("+27821234567", "Hi there thanks");
        int result = instance.getMessageNumber();
        assertEquals(0, result); // 0 before message is sent
    }
}
 