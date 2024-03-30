package Assignment_5_2;

import java.util.Scanner;

public class ScreenTimeTrackerOOP {
	public static class ScreenTimeTracker {
		private int[] screenTime;
		private int minScreenTime;
		private int minScreenTimeDay;
		private int maxScreenTime;
		private int maxScreenTimeDay;

		public ScreenTimeTracker() {
			screenTime = new int[21];
			minScreenTime = Integer.MAX_VALUE;
			minScreenTimeDay = -1;
			maxScreenTime = -1;
			maxScreenTimeDay = -1;
			
		}

		public void addScreenTime(int screenTime, int position) {
			this.screenTime[position] = screenTime;
			if (screenTime < minScreenTime) {
				minScreenTime = screenTime;
				minScreenTimeDay = position + 1;
			}
			if (screenTime > maxScreenTime) {
				maxScreenTime = screenTime;
				maxScreenTimeDay = position + 1;
			}
		}

		public int getScreenTime(int position) {
			return screenTime[position];
		}

		public int getMinScreenTime() {
			return minScreenTime;
		}
		
		public int getMinScreenTimeDay() {
			return minScreenTimeDay;
		}

		public int getMaxScreenTime() {
			return maxScreenTime;
		}
		
		public int getMaxScreenTimeDay() {
			return maxScreenTimeDay;
		}
	}

	public static void main(String[] args) {
		ScreenTimeTracker stt = new ScreenTimeTracker();

		Scanner keyboard = new Scanner(System.in);

		// Screen time in minutes
		int screenTime;
		// Get user input for his screen time for 21 days
		for (int i = 0; i < 21; i++) {
			System.out.printf("Enter your screen time for day %d: ", i + 1);
			screenTime = keyboard.nextInt();
			stt.addScreenTime(screenTime, i);
		}

		keyboard.close();

		// Print results
		System.out.printf("Minimum time spent in front of computer is %d, on day %d.\n", stt.getMinScreenTime(), stt.getMinScreenTimeDay());

		System.out.printf("Maximum time spent in front of computer is %d, on day %d.\n", stt.getMaxScreenTime(), stt.getMaxScreenTimeDay());
	}
}
