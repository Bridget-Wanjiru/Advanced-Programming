package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
/**
 * TransactionManager Class
 * Description: Provides utility methods for managing transactions, including the generation of unique transaction IDs.

 * Key Features:
 * - Generates unique, shortened transaction IDs based on the current timestamp.
 *
 * @author Bridget Wanjiru

 */
public class TransactionManager {

    /**
     * Generates a unique transaction ID based on the current timestamp.

     * @return String - A unique transaction ID prefixed with "TX-" and shortened to 8 characters for clarity.
     * @pre None.
     * @post A unique transaction ID is returned, formatted with a "TX-" prefix.

     * Example:
     * - Input: None
     * - Output: TX-12345678
     */
    public static String generateTransactionId() {
        Calendar calendar = Calendar.getInstance();
        long timestamp = calendar.getTimeInMillis();  // Get current time in milliseconds
        String shortenedId = String.valueOf(timestamp).substring(0, 8);  // Shorten to 8 characters
        return "TX-" + shortenedId;  // Prefix with "TX-" for clarity
    }
}