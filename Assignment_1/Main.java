package classes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double taxableIncome;
		int filingStatus;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Taxable Income");
		taxableIncome = keyboard.nextDouble();
		
		System.out.println("Enter Filing Status");
		System.out.println("Single -> 0");
		System.out.println("Married Filing Jointly or Qualified Widow(er) -> 1");
		System.out.println("Married Filing Separately -> 2");
		System.out.println("Head of Household -> 3");
		filingStatus = keyboard.nextInt();
		
		keyboard.close();
	
		double tax = TaxCalculator.computeTax(taxableIncome, filingStatus);
        System.out.println("Tax for filing status " + filingStatus + " and taxable income $" + taxableIncome + " is: $" + tax);
	}

}
