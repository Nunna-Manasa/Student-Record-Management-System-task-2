import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                s.display();
            }
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("What would you like to update?");
                System.out.println("1. Name");
                System.out.println("2. Marks");
                System.out.println("3. Both Name and Marks");
                System.out.print("Enter your choice: ");
                int updateChoice = sc.nextInt();
                sc.nextLine();

                switch (updateChoice) {
                    case 1 -> {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();
                        System.out.println("Name updated successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter new marks: ");
                        s.marks = sc.nextDouble();
                        System.out.println("Marks updated successfully.");
                    }
                    case 3 -> {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();

                        System.out.print("Enter new marks: ");
                        s.marks = sc.nextDouble();
                        System.out.println("Name and Marks updated successfully.");
                    }
                    default -> System.out.println("Invalid option.");
                }
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}