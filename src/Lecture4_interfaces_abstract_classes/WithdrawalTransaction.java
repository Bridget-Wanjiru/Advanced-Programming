package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
/**
 * WithdrawalTransaction Class
 * Description: Represents a withdrawal transaction in the banking system, extending the functionality of BaseTransaction.
 * Provides methods to apply, reverse, and validate withdrawal transactions, with appropriate exception handling.

 * Inherits:
 * - BaseTransaction

 * Key Features:
 * - Applies withdrawal transactions with a transaction fee.
 * - Allows reversal of successful withdrawals.
 * - Handles insufficient funds scenarios.
 *
 * @author Bridget Wanjiru

 */

public class WithdrawalTransaction extends BaseTransaction {
    private boolean isApplied = false;  // Flag to track if the withdrawal was applied

    /**
     * WithdrawalTransaction Class
     * Description: Represents a withdrawal transaction in the banking system, extending the functionality of BaseTransaction.
     * Provides methods to apply, reverse, and validate withdrawal transactions, with appropriate exception handling.

     * Inherits:
     * - BaseTransaction

     * Key Features:
     * - Applies withdrawal transactions with a transaction fee.
     * - Allows reversal of successful withdrawals.
     * - Handles insufficient funds scenarios.
     *
     * @author Bridget Wanjiru

     */

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Validates the transaction amount.
     *
     * @param amt - The transaction amount to validate.
     * @return boolean - Returns true if the amount is greater than 0, false otherwise.
     */

    private boolean checkDepositAmount(double amt) {
        return amt > 0;
    }

    /**
     * Applies the withdrawal transaction to a bank account, deducting a transaction fee.
     *
     * @param - The BankAccount object to apply the transaction to.
     * @throws InsufficientFundsException if the account balance is insufficient for the withdrawal and fee.
     * @pre The BankAccount object must be valid, and the withdrawal amount must be positive.
     * @post The account balance is updated, and a confirmation message is printed to the console.
     */

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

    /**
     * Attempts to apply the withdrawal transaction with exception handling.
     *
     * @param ba - The BankAccount object to apply the transaction to.
     * @pre The BankAccount object must be valid.
     * @post The account balance is updated if successful, or an error message is printed if unsuccessful.
     */
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
