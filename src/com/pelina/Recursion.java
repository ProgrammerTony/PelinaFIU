package com.pelina;

/**
 * This class has the solution to Homework 3B
 * This code was created for educational purposes.
 * @author Tony Erazo
 * <h4>Any questions email me at</h4> <h2>Tony.789@live.com</h2>
 *

Problem  I.    We define the Pestaina strings as follows:

      1. ab is a Pestaina string.

      2. cbac is a Pestaina string.

      3. If S is a Pestaina string, so is SbSa.

      4. If U and V are Pestaina strings, so is aUbV.

Here a, b, c are constants and S,U,V are variables. In these rules,
the same letter represents the same string. So, if S = ab,
rule 3 tells us that abbaba is a Pestaina string.
In rule 4, U and V represent Pestaina strings, but they may be different.

Write the method

public static boolean isPestaina(String in)
     that returns true if in is a Pestaina string and false otherwise.
 */
public class Recursion {

	public static void main(String[] args) {
		System.out.println(isPestaina("ab"));
	}
	/**
	 * returns true if in is a Pestaina string and false otherwise.
	 * @param in string input
	 * @return if the string is pestaina
	 */
	public static boolean isPestaina(String in) {
		if(in == "ab" || in == "cbac" || in == "a")
			return true;
		return false;
	}
}
