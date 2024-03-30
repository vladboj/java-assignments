package Assignment_5_2;

import java.util.Scanner;

public class ScreenTimeTrackerNonOOP {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int[] screenTimes = new int[21];

		// Screen time in minutes
		int screenTime;
		// Get user input for his screen time for 21 days
		for (int i = 0; i < 21; i++) {
			System.out.printf("Enter your screen time for day %d: ", i + 1);
			screenTime = keyboard.nextInt();
			screenTimes[i] = screenTime;
		}

		int minScreenTime = screenTimes[0];
		int maxScreenTime = screenTimes[0];

		for (int i = 0; i < 21; i++) {
			if(screenTimes[i] < minScreenTime) {
				minScreenTime = screenTimes[i];
			}
			if(screenTimes[i] > maxScreenTime) {
				maxScreenTime = screenTimes[i];
			}
		}
		
		// Print results
		System.out.printf("Minimum time spent in front of computer is %d.\n", minScreenTime);

		System.out.printf("Maximum time spent in front of computer is %d.\n", maxScreenTime);
	}

}
