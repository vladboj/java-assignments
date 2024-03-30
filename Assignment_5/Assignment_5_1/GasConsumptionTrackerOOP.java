package Assignment_5_1;

import java.util.Scanner;

public class GasConsumptionTrackerOOP {

	public static class DailyConsumption {
		private double gasConsumptionLiters;
		private double gasPricePerLiter;

		public DailyConsumption(double gasConsumptionLiters, double gasPricePerLiter) {
			this.gasConsumptionLiters = gasConsumptionLiters;
			this.gasPricePerLiter = gasPricePerLiter;
		}

		public double getGasConsumptionLiters() {
			return gasConsumptionLiters;
		}

		public double getGasPricePerLiter() {
			return gasPricePerLiter;
		}
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int numberOfDays;
		System.out.print("Enter number of days: ");
		numberOfDays = keyboard.nextInt();

		DailyConsumption[] dailyConsumptions = new DailyConsumption[numberOfDays];

		for (int i = 0; i < numberOfDays; i++) {

			double gasConsumptionLiters;
			System.out.printf("Enter gas consumption in liters for day %d: ", i + 1);
			gasConsumptionLiters = keyboard.nextDouble();

			double gasPricePerLiter;
			System.out.printf("Enter gas price per liter for day %d: ", i + 1);
			gasPricePerLiter = keyboard.nextDouble();

			dailyConsumptions[i] = new DailyConsumption(gasConsumptionLiters, gasPricePerLiter);
		}

		keyboard.close();

		// Compute total consumption
		double totalConsumption = 0;
		for (int i = 0; i < numberOfDays; i++) {
			totalConsumption += dailyConsumptions[i].getGasConsumptionLiters();
		}

		// Compute average consumption
		double averageConsumption = totalConsumption / numberOfDays;

		// Compute total cost
		double totalCost = 0;
		for (int i = 0; i < numberOfDays; i++) {
			totalCost += dailyConsumptions[i].getGasConsumptionLiters() * dailyConsumptions[i].getGasPricePerLiter();
		}

		// Compute average gas price per liter
		double averagePrice = 0;
		for (int i = 0; i < numberOfDays; i++) {
			averagePrice += dailyConsumptions[i].getGasPricePerLiter();
		}
		averagePrice /= numberOfDays;

		// Print results
		System.out.printf("Total gas consumption is %.2f liters.\n", totalConsumption);

		System.out.printf("Average gas consumption is %.2f liters.\n", averageConsumption);

		System.out.printf("Total gas cost is $%.2f.\n", totalCost);

		System.out.printf("Average gas price per liter is $%.2f.\n", averagePrice);
	}
}
