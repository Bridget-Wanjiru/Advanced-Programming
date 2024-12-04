package Lecture4_interfaces_abstract_classes;
import java.util.Calendar;

/**
 * ADT Specification for TransactionInterface

 * Type of Data:
 * - Defines a contract for transaction-related operations in a banking system
 * - Serves as a blueprint for implementing different types of financial transactions

 * Core Operations:
 * 1. getAmount():
 *    - Retrieves the monetary amount associated with the transaction
 *    - Preconditions: None
 *    - Postconditions:
 *      * Returns the transaction amount as a double-precision floating-point number
 *      * Does not modify the transaction state
 *    - Expected Behavior:
 *      * Must return a non-negative numeric value
 *      * Represents the absolute value of the transaction

 * 2. getDate():
 *    - Retrieves the date of the transaction
 *    - Preconditions: None
 *    - Postconditions:
 *      * Returns a Calendar object representing the transaction date
 *      * Does not modify the transaction state
 *    - Expected Behavior:
 *      * Must return a valid, non-null Calendar instance
 *      * Represents the exact timestamp of the transaction

 * 3. getTransactionID():
 *    - Retrieves a unique identifier for the transaction
 *    - Preconditions: None
 *    - Postconditions:
 *      * Returns a unique string identifier
 *      * Does not modify the transaction state
 *    - Expected Behavior:
 *      * Must return a non-null, unique identifier
 *      * Identifier should be consistent throughout the transaction lifecycle

 */

/**
 * Interface for Transactions
 * Any class that defines a transaction is expected to implement this Interface
 */
public interface TransactionInterface {

    // Method to get the transaction amount
    double getAmount();

    // Method to get the transaction date
    Calendar getDate();

    // Method to get a unique identifier for the transaction
    String getTransactionID();

}