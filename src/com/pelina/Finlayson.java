package com.pelina;

/**
 * This class has the solution to Homework 3B
 * This code was created for educational purposes.
 * @author Tony Erazo
 * <h4>Any questions email me at</h4> <h2>Tony.789@live.com</h2>
 *
 */
public class Finlayson {

	public static void main(String[] args) {
		System.out.println(finlayson(10));
	}
	
	/**
	 * (This professor needs to learn Java Conventions (lol) finlayson for the function name not Finlayson
	 * @param n the number
	 * @return if the value of finlayson
	 */
	public static long finlayson(int n) {
		//Recursion stopper (kills the recursive task or else it keeps on going forever)
		//you can use a switch statement if you want :D!
		if(n == 1)
			return 2;
		if(n == 0)
			return 1;
		if(n < 0) {
			throw new IllegalArgumentException("The number cannot be negative!");
		}
		//we can assume if(n >= 2) { all other use cases have been checked anything less than 2 is 1,0 and negative numbers.
		return  2 * finlayson(n-1) + 1;
	}
}
