package Task5_StudentManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;
        boolean running = true;

        System.out.println("----- Student Management System -----");

        while (running) {

            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Roll Number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    students.add(new Student(name, rollNumber, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int removeRoll = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getRollNumber() == removeRoll) {
                            students.remove(i);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student student : students) {
                        if (student.getRollNumber() == searchRoll) {
                            student.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student student : students) {
                            student.displayStudent();
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
