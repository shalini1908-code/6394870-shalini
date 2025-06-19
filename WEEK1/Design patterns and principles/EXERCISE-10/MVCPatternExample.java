import java.util.Scanner;

// Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    // Constructor
    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    // Constructor
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update view with model data
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }

    // Update model data
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }
}

// Main Class to test MVC Implementation with User Input
public class MVCPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect initial student details from user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        // Create model
        Student student = new Student(name, id, grade);

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display student details
        controller.updateView();

        // Update student details
        System.out.println("\nUpdate student details:");

        System.out.print("Enter new student name: ");
        name = scanner.nextLine();
        controller.setStudentName(name);

        System.out.print("Enter new student ID: ");
        id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        controller.setStudentId(id);

        System.out.print("Enter new student grade: ");
        grade = scanner.nextLine();
        controller.setStudentGrade(grade);

        // Display updated student details
        controller.updateView();

        scanner.close();
    }
}
