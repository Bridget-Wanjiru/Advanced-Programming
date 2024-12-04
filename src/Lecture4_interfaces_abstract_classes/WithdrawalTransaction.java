package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * ADT Specification for WithdrawalTransaction
 *
 * Type of Data:
 * - Represents a withdrawal transaction in a banking system.
 * - Extends BaseTransaction.
 * - Tracks transaction details including amount, date, and transaction ID.
 *
 * Core Operations:
 * 1. Constructor:
 *    - Creates a new withdrawal transaction.
 *    - Preconditions:
 *      * Amount must be a positive integer.
 *      * Date must be a valid Calendar object.
 *    - Postconditions:
 *      * Transaction is initialized with specified amount and date.
 *
 * 2. apply(BankAccount ba):
 *    - Applies the fee based withdrawal to a bank account.
 *    - Preconditions:
 *      * Bank account must be a valid BankAccount object.
 *      * Withdrawal amount must be positive.
 *    - Postconditions:
 *      * Bank account balance is updated based on withdrawal scenario.
 *      * Appropriate message is printed to console.

 * 3. reverse(BankAccount ba):
 *    - Reverses a previously applied withdrawal transaction.
 *    - Preconditions:
 *      * Bank account must be a valid BankAccount object.
 *      * Transaction must have been previously applied.
 *    - Postconditions:
 *      * Bank account balance is restored to previous state.
 *      * Reversal message is printed to console.
 *      * Returns true to indicate successful reversal.

 * 4. printTransactionDetails():
 *    - Prints detailed information about the transaction.
 *    - Preconditions: None.
 *    - Postconditions:
 *      * Transaction details printed to console.
 *      * No changes made to transaction or account state.

 * 5. checkDepositAmount(double amt):
 *    - Validates the transaction amount.
 *    - Preconditions: None.
 *    - Postconditions:
 *      * Returns true if amount is greater than 0.
 *      * Returns false otherwise.

 * Error Handling:
 * - Handles insufficient funds scenarios.
 * - Provides fee-based withdrawal options.
 */
public class WithdrawalTransaction extends BaseTransaction {
    private boolean isApplied = false;  // Flag to track if the withdrawal was applied

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(double amt) {
        return amt > 0;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction Details:");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    // Apply withdrawal to bank account (with fee)
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        double transactionFee = 2;  // Example fee per withdrawal

        // Check if the account has enough funds, including the transaction fee
        if (curr_balance >= getAmount() + transactionFee) {
            ba.setBalance(curr_balance - getAmount() - transactionFee);  // Deduct the withdrawal and fee
            isApplied = true;  // Mark withdrawal as successful
            System.out.println("Withdrawal of " + getAmount() + " applied. Fee of " + transactionFee + " deducted. New Balance: " + ba.getBalance());
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
    }

    // Apply withdrawal with exception handling
    public void applyWithExceptionHandling(BankAccount ba) {
        try {
            apply(ba);  // Attempt to apply withdrawal
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt to apply withdrawal completed.");
        }
    }

    // Reverse the withdrawal (only if it was successfully applied)
    public boolean reverse(BankAccount ba) {
        if (isApplied) {  // Only reverse if the withdrawal was applied
            ba.setBalance(ba.getBalance() + getAmount());  // Add the withdrawn amount back to the balance
            System.out.println("Withdrawal of " + getAmount() + " reversed. New Balance: " + ba.getBalance());
            return true;  // Reversal successful
        } else {
            System.out.println("No successful withdrawal to reverse.");
            return false;  // No reversal
        }
    }
}
