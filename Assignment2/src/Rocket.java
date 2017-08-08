/*
 * Write a (non-interactive) ConsoleProgram named Rocket that displays a specific text figure 
 * that looks like a rocket ship. You must exactly reproduce the format of the output at right, 
 * including identical characters and spacing. You must use nested for loops for lines that have 
 * repeated patterns of characters that vary in number from line to line, 
 * rather than using a single println statement that prints each line of the figure.
 */
import acm.program.*;

public class Rocket extends ConsoleProgram {
	private static final int SIZE = 5;

	public void run() {
		printHeadTail();
	}
	
	public void printHeadTail() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE-i-1; j++)
				print(" ");
			for (int j = 0; j < i+1; j++)
				print("/");	
			for (int j = 0; j < i+1; j++)
				print("\\");
			for (int j = 0; j < SIZE-i-1; j++)
				print(" ");
			println();
		}
	}
	
	
	
}
