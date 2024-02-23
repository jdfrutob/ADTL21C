import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        clearTerminal();
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;
        boolean exit = false;

        System.out.println("Basic Calculator");

        while (!exit) {
            System.out.print("Enter 1st number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter 2nd number: ");
            num2 = scanner.nextDouble();
            clearTerminal();

           
            System.out.println("Select an operation to perform on the two numbers:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulo (%)");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            operator = scanner.next().charAt(0);

            switch (operator) {
                case '1':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case '2':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case '3':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '4':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Division by zero is not allowed.");
                    }
                    break;
                case '5':
                    result = num1 % num2;
                    System.out.println("Result: " + result);
                    break;
                case '6':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid operator. Please choose a valid option.");
                    break;
            }

            if (!exit) {
                System.out.print("Would you like to enter two new numbers? (yes/no): ");
                String choice = scanner.next().toLowerCase();
                if (!choice.equals("yes")) {
                    System.out.print("Are you sure you want to exit? (yes/no): ");
                    choice = scanner.next().toLowerCase();
                    if (choice.equals("yes")) {
                        exit = true;
                    }
                }
                if (!exit) {
                    clearTerminal();
                }
            }
        }

        scanner.close();
        System.out.println("Calculator exited. Thank you!");
    }

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
