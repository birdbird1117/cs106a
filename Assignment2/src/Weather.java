/*
 * Write an interactive ConsoleProgram named Weather that displays information about recent temperatures. 
 * The program should repeatedly prompt the user to enter temperatures until a particular "sentinel" value is entered. 
 * By default this sentinel value is -1.
 * 
 * This program should be written to use a class constant to represent the sentinel value -1, 
 * so that by changing only that constant's value and recompiling / running the program, 
 * it will now use the new sentinel value throughout the code and output.
 * 
 * If only one temperature is entered, that temperature is the maximum, minimum, and average.
 * 
 * 
 */

import acm.program.*;

public class Weather extends ConsoleProgram {
	private static final int sentinel = -42;
	
	public void run() {
		println("CS 106 \"Weather Master 4000\"");
		int highTemperature = 0;
		int lowTemperature = 0;
		double Average = 0;
		int numOfColdDays = 0;
		
		int temperature = readInt("Next temperature (or "+sentinel+" to quit)? ");
		if (temperature == sentinel)
			println("No temperatures were entered.");
		else {
			Average = temperature;
			highTemperature = temperature;
			lowTemperature = temperature;
			if(temperature <= 50)
				numOfColdDays++;
			
			temperature = readInt("Next temperature (or "+sentinel+" to quit)? ");
			while(temperature != sentinel){
				Average = (Average + temperature)/2;
				if(temperature > highTemperature)
					highTemperature = temperature;
				if(temperature < lowTemperature)
					lowTemperature = temperature;
				if(temperature <= 50)
					numOfColdDays++;
				temperature = readInt("Next temperature (or "+sentinel+" to quit)? ");
			}
				
			println("Highest temperature = "+highTemperature);
			println("Lowest temperature = "+lowTemperature);
			println("Average = "+ Average);
			println(numOfColdDays+" cold day(s).");
		}
	}
}
