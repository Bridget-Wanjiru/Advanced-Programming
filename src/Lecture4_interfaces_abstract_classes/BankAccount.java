
package Lecture4_interfaces_abstract_classes;
/**
 * ADT Specification for BankAccount

 * Type of Data:
 * - Represents a bank account with a monetary balance
 * - Balance is stored as a double-precision floating-point number

 * Operations:
 * 1. Constructor:
 *    - Create a new bank account with an initial balance
 *    - Precondition: Initial balance must be non-negative
 *    - Postcondition: Account is created with specified initial balance

 * 2. getBalance():
 *    - Retrieves the current account balance
 *    - Precondition: None
 *    - Postcondition: Returns the current balance without modifying it

 * 3. setBalance():
 *    - Updates the account balance
 *    - Precondition: New balance must be non-negative
 *    - Postcondition: Account balance is set to the specified value

 * Additional Recommended Operations (not implemented):
 * 4. deposit(double amount):
 *    - Adds money to the account
 *    - Precondition: Deposit amount must be positive
 *    - Postcondition: Account balance increases by the deposited amount

 * 5. withdraw(double amount):
 *    - Removes money from the account
 *    - Precondition: Withdrawal amount must be positive and not exceed current balance
 *    - Postcondition: Account balance decreases by the withdrawn amount
 */
public class BankAccount {
    private double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}