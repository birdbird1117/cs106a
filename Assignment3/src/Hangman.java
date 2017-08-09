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
		intro();
	}
	
	// TODO: comment this method
	private void intro() {
		println("CS 106A Hangman! \nI will think of a random word.\nYou'll try to guess its letters.\nEvery time you guess a letter\nthat isn't in my word, a new body \npart of the hanging man appears.\nGuess correctly to avoid the gallows! \n");
		
	}
	
	// TODO: comment this method
	private int playOneGame(String secretWord) {
		// TODO: write this method
		return 0;
	}
	
	
	// TODO: comment this method
	private String createHint(String secretWord, String guessedLetters) {
		// TODO: write this method
		return "";
	}
	
	// TODO: comment this method
	private char readGuess(String guessedLetters) {
		// TODO: write this method
		return '?';
	}
	
	// TODO: comment this method
	private void displayHangman(int guessCount) {
		// TODO: write this method
	}
	
	// TODO: comment this method
	private void stats(int gamesCount, int gamesWon, int best) {
		// TODO: write this method
	}
	
	// TODO: comment this method
	private String getRandomWord(String filename) {
		// TODO: write this method
		return "";
	}
}
