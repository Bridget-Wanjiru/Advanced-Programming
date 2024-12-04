package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * ADT Specification for BaseTransaction

 * Core Operations:
 * getAmount()
 * Description: Retrieves the amount associated with the transaction.
 * Input: None.
 * Output: double — the transaction amount.
 * Precondition: None.
 * Postcondition: The transaction amount is returned.

 * getDate()
 * Description: Retrieves the date of the transaction.
 * Input: None.
 * Output: Calendar — the date of the transaction (a defensive copy).
 * Precondition: None.
 * Postcondition: A copy of the transaction date is returned.

 * getTransactionID()
 * Description: Retrieves the unique identifier for the transaction.
 * Input: None.
 * Output: String — the transaction ID.
 * Precondition: None.
 * Postcondition: The transaction ID is returned.

 * printTransactionDetails() (Abstract)
 * Description: Prints details of the transaction.
 * Input: None.
 * Output: None.
 * Precondition: Must be implemented by a concrete subclass.
 * Postcondition: Transaction details are printed.

 * apply(BankAccount ba) (Abstract)
 * Description: Applies the transaction to a given bank account.
 * Input: BankAccount ba — the bank account to which the transaction is applied.
 * Output: None.
 * Precondition: Must be implemented by a concrete subclass.
 * Postcondition: The transaction is applied to the bank account.
 **/

public abstract class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private String transactionID;


    public BaseTransaction(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        // Generate a shortened transaction ID using a simple format
        String baseID = String.valueOf(date.getTimeInMillis()); // Use the time in milliseconds for simplicity
        int uniq = (int) (Math.random() * 10000); // Random value for uniqueness
        transactionID = baseID.substring(0, 8) + "-" + uniq; // Shortened to the first 8 digits of the time and added random part
    }

    /**
     * getAmount()
     * @return integer
     */
    public double getAmount() {
        return amount; // Because we are dealing with Value types we need not worry about what we return
    }

    /**
     * getDate()
     * @return Calendar Object
     */
    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }

    // Method to get a unique identifier for the transaction
    public String getTransactionID(){

        return  transactionID;
    }
    // Method to print a transaction receipt or details
    public abstract void printTransactionDetails();
        public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}