import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("No space to add new employee.");
        }
    }

    public Employee searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Remove last element reference
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10); // Capacity of 10 employees

        boolean exit = false;

        while (!exit) {
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter employee details:");
                    System.out.print("Employee ID: ");
                    String employeeId = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    ems.addEmployee(new Employee(employeeId, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee foundEmployee = ems.searchEmployeeById(searchId);
                    System.out.println("Search Result: " + (foundEmployee != null ? foundEmployee : "Employee not found"));
                    break;

                case 3:
                    System.out.println("Employee List:");
                    ems.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ems.deleteEmployeeById(deleteId);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
