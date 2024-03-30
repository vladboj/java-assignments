package Assignment_5_3;

import java.util.Scanner;

public class StudentMarksTrackerOOP {

	public static class StudentMarksTracker {
		private double[][] marks;
		private int numberOfStudents;
		private int numberOfMarksPerStudent;
		private double[] totalMark;

		public StudentMarksTracker(int numberOfStudents, int numberOfMarksPerStudent) {
			marks = new double[numberOfStudents][numberOfMarksPerStudent];
			this.numberOfStudents = numberOfStudents;
			this.numberOfMarksPerStudent = numberOfMarksPerStudent;
			totalMark = new double[numberOfStudents];
		}

		public void addMark(double mark, int studentPosition, int markPosition) {
			marks[studentPosition][markPosition] = mark;
			totalMark[studentPosition] += mark;
		}

		public double getAverageMarkOfStudent(int studentPosition) {
			return totalMark[studentPosition] / numberOfMarksPerStudent;
		}

		public double getAverageMarkForClass() {
			double totalMarkForClass = 0;
			for (int i = 0; i < numberOfStudents; i++) {
				totalMarkForClass += totalMark[i];
			}
			return totalMarkForClass / (numberOfStudents * numberOfMarksPerStudent);
		}
	}

	public static void main(String[] args) {

		// Get user inputs
		Scanner keyboard = new Scanner(System.in);

		int numberOfStudents;
		System.out.print("Enter number of students: ");
		numberOfStudents = keyboard.nextInt();

		int numberOfMarksPerStudent;
		System.out.print("Enter number of marks per student: ");
		numberOfMarksPerStudent = keyboard.nextInt();

		StudentMarksTracker smt = new StudentMarksTracker(numberOfStudents, numberOfMarksPerStudent);

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("Student %d\n", i + 1);
			for (int j = 0; j < numberOfMarksPerStudent; j++) {
				System.out.printf("Grade %d: ", j + 1);
				double mark = keyboard.nextDouble();
				smt.addMark(mark, i, j);
			}
		}
		
		keyboard.close();

		// Print results
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("The average mark of student %d is %.2f\n", i + 1, smt.getAverageMarkOfStudent(i));
		}

		System.out.printf("The average mark of the class is %.2f\n", smt.getAverageMarkForClass());
	}

}
