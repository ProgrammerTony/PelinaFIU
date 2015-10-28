package com.pelina;

/**
 * This class has the solution to Homework 3B
 * This code was created for educational purposes.
 * @author Tony Erazo
 * <h4>Any questions email me at</h4> <h2>Tony.789@live.com</h2>
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Problem III. We define the balanced parentheses strings as follows:

1. {} is a balanced parentheses string

2. [] is a balanced parentheses string

3. () is a balanced parentheses string

4. If S is a balanced parentheses string, so is {S}

5. If S is a balanced parentheses string, so is [S]

6. If S is a balanced parentheses string, so is (S)

7. If S and T are  balanced parentheses strings, so is ST 

In rule 7, S and T can be the same string or different ones.
 *
 */
public class Parenthesis {

	
	public static void main(String[] args) {
		//System.out.println(isBalanced("{(x-3)}"));
	    String[] tests = {
	           // "()[]<>{}",
	           // "(<",
	           // "]}",
	            //"()<",
	            "(][)",
	            "{(X)[XY]}",
	        };
	        for (String s : tests) {
	            System.out.println(s + " = " + isBalanced(s));
	        }
	        
	        /**
	         * ()[]<>{} = true
(< = false
]} = false
()< = false
(][) = false
{(X)[XY]} = true
	         */
	}
	/**
	 * From what i read here it appears the we can create different sects of these
	 * ordered operations until we reach a specific rule and kill the recursive operation.
	 * @param in String input
	 * @return if the parenthesis are balanced
	 */
	public static boolean isBalanced(String in) {
		String open  = "([<{";
		String close = ")]>}";
		
		if(open.indexOf(in.charAt(0)) != -1) {
			
			if(open.indexOf(in.charAt(1)) != -1) {
				System.out.println(in.charAt(1) + "  "+close.charAt(open.indexOf(in.charAt(1))));
				System.out.println("index of: " + in.charAt(in.length()-2));
				boolean matching = (open.indexOf(in.charAt(1)) == close.indexOf(in.charAt(in.length()-2)));
				System.out.println("is matching: " + matching);
				if(!matching) {
					return false;
				}
				
				//System.out.println(in.substring(1, in.indexOf(close.charAt(open.indexOf(in.charAt(1)))) + 1));
				//String subfunction = in.substring(1, in.indexOf(close.charAt(open.indexOf(in.charAt(1)))) + 1);
				//return isBalanced(in.substring(1, in.indexOf(close.charAt(open.indexOf(in.charAt(1)))) + 1));
			}
			
			if(close.indexOf(in.charAt(in.length()-1)) != -1) {
				return (open.indexOf(in.charAt(0)) == close.indexOf(in.charAt(in.length()-1)));
			}
			
		}
		System.out.println(in.substring(1, in.indexOf(close.charAt(open.indexOf(in.charAt(1)))) + 1));
		return isBalanced(in.substring(1, in.indexOf(close.charAt(open.indexOf(in.charAt(1)))) + 1));
	}
}
