package Inheritance_Project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shitz.Erase();
        Employee employee[] = new Employee[1];
        employee[0] = new Employee();
        employee[0].setName("Mars");
        employee[0].setID("0002");
        employee[0].setSalary(5000.0);

        Manager manager[] = new Manager[1];
        manager[0] = new Manager();
        manager[0].setName("Earth");
        manager[0].setID("0001");
        manager[0].setSalary(10000.0);

        displayMenuAndInformation(employee[0], manager[0]);
    }

    // Method to display menu and information
    public static void displayMenuAndInformation(Employee employee, Manager manager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Employee Information");
        System.out.println("2. Manager Information");

        // Read user choice
        int choice = scanner.nextInt();

        // Use a switch-case to perform actions based on user choice
        switch (choice) {
            case 1:
                displayEmployeeInformation(employee);
                break;
            case 2:
                displayManagerInformation(manager);
                break;
            default:
                System.out.println("Invalid choice");
        }

        // Close the scanner when done
        scanner.close();
    }

    // Method to display Employee Information
    public static void displayEmployeeInformation(Employee employee) {
        System.out.println("Employee Information");
        System.out.println();
        System.out.println("Name: " + employee.getName());
        System.out.println("ID: " + employee.getID());
        System.out.println("Salary: " + employee.getSalary());
    }

    // Method to display Manager Information
    public static void displayManagerInformation(Manager manager) {
        System.out.println("Manager Information");
        System.out.println();
        System.out.println("Name: " + manager.getName());
        System.out.println("ID: " + manager.getID());
        System.out.println("Salary: " + manager.getSalary());
    }
}
