package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
/**
 * ADT Specification for  TransactionManager
 * Purpose: Provides utility methods related to transaction management, such as generating unique
 * transaction IDs based on the current timestamp.

 * Operations:
 * generateTransactionId()
 * Description: Generates a unique shortened transaction ID based on the current time in milliseconds.
 * Input: None.
 * Output: String — a shortened transaction ID with a "TX-" prefix.
 * Precondition: None.
 * Postcondition: A unique transaction ID is returned, formatted with a "TX-" prefix.
 */

public class TransactionManager {

    // Method to generate a unique shortened transaction ID from the current time
    public static String generateTransactionId() {
        Calendar calendar = Calendar.getInstance();
        long timestamp = calendar.getTimeInMillis();  // Get current time in milliseconds
        String shortenedId = String.valueOf(timestamp).substring(0, 8);  // Shorten to 8 characters
        return "TX-" + shortenedId;  // Prefix with "TX-" for clarity
    }
}