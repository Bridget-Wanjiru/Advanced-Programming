package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * ADT Specification for DepositTransaction

 * Type of Data:
 * - Represents a deposit transaction in a banking system
 * - Extends BaseTransaction
 * - Tracks and applies monetary deposits to a bank account

 * Core Operations:
 * 1. Constructor:
 *    - Creates a new deposit transaction
 *    - Preconditions:
 *      * Amount must be a positive integer
 *      * Date must be a valid, non-null Calendar object
 *    - Postconditions:
 *      * Transaction is initialized with specified amount and date
 *      * Inherited BaseTransaction properties are set

 * 2. checkDepositAmount(double amt):
 *    - Validates the deposit transaction amount
 *    - Preconditions: None
 *    - Postconditions:
 *      * Returns true if amount is strictly greater than 0
 *      * Returns false for zero or negative amounts
 *    - Validation Criteria:
 *      * Ensures only positive deposit amounts are considered valid
 *      * Prevents processing of zero or negative deposits

 * 3. printTransactionDetails():
 *    - Displays comprehensive information about the deposit transaction
 *    - Preconditions: None
 *    - Postconditions:
 *      * Prints transaction details to console
 *      * Includes amount, date, and transaction ID
 *      * No changes made to transaction or account state

 * 4. apply(BankAccount ba):
 *    - Applies the deposit to a specified bank account
 *    - Preconditions:
 *      * Bank account must be a valid BankAccount object
 *      * Deposit amount must be positive
 *    - Postconditions:
 *      * If deposit is valid:
 *        - Bank account balance is increased by deposit amount
 *        - Confirmation message printed to console
 *      * If deposit is invalid:
 *        - No changes made to account balance
 *        - Error message printed to console
 *    - Transaction Processing:
 *      * Validates deposit amount before processing
 *      * Calculates and updates new account balance
 *      * Provides feedback on transaction outcome


 * Error Handling:
 * - Rejects zero or negative deposit amounts
 * - Prevents invalid deposit transactions
 * - Provides clear feedback on transaction status
  */

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(int amount, @NotNull Calendar date){
        super(amount, date);

    }

    // Method to check if the deposit amount is valid
    //The previous method in the original code included 0 as a valid deposit amount which is not usually the case in bank transactions
    //The method below modifies the validity of the transaction using a single code amt>0
    private boolean checkDepositAmount(double amt){
        return amt > 0;
    }

    // Method to print a transaction receipt or details
    // The changes made here from the initial toString() method is to improve readability of the output
    @Override
    public void printTransactionDetails(){

        System.out.println("Deposit Transaction Details: ");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    //Method to apply the deposit transaction to a bank account
    @Override
    public void apply(BankAccount ba){
        if (checkDepositAmount(getAmount())) {
            double curr_balance = ba.getBalance();
            double new_balance = curr_balance + getAmount();
            ba.setBalance(new_balance);
            System.out.println("Deposit of " + getAmount() + " applied. New Balance: " + ba.getBalance());
        } else {
            System.out.println("Invalid deposit amount: " + getAmount());
        }
    }
}