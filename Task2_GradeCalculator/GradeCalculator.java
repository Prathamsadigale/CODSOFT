import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----- Student Grade Calculator -----");

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = sc.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects.");
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
                i--; // repeat same subject input
                continue;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
