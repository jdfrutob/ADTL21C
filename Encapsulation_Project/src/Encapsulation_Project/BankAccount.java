package Encapsulation_Project;

// This class represents a bank account
public class BankAccount {
    // Private instance variables
    private double balance; // Stores the balance of the account
    private String accountNumber; // Stores the account number
    private String accountHolderName; // Stores the name of the account holder

    // Constructor to initialize the BankAccount object
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getter for the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for the account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter for the balance
    public double getBalance() {
        return balance;
    }

    // Setter for the balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to display the account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }

}