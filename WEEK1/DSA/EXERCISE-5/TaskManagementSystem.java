import java.util.Scanner;

// Task class representing a task with attributes
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", status=" + status + "]";
    }
}

// Node class for singly linked list
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// SinglyLinkedList class for managing tasks
class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added successfully.");
    }

    public Task searchTaskById(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null; // Task not found
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public void deleteTaskById(String taskId) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(taskId)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task deleted successfully.");
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList taskList = new SinglyLinkedList();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nTask Management System:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task details:");
                    System.out.print("Task ID: ");
                    String taskId = scanner.nextLine();
                    System.out.print("Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();

                    taskList.addTask(new Task(taskId, taskName, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = scanner.nextLine();
                    Task foundTask = taskList.searchTaskById(searchId);
                    System.out.println("Search Result: " + (foundTask != null ? foundTask : "Task not found"));
                    break;

                case 3:
                    System.out.println("Task List:");
                    taskList.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    String deleteId = scanner.nextLine();
                    taskList.deleteTaskById(deleteId);
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
