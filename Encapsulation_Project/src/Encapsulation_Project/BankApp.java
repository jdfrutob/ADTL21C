package Encapsulation_Project;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        // Create an array of BankAccount objects
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("2022-1-01377", "John Daniel Binegas", 10000.0);
        accounts[1] = new BankAccount("2022-1-01130", "Marc Joshua Valdez", 20000.0);

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Administrator PIN for login
        int adminPIN = 12345;
        int maxTries = 3;
        int tries = 0;

        boolean loggedIn = false;

        // Loop for administrator login
        while (tries < maxTries && !loggedIn) {
            clearTerminal();
            System.out.print("Enter Administrator PIN (Attempts left: " + (maxTries - tries) + "): ");
            int providedPIN = scanner.nextInt();

            if (providedPIN == adminPIN) {
                loggedIn = true;
                System.out.println("Admin login successful!");
                System.out.println();
            } else {
                tries++;
                System.out.println("Admin login failed. Incorrect PIN.\n");
                if (tries < maxTries) {
                    System.out.println("Please try again.\n");
                } else {
                    System.out.println("Maximum login attempts reached. Exiting.\n");
                    System.exit(0);
                }
            }
        }

        boolean exit = false;

        // Main menu loop
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. View Accounts");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clearTerminal();
                    viewAccounts(accounts, scanner);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to view account information
    public static void viewAccounts(BankAccount[] accounts, Scanner scanner) {
        System.out.println("Accounts Information:");
        int accountIndex = 0;

        // Loop through the accounts array
        while (accountIndex < accounts.length && accounts[accountIndex] != null) {
            BankAccount account = accounts[accountIndex];

            // Display account information
            account.displayAccountInfo();
            System.out.println();

            System.out.print("Press \"/\" for the next account or \"0\" to exit to the main menu: ");
            String input = scanner.next();

            if (input.equals("/")) {
                accountIndex++;
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Invalid input. Please press \"/\" for the next account or \"0\" to exit.");
            }
        }
    }

    // Method to clear the terminal/console
    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

