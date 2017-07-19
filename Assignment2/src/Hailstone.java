/*
 * Pick some positive integer and call it n.
 * Do the following process until n is equal to one: 
 * If n is odd, multiply it by three and add one.
 * If n is even, divide it by two.
 */
import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		println("This program computes Hailstone sequences.");
		int counter = 0;
		int inputNumber = readInt("Enter a number:");
		inputNumber = singleHailstoneSequence(inputNumber);
		if (inputNumber != 1)
			counter++;
		while(inputNumber != 1) {
			counter++;
			inputNumber = singleHailstoneSequence(inputNumber); 
		}
		println("It took "+counter+" steps to reach 1");
		
		while (readBoolean("Run again? ", "y", "n")) {
			counter = 0;
			inputNumber = readInt("Enter a number:");
			inputNumber = singleHailstoneSequence(inputNumber);
			if (inputNumber != 1)
				counter++;
			while(inputNumber != 1) {
				counter++;
				inputNumber = singleHailstoneSequence(inputNumber); 
			}
			println("It took "+counter+" steps to reach 1");
		}
		println("Thanks for using Hailstone.");
	}
	
	public int singleHailstoneSequence(int number) {
		if (number == 1) {
			return 1;
		}
		
		if (number%2 == 0) {
			int temp = number/2;
			println(number+" is even, so I take half:"+ temp);
			return temp;
		} else {
			int temp = 3*number + 1;
			println(number+" is odd, so I make 3n + 1:"+temp);
			return temp;
		}	
	}
}
