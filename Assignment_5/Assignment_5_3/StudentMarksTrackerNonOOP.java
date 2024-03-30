package Assignment_5_3;

import java.util.Scanner;

public class StudentMarksTrackerNonOOP {

	public static void main(String[] args) {

		// Get user input
		Scanner keyboard = new Scanner(System.in);

		int numberOfStudents;
		System.out.print("Enter number of students: ");
		numberOfStudents = keyboard.nextInt();

		int numberOfMarksPerStudent;
		System.out.print("Enter number of marks per student: ");
		numberOfMarksPerStudent = keyboard.nextInt();

		double[][] marks = new double[numberOfStudents][numberOfMarksPerStudent];

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("Student %d\n", i + 1);
			for (int j = 0; j < numberOfMarksPerStudent; j++) {
				System.out.printf("Grade %d: ", j + 1);
				marks[i][j] = keyboard.nextDouble();
			}
		}

		keyboard.close();

		// Compute average mark for each student
		double[] averageMarks = new double[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++) {
			double averageMark = 0;
			for (int j = 0; j < numberOfMarksPerStudent; j++) {
				averageMark += marks[i][j];
			}
			averageMark /= numberOfMarksPerStudent;
			averageMarks[i] = averageMark;
		}

		// Compute average mark for the whole class
		double averageMarkForClass = 0;
		for (int i = 0; i < numberOfStudents; i++) {
			averageMarkForClass += averageMarks[i];
		}
		averageMarkForClass /= numberOfStudents;
		
		// Print results
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("The average mark of student %d is %.2f\n", i + 1, averageMarks[i]);
		}
		
		System.out.printf("The average mark of the class is %.2f\n", averageMarkForClass);
	}

}
