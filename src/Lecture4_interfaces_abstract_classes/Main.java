package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
/**
 * ADT Specification for MainClass
 * Description: The main method executes the program logic.
 * Demonstrates:
 * - Creating a BankAccount with an initial balance.
 * - Performing a deposit transaction.
 * - Performing a withdrawal transaction.
 * - Reversing a withdrawal transaction.
 */

public class Main {

    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 100
        BankAccount account = new BankAccount(1000);

        // Create a DepositTransaction
        Calendar depositDate = Calendar.getInstance();
        DepositTrasaction deposit = new DepositTrasaction(500, depositDate);

        // Print deposit transaction details
        deposit.printTransactionDetails();

        // Apply deposit to the account
        deposit.apply(account);
        System.out.println("Updated Account Balance after Deposit: " + account.getBalance());

        // Create a WithdrawalTransaction with an amount that exceeds the current balance (insufficient funds)
        Calendar withdrawalDate = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300, withdrawalDate); // Amount exceeds balance

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
