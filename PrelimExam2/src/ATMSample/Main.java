package ATMSample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an array of BankAccount objects
        BankAccount[] accounts = new BankAccount[1];
        accounts[0] = new BankAccount("2022-1-01377", "John Daniel Binegas", 10000.0);

        // Call the viewAccounts method
        viewAccounts(accounts);
        System.out.print("Withdrawal?");

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Read the withdrawal amount from the user
        double withdrawalAmount = scanner.nextDouble();

        // Withdraw the specified amount from the first account
        boolean withdrawalSuccess = accounts[0].withdraw(withdrawalAmount);

        // Check if the withdrawal was successful
        if (withdrawalSuccess) {
            // Print the updated balance
            System.out.println("Withdrawal successful");
            System.out.println("Updated Balance: " + accounts[0].getBalance());
        } else {
            System.out.println("Withdrawal failed, insufficient balance");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to display account details
    private static void viewAccounts(BankAccount[] accounts) {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Name: " + account.getName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println();
        }
    }
}

// BankAccount class
class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;

    // Constructor to initialize BankAccount object
    public BankAccount(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to get account holder name
    public String getName() {
        return name;
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw specified amount from account
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}