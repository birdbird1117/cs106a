
// TODO: comment this file

import java.io.*;
import java.util.*;

public class NameSurferDatabase implements NameSurferConstants {
	HashMap<String, String> nameDataBase = new HashMap<String, String>();

	// TODO: comment this constructor
	public NameSurferDatabase(String filename) {
		// TODO: fill this in
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine()) {
				String oneNameData = input.nextLine();
				String[] oneDataLineParts = oneNameData.split(" ");
				nameDataBase.put(oneDataLineParts[0], oneNameData);
			}
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error reading file: " + fnfe);
		}
	}

	// TODO: comment this method
	public NameSurferEntry findEntry(String name) {
		// TODO: implement this method
		String nameLowerCase = name.toLowerCase();
		String nameWithCapital = nameLowerCase.substring(0, 1).toUpperCase() + nameLowerCase.substring(1);
		String oneNameData = nameDataBase.get(nameWithCapital);
		NameSurferEntry oneNameSurferEntry = new NameSurferEntry(oneNameData);
		return oneNameSurferEntry; // remove this line
	}

	public static void main(String[] args) {
		NameSurferDatabase nameDataBase = new NameSurferDatabase("./res/names-data.txt");
		System.out.println(nameDataBase.findEntry("Sam").toString());
	}
}
