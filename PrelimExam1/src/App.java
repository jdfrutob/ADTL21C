import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        // Create a new Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a series of integers: ");
        int sum = 0;
        int count = 0;

        // Continue reading integers from the user until a non-integer is entered
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            sum += num;
            count++;
        }

        // Close the Scanner object
        scanner.close();

        // Calculate the average
        double average = (double) sum / count;
        
        // Print the average
        System.out.println("Average: " + average);

        // Print a message indicating that the program is exiting
        System.out.println("Exiting...");
    }
}