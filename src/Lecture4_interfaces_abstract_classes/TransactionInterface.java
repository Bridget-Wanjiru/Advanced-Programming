package Lecture4_interfaces_abstract_classes;
import java.util.Calendar;

  /**
   * TransactionInterface
   * Description: Defines the blueprint for transaction-related operations in a banking system.
   * Classes implementing this interface must provide concrete implementations for retrieving
   * transaction details like amount, date, and unique identifiers.

   * Key Features:
   * - Ensures a consistent contract for all financial transaction types.
   * - Promotes abstraction and modularity by defining core transaction operations.
     * Core Operations:
     * - Retrieve transaction amount, date, and unique identifier.

   * @author Bridget Wanjiru

*/
public interface TransactionInterface {

    /**
     * Retrieves the monetary amount associated with the transaction.
     *
     * @return double - The transaction amount as a non-negative numeric value.
     * @pre None.
     * @post Returns the absolute value of the transaction. Does not modify the transaction state.

     * Example:
     * - Input: None
     * - Output: 500.0 (transaction amount in currency units)
     */
    double getAmount();

    /**
     * Retrieves the date of the transaction.

     * @return Calendar - A valid Calendar object representing the transaction date and time.
     * @pre None.
     * @post Returns a non-null Calendar instance. Does not modify the transaction state.

     * Example:
     * - Input: None
     * - Output: Calendar instance with the transaction timestamp.
     */
    Calendar getDate();

 /*
  * Retrieves a unique identifier for the transaction.
  *
  * @return String - A non-null, unique string identifier for the transaction.
  * @pre None.
  * @post Returns a consistent identifier that remains unique across the transaction's lifecycle.

  * Example:
  * - Input: None
  * - Output: "TX-1
   */
    String getTransactionID();

}