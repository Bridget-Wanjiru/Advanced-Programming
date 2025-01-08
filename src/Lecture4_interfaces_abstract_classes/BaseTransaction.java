package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * BaseTransaction Class
 * Description: Represents an abstract base class for financial transactions.
 * Implements the TransactionInterface to provide basic functionality such as retrieving transaction details
 * (amount, date, and ID). This class serves as a foundation for specific transaction types like deposits and withdrawals.

 * Key Features:
 * - Provides common fields and methods for financial transactions.
 * - Ensures that subclasses implement specific behavior for transaction application and details printing.

 * Inherits:
 * - TransactionInterface

 * Abstract Methods:
 * - printTransactionDetails(): Prints transaction details (to be implemented by subclasses).
 * - apply(BankAccount ba): Applies the transaction to a bank account (to be implemented by subclasses).
 *
 * @errorHandling:
 * - Defensive copying is used for date fields to ensure immutability.
 * - Transaction ID is generated uniquely for each transaction.
 *
 * @author Bridget Wanjiru
 */

public abstract class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor for BaseTransaction.
     * Initializes a transaction with a specified amount and date, generating a unique transaction ID.
     *
     * @param amount - The transaction amount (must be positive).
     * @param date - The transaction date (must be a valid, non-null Calendar object).
     * @throws IllegalArgumentException if the amount is negative or the date is null.
     * @pre Amount must be positive, and date must be a valid Calendar object.
     * @post The transaction is initialized with the specified amount, date, and a unique ID.
     */

    public BaseTransaction(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();

        // Generate a shortened transaction ID using a simple format
        String baseID = String.valueOf(date.getTimeInMillis()); // Use the time in milliseconds for simplicity
        int uniq = (int) (Math.random() * 10000); // Random value for uniqueness
        transactionID = baseID.substring(0, 8) + "-" + uniq; // Shortened to the first 8 digits of the time and added random part
    }

    /**
     * Retrieves the transaction amount.
     *
     * @return double - The transaction amount.
     * @pre None.
     * @post Returns the transaction amount as a positive integer.

     * Example:
     * - Input: None
     * - Output: 500 (transaction amount)
     */

    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * Retrieves the transaction date.
     *
     * @return Calendar - A defensive copy of the transaction date.
     * @pre None.
     * @post Returns a copy of the transaction date to ensure immutability.

     * Example:
     * - Input: None
     * - Output: Calendar instance with transaction date.
     */

    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /*
     * Retrieves the unique transaction identifier.

     * @return String - The unique transaction ID.
     * @pre None.
     * @post Returns a unique string identifier for the transaction.

     * Example:
     * - Input: None
     * - Output: TX-12345678-9876 (unique transaction ID)
     */

    public String getTransactionID(){
        return  transactionID;
    }

     /**
     * Abstract method to print transaction details.
     * Subclasses must implement this method to provide specific details.
     *
     * @pre Must be implemented by subclasses.
     * @post Transaction details are printed to the console.
     */

    public abstract void printTransactionDetails();

    /**
     * Abstract method to apply the transaction to a bank account.
     * Subclasses must implement this method to define specific transaction behavior.
     *
     * @param ba - The BankAccount object to apply the transaction to.
     * @throws InsufficientFundsException if the transaction cannot be applied due to insufficient funds.
     * @pre Must be implemented by subclasses. BankAccount object must be valid.
     * @post The transaction is applied to the bank account.
     */
        public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}