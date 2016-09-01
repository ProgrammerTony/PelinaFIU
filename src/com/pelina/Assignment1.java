package com.assignment;

/**
 * Assignment 1
 * I hereby certify that this collective work is my own and none of it is the work of any other person or entity.
 * @author Tony Erazo
 *
 */
public class Assignment1 {

	/**
	 * Significant figure constant use to stop the calculation of PI
	 */
	private static final int SIGNIFICANT_FIGURE = 12;
	/**
	 * Entry point of the application
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Approximated Value of PI: " + getPi() + "\n" + " Actual Value of PI from Math.PI: " + Math.PI);
	}
	
	/**
	 * Calculates the value of PI using alternating and harmonic series
	 * {@link https://en.wikipedia.org/wiki/Alternating_series}
	 * @return PI
	 */
	public static double getPi() {

		double pi = 0;
		int alternatingExponent = 1;
		int n = 1;
		int counter = 0;
		

		double alternatingSeries = Math.pow(-1, alternatingExponent-1) * (double)1/n;

		do {
			
			alternatingSeries = Math.pow(-1, alternatingExponent-1) * (double)1/n;
			pi += alternatingSeries;

			alternatingExponent++;
			n+=2;

			System.out.println("num: " + (pi*4) );
			counter++;

		} while(getSignificantFigures(pi*4) != SIGNIFICANT_FIGURE);
			System.out.println("This has looped: " + counter + " times.");
			//System.out.println(formatSignificantFigures(Double.toString(pi*4), 6));
			//The experssion is set as pi/4 = formula so we must multiply by 4 to isolate PI
		return pi*4;
	}
	
	/**
	 * Formats the number to the specified amount of significant figures
	 * @param number input number
	 * @param significantFigures specified significant figures cut out to fromt he decimal place only
	 * @return
	 */
	/*public static double formatSignificantFigures(String number, int significantFigures) {
		System.out.println(number);
		String regularNumbers = number.split("\\.")[0];
		String decimalNumbers = number.split("\\.")[1];
		String formattedDecimals = "";
		formattedDecimals += decimalNumbers.substring(0, significantFigures);
		double formattedNumber = Double.parseDouble(regularNumbers + "." + formattedDecimals);
		return formattedNumber;
	}*/
	
	/**
	 * Gets the total amount of significant figures
	 * @param number input number
	 * @return significantfigures
	 */
	public static int getSignificantFigures(double number) {
		String num = Double.toString(number);
		int significantFigures = 0;
		
		String regularNumbers = num.split("\\.")[0];
		int countableZeros = 0;
		for (int i = 0; i < regularNumbers.length(); i++) {

			if(i < regularNumbers.length()) {
				if(regularNumbers.charAt(i) != '0') {
					significantFigures += countableZeros;
					significantFigures++;
					countableZeros = 0;
				}
				else {
					countableZeros++;	
				}
			}

		}
		
		// we use the \\ to escape the special character of . in the Regex class and treat as a character from a string
		String decimalNumbers = num.split("\\.")[1];

		significantFigures += getDecimalSignificantFigures(decimalNumbers);
		return significantFigures;
	}
	
	/**
	 * Gets the amount of significant figures past the decimal point using the rules.
	 * @param decimalNumbers the number containing decimals withouth the decimal point
	 * @return significant figures
	 */
	private static int getDecimalSignificantFigures(String decimalNumbers) {
		boolean foundPositiveNumber = false;
		int significantFigures = 0;
		char lastCharacter = ' ';

		for (int i = 0; i < decimalNumbers.length(); i++) {
			
			int currentNumber = Integer.parseInt(Character.toString(decimalNumbers.charAt(i)));
			
			if(currentNumber > 0 && !foundPositiveNumber) {
				foundPositiveNumber = currentNumber > 0 ? true : false;	
				
				if(foundPositiveNumber) {
					if(i > 0) {
						lastCharacter = decimalNumbers.charAt(i-1);	
					}
					else {
						lastCharacter = decimalNumbers.charAt(i);
					}

				}
			}
		}
		
		if(foundPositiveNumber) {

			if(decimalNumbers.indexOf(lastCharacter) == 0)  {
				significantFigures += decimalNumbers.length();
			}
			else {
				significantFigures += decimalNumbers.split(Character.toString(lastCharacter))[1].length();
			}
		}
		return significantFigures;
	}
}
