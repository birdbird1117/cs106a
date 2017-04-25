/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		fillOneLine();
		while(frontIsClear()) {
			upToNextLine();
			fillOneLine();
		}
			
	}

	public void moveOneStep() {
		if(noBeepersPresent())
			putBeeper();	
		if(frontIsClear()) {
			move();
		}		
		if(frontIsClear()) {
			move();
			putBeeper();
		}
		
	}
	
	public void fillOneLine() {
		if(facingEast())
			putBeeper();
		while(frontIsClear())
			moveOneStep();
		if(facingEast())
			turnLeft();
		if(facingWest())
			turnRight();
	}
	
	public void upToNextLine() {
		if(beepersPresent()) {
			if(rightIsBlocked()) {
				move();
				turnLeft();
			}	
			if(leftIsBlocked()) {
				move();
				turnRight();
			}
			if (frontIsClear())
				move();
		} else {
			if(rightIsBlocked()) {
				if(leftIsBlocked()){
					move();
					turnRight();	
				} else {
					move();
					turnLeft();
				}		
			}
				
			if(leftIsBlocked()) {
				move();
				turnRight();
			}
		}
		
	}	
	
}
