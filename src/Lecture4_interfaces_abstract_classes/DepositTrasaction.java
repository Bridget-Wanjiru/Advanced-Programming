package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * DepositTransaction Class
 * Description: Represents a deposit transaction in the banking system.
 * It extends the BaseTransaction class to provide functionality for handling monetary deposits.

 * Key Features:
 * - Tracks and applies deposit transactions to bank accounts.
 * - Validates deposit amounts to ensure only positive values are processed.
 * - Provides detailed transaction information.

 * Inherits:
 * - BaseTransaction
 *
 * @errorHandling:
 * - Prevents processing of invalid deposit amounts (zero or negative).
 * - Provides feedback on successful or failed transactions.
 *
 * @author Bridget Wanjiru

 */

public class DepositTrasaction extends BaseTransaction {
    /**
     * Constructor for DepositTransaction.
     * Initializes a deposit transaction with a specified amount and date.
     *
     * @param amount - The amount to deposit (must be positive).
     * @param date - The date of the transaction (must be a valid, non-null Calendar object).
     * @throws IllegalArgumentException if amount is negative or date is null.
     * @pre Amount must be a positive integer. Date must be a valid Calendar object.
     * @post The transaction is initialized with the specified amount and date.
     */

    public DepositTrasaction(int amount, @NotNull Calendar date){
        super(amount, date);

    }

    /**
     * Validates the deposit transaction amount.
     *
     * @param amt - The deposit amount to validate.
     * @return boolean - Returns true if the amount is strictly greater than 0, false otherwise.
     * @pre None.
     * @post Returns true for valid deposit amounts and false for invalid amounts.

     * Example:
     * - Input: 500
     * - Output: true
     */

    private boolean checkDepositAmount(double amt){
        return amt > 0;
    }

    /**
     * Prints the details of the deposit transaction.
     *
     * @pre None.
     * @post Prints transaction details to the console, including amount, date, and transaction ID.

     * Example:
     * - Input: None
     * - Output:
     *   Deposit Transaction Details:
     *   Amount: 500
     *   Date: Mon Jan 01 12:00:00 EAT 2024
     *   Transaction ID: TX-12345678
     */

    @Override
    public void printTransactionDetails(){

        System.out.println("Deposit Transaction Details: ");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }
/**
 * Applies the deposit transaction to a specified bank account.
 *
 * @param ba - The BankAccount object to apply the deposit to.
 * @pre The bank account must be valid, and the deposit amount must be positive.
 * @post The bank account balance is increased if the deposit is valid. Otherwise, no changes are made.

 * Example:
 * - Input: BankAccount with balance 1000, deposit amount 500.
 * - Output:
 *   Deposit of 500 applied.New Balance: 1500
 */
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