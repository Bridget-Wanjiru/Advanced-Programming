package Lecture4_interfaces_abstract_classes;

public class InsufficientFundsException extends Exception {
    // Constructor to pass the error message
    public InsufficientFundsException(String message) {
        super(message);
    }
}
