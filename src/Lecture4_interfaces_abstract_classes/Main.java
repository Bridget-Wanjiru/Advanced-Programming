package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
/**
 * Main Class
 * Description: The main entry point of the program, demonstrating the functionality
 * of the transaction system by creating a bank account and performing various financial transactions.

 * Demonstrates:
 * - Creating a BankAccount with an initial balance.
 * - Performing a deposit transaction.
 * - Performing a withdrawal transaction.
 * - Reversing a withdrawal transaction.
 *
 * @author Bridget Wanjiru

 */

public class Main {

    /**
     * Main method
     * Description: Executes the program logic and demonstrates the functionality of deposit and withdrawal
     * transactions along with their effects on a BankAccount.
     *
     * @param args - Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create a DepositTransaction
        Calendar depositDate = Calendar.getInstance();
        DepositTrasaction deposit = new DepositTrasaction(500, depositDate);

        /*
         * Apply deposit to the account.
         * @see DepositTrasaction#apply(BankAccount)
         * @see DepositTrasaction#printTransactionDetails()
         */

        // Print deposit transaction details
        deposit.printTransactionDetails();

        // Apply deposit to the account
        deposit.apply(account);
        System.out.println("Updated Account Balance after Deposit: " + account.getBalance());

        // Create a WithdrawalTransaction with an amount that exceeds the current balance (insufficient funds)
        Calendar withdrawalDate = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300, withdrawalDate); // Amount exceeds balance

        /*
         * Perform withdrawal and reverse if possible.
         * @throws InsufficientFundsException when withdrawal amount exceeds the account balance.
         * @see WithdrawalTransaction#applyWithExceptionHandling(BankAccount)
         * @see WithdrawalTransaction#reverse(BankAccount)
         */

        // Print withdrawal transaction details
        withdrawal.printTransactionDetails();

        // Use the applyWithExceptionHandling method for withdrawal
        withdrawal.applyWithExceptionHandling(account);  // This method already handles the exception internally

        // Check if the withdrawal was successful and reverse if necessary
        if (withdrawal.reverse(account)) {
            System.out.println("Account Balance after Reversal: " + account.getBalance());
        } else {
            System.out.println("No successful withdrawal to reverse.");
        }
    }
}
