package Assignment_6;

import robocode.Robot;
import robocode.RoundEndedEvent;
import robocode.ScannedRobotEvent;

public class TheDestroyer extends Robot {
	private int numberOfSquaresTravelled = 0;
	private boolean clockwise = true;

	private boolean aggressive = false;
	private boolean scanForRobots = false;

	private int squareSize = 150;
	private int radarTurnDegrees = 30;

	public void run() {
		while (true) {
			moveInSquare(squareSize);
			numberOfSquaresTravelled++;
		}
	}

	public void moveInSquare(int lengthOfSide) {
		if(getEnergy() < 50) {
			aggressive = true;
		}
		
		System.out.printf("I am travelling %s.\n", clockwise ? "clockwise" : "counter-clockwise");
		for (int i = 0; i < 4; i++) {
			ahead(lengthOfSide);
			if (aggressive) {
				fire(1);
			}
			if (scanForRobots) {
				turnRadarRight(radarTurnDegrees);
				turnGunRight(radarTurnDegrees);
			}
			turnRight(clockwise ? 90 : -90);
		}
		if (aggressive) {
			fire(1);
		}
		if (scanForRobots) {
			turnRadarRight(radarTurnDegrees);
			turnGunRight(radarTurnDegrees);
		}
		turnRight(clockwise ? 90 : -90);
		clockwise = !clockwise;
		scanForRobots = !scanForRobots;
	}

	public void onRoundEnded(RoundEndedEvent event) {
		System.out.printf("Number of squares travelled is %d.\n", numberOfSquaresTravelled);
	}

	public void onScannedRobot(ScannedRobotEvent event) {
		System.out.printf("Detected robot: %s, Energy: %.2f, Distance: %.2f\n", event.getName(), event.getEnergy(),
				event.getDistance());
		
		fire(1);
	}
}
