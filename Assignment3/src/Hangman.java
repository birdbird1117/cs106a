/*
 * Hangman is a single-player game where the player has a finite number of guesses 
 * to try and guess all the letters that make up a secret word. After printing an 
 * introductory message explaining the game to the player, the computer selects a 
 * secret word at random. Then the player does a series of turns. In each turn, the 
 * player guesses a letter from A-Z. Incorrect guesses are displayed as an evolving 
 * picture of the player being hanged at a gallows. For each incorrect guess, a new 
 * part of a stick figure—first the head, then the body, then each arm, each leg, 
 * and finally each foot—is added until hanging is complete.
 * 
 */

import acm.program.*;
import acm.util.*;
import java.io.*;    // for File
import java.util.*;  // for Scanner

public class Hangman extends HangmanProgram {
	
	public void run() {
		int gamesCount = 0;
		int gamesWon = 0;
		int best = 8;
		String filename = "../res/oneword.txt";
		//String filename = promptUserForFile("Type a filename","../res/");
		boolean continuePlay = true;
		while (continuePlay) {
			int guessesLeft = playOneGame(getRandomWord(filename));
			gamesCount++;
			if (guessesLeft != 0) {
				gamesWon++;
				if(best < guessesLeft) {
					best = guessesLeft;
				}
			}
			continuePlay = readBoolean("prompt text", "Y", "N");
		}
		stats(gamesCount, gamesWon, best);
	}
	
	// In this method, you should print the following introductory text that appears at the start of the program. 
	// A blank line of output should appear after the text.
	private void intro() {
		println("CS 106A Hangman! \nI will think of a random word.\nYou'll try to guess its letters.\nEvery time you guess a letter\nthat isn't in my word, a new body \npart of the hanging man appears.\nGuess correctly to avoid the gallows! \n");
		
	}
	

	private int playOneGame(String secretWord) {
		String yourGuess = "";
		String str = secretWord;
		boolean notAllLetters = true;
		int guessesLeft = 8;
		displayHangman(guessesLeft);

		while(notAllLetters && (guessesLeft > 0)) {
			println("Secret word : " + createHint(secretWord, yourGuess));
			println("Your guesses: " + yourGuess);
			println("Guesses left: " + guessesLeft);
			char chr = readGuess(yourGuess);
			yourGuess = yourGuess + chr;
			notAllLetters = !str.equals(createHint(secretWord, yourGuess));
			if (secretWord.indexOf(chr) != -1) {
				println("Correct!");
			} else {
				println("Incorrect.");
				guessesLeft--;
			}
			displayHangman(guessesLeft);
			println();
		}
		if (guessesLeft == 0) {
			println("You lose! My word was "+secretWord+".");
		} else {
			println("You win! My word was "+secretWord+".");
		}
		canvas.clear();
		return guessesLeft;
	}
	
	
	// In this method, you should create and return a hint string. 
	// Your method should accept two parameters: the secret word that the user is trying to guess, 
	// and the set of letters that have already been guessed.
	private String createHint(String secretWord, String guessedLetters) {
		String str = "";
		for (int i = 0; i < secretWord.length(); i++) {
			char chr = secretWord.charAt(i);
			if (guessedLetters.indexOf(chr) == -1) {
				str = str + "-";
			} else {
				str = str + chr; 
			}				
		}
		return str;
	}
	
	// In this method, you should prompt the user to type a single letter to guess, 
	// and return the letter typed as an uppercase char. 
	// Your method should accept a string as a parameter representing all 
	// letters that have already been guessed; for example, if the user has guessed T, O, S, and X, 
	// you will be passed "TOSX". If the user has not guessed any letters yet, the string will be empty. 
	// You should re-prompt the user until they type a string that is a single letter from A-Z, case-insensitive, 
	// that has not been guessed before.
	private char readGuess(String guessedLetters) {
		boolean guessed = false;
		while(!guessed) {
			String str = readLine("Your guess? ");
			if (str.length() == 1) {
				char chr = str.charAt(0);			
				if (Character.isLetter(chr)) {
					chr = Character.toUpperCase(chr);
					if (guessedLetters.indexOf(chr) == -1) {
						if ((chr <= 'Z') && (chr >= 'A')) {
							guessed = true;
							return chr;
						}
					} else {
						println("You already guessed that letter.");
					}
				} else {
					println("Type a single letter from A-Z");
				}
			} else {
				println("Type a single letter from A-Z");
			}				
		}
		return '?';
	}
	
	// In this method you should print a drawing of the current Hangman state for the game based 
	// on the given number of guesses remaining. This amounts to reading and printing the contents 
	// of the file whose name corresponds to that number of guesses. For example, 
	// if the guess count is 3, your code should read and print the entire contents of the file res/display3.txt to the console. 
	// You may assume that the guess count is a legal value from 0-8 and that the given file exists in the res folder and can be read successfully.
	private void displayHangman(int guessCount) {
		String fileName = null;	
		switch(guessCount) {
		case 8: fileName = "../res/display8.txt";
		break;				
		case 7: fileName = "../res/display7.txt";
		break;				
		case 6: fileName = "../res/display6.txt";
		break;				
		case 5: fileName = "../res/display5.txt";
		break;				
		case 4: fileName = "../res/display4.txt";
		break;				
		case 3: fileName = "../res/display3.txt";
		break;				
		case 2: fileName = "../res/display2.txt";
		break;				
		case 1: fileName = "../res/display1.txt";
		break;			
		case 0: fileName = "../res/display0.txt";
		break;			
		}
		canvas.clear();
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNextLine()){
			String line = input.nextLine();
			canvas.println(line);
		}
		input.close();		
	}
	
	// In this method, you should print the final statistics that display after 
	// all games of Hangman have been played. You should print the total games played, 
	// number of games won, percentage of games won, and the game that required the fewest guesses to complete. 
	// (Of course, all of this information is passed to your method, 
	// so this method is fairly straightforward to write. 
	// The hard part is to keep track of the above statistics in other parts 
	// of your program so that you can pass proper values to stats later.) 
	// Your code should work for any number of games ≥ 1.
	private void stats(int gamesCount, int gamesWon, int best) {
		println("Overall statistics:");
		println("Games played: "+gamesCount);
		println("Games won:"+ gamesWon);
		println("Win percent: "+String.format("%.1f%%",(float)gamesWon*100/(float)gamesCount));
		println("Best game:"+best+" guess(es) remaining");
		println("Thanks for playing");
	}
	
	// In this method you should read the file with the given name, and randomly choose and return a word from it. 
	// For example, if the filename passed is "dict.txt", a provided dictionary file that contains 73 words, 
	// you should randomly choose one of those words and return it; each word should have equal probability of being chosen, (1/73 in this case).
	private String getRandomWord(String filename) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int lineNum = input.nextInt();
		int rand = (int)(Math.random() * lineNum + 1);
		String str = null;

		for(int i = 0; i < rand; i++) {
			str = input.next();
		}
	
		return str;
	}
}
