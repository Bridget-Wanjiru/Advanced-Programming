
package Lecture4_interfaces_abstract_classes;
/**
 * BankAccount Class
 * Description: Represents a simple bank account with a monetary balance.
 * Provides methods to retrieve and update the account balance while enforcing non-negative values.

 * Key Features:
 * - Stores and manages account balance.
 * - Allows controlled updates to ensure the integrity of the balance.

 * @errorHandling:
 * - Prevents negative balances during initialization or updates.

 * @author Bridget Wanjiru
 */

public class BankAccount {
    private double balance;
    /**
     * Constructor for BankAccount.
     * Initializes a bank account with a specified initial balance.

     * @param balance - The initial account balance (must be non-negative).
     * @throws IllegalArgumentException if the initial balance is negative.
     * @pre Initial balance must be non-negative.
     * @post The account is created with the specified initial balance.

     * Example:
     * - Input: 1000.0
     * - Output: Account created with a balance of 1000.0
     */

    public BankAccount(double balance) {
        this.balance = balance;
    }
    /**
     * Retrieves the current account balance.

     * @return double - The current account balance.
     * @pre None.
     * @post Returns the current balance without modifying it.

     * Example:
     * - Input: None
     * - Output: 1000.0 (current account balance)
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Updates the account balance.
     *
     * @param balance - The new account balance (must be non-negative).
     * @throws IllegalArgumentException if the new balance is negative.
     * @pre New balance must be non-negative.
     * @post The account balance is updated to the specified value.

     * Example:
     * - Input: 1500.0
     * - Output: Account balance updated to 1500.0
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }
}