package Assignment_3;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int upperBound = 100_000;

		int[] randomNumbers = new int[100];
		double average = 0;

		for (int i = 0; i < 100; i++) {
			randomNumbers[i] = rand.nextInt(upperBound);
			average += randomNumbers[i];
		}
		average /= 100;

		int countGreaterThanAverage = 0;

		for (int i = 0; i < 100; i++) {
			if (randomNumbers[i] > average) {
				countGreaterThanAverage++;
			}
		}

		System.out.printf("The average is %.2f and there are %d numbers greater than average", average,
				countGreaterThanAverage);
	}

}
