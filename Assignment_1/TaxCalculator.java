package classes;

public class TaxCalculator {
	private static double[] taxRates = { 0.1, 0.15, 0.25, 0.28, 0.33, 0.35 };
	private static int[][] taxBrackets = { { 8350, 33950, 82250, 171550, 372950, Integer.MAX_VALUE },
			{ 16700, 67900, 137050, 208850, 372950, Integer.MAX_VALUE },
			{ 8350, 33950, 68525, 104425, 186475, Integer.MAX_VALUE },
			{ 11950, 45500, 117450, 190200, 372950, Integer.MAX_VALUE } };

	public static double computeTax(double taxableIncome, int filingStatus) {
		double totalTax = 0;
		double remainingIncome = taxableIncome;
		
		for (int i = 0; i < taxBrackets[filingStatus].length && remainingIncome > 0; i++) {
			double bracketRate = taxRates[i];
			int bracketLimit = taxBrackets[filingStatus][i];

			if (taxableIncome >= bracketLimit) {
				totalTax += bracketRate * bracketLimit;
			}
			else {
				totalTax += bracketRate * remainingIncome;
				
			}
			remainingIncome -= bracketLimit;
		}
		return totalTax;
	}
}
