// TODO: comment this file

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	//private HashMap<String, Integer[]> nameData = new HashMap<>();
	private String name;
	private Integer[] nameRank = new Integer[11];
	// TODO: comment this constructor
	public NameSurferEntry(String dataLine) {
		String[] dataLineParts = dataLine.split(" ");
		name = dataLineParts[0];
		for(int i = 1; i <12; i++) {
			//System.out.println(dataLineParts[i]);
			nameRank[i-1] = Integer.valueOf(dataLineParts[i]);
		}
	}

	// TODO: comment this method
	public String getName() {
		// TODO: implement this method

		return name;	
	}

	// TODO: comment this method
	public int getRank(int decadesSince1900) {
		// TODO: implement this method

		return nameRank[decadesSince1900];	
	}

	// TODO: comment this method
	public String toString() {
		// TODO: implement this method

		return name+" "+Arrays.toString(nameRank);	// remove this line
	}

	public static void main(String[] args) {
		String test = "Sam 1 2 3 4 5 6 7 8 9 10 11";
		NameSurferEntry entryTest = new NameSurferEntry(test);
		System.out.println(entryTest.getName());
		System.out.println(entryTest.getRank(0));
		System.out.println(entryTest.toString());
	}
}

