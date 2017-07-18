/* 
 * Write an interactive ConsoleProgram named QuadraticEquation that finds real roots of a quadratic equation. 
 * 
 * You may assume that the user doesn't enter 0 as their value for a. 
 * Aside from the above restriction, the values of a, b, and c can be any integers. 
 * You should not do any rounding of real numbers in your output.
*/

import acm.program.*;

public class QuadraticEquation extends ConsoleProgram {
	public void run() {
		println("CS 106A Quadratic Solver!");
		int a = readInt("Enter a: ");
		int b = readInt("Enter b: ");
		int c = readInt("Enter c: ");
		
		double discriminant = b*b - 4*a*c;
		
		if (discriminant < 0)
			println("No real roots");
		else if (discriminant == 0)
			println("One root: " + -b/2/a);
		else 
			println("Two roots: " + (-b+Math.sqrt(discriminant))/2/a + " and " + (-b-Math.sqrt(discriminant))/2/a);
	}
}
