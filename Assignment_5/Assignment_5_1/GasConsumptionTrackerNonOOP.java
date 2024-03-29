package Assignment_5_1;

import java.util.Scanner;

public class GasConsumptionTrackerNonOOP {
	public static void main(String[] args) {

		// Get inputs
		Scanner keyboard = new Scanner(System.in);

		int numberOfDays;
		System.out.println("Enter Number of Days");
		numberOfDays = keyboard.nextInt();

		double[] gasConsumptionLiters = new double[numberOfDays];
		double[] gasPricePerLiter = new double[numberOfDays];
		
		for(int i = 0; i < numberOfDays; i++) {
			System.out.printf("Day %d\n", i + 1);
			
			System.out.print("Gas(liters): ");
			gasConsumptionLiters[i] = keyboard.nextDouble();

			System.out.print("Price($ per liter): ");
			gasPricePerLiter[i] = keyboard.nextDouble();
		}
		
		keyboard.close();
		
		// Compute total gas consumption
		double totalConsumption = 0;
		
		for(int i = 0; i < numberOfDays; i++) {
			totalConsumption += gasConsumptionLiters[i];
		}
		
		// Compute average gas consumption
		double averageConsumption = totalConsumption / numberOfDays;
		
		// Compute total gas cost
		double totalCost = 0;
		for(int i = 0; i < numberOfDays; i++) {
			totalCost += gasConsumptionLiters[i] * gasPricePerLiter[i];
		}
		
		// Compute average price per liter
		double averagePricePerLiter = 0;
		for(int i = 0; i < numberOfDays; i++) {
			averagePricePerLiter += gasPricePerLiter[i];
		}
		averagePricePerLiter /= numberOfDays;
		
		// Print results
		System.out.printf("Total gas consumption is %.2f liters.\n", totalConsumption);

		System.out.printf("Average gas consumption is %.2f liters.\n", averageConsumption);

		System.out.printf("Total gas cost is $%.2f.\n", totalCost);

		System.out.printf("Average gas price per liter is $%.2f.\n", averagePricePerLiter);
	}
}
