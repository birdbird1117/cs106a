// TODO: comment this program

import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator
import java.awt.*;         // Color
import java.awt.event.*;   // MouseEvent

public class Breakout extends BreakoutProgram {

	public void setOneBrickLine(int RowNumber, int InitYLocation) {
		double InitXLocationLeft;
		double InitXLocationRight;
		
		if (NBRICK_COLUMNS % 2 == 0) {
			InitXLocationLeft = CANVAS_WIDTH/2-BRICK_SEP/2-BRICK_WIDTH;
			InitXLocationRight = CANVAS_WIDTH/2+BRICK_SEP/2;
			for (int i = 0; i < NBRICK_COLUMNS/2; i++) {
				GRect rect= new GRect(InitXLocationLeft-(BRICK_SEP+BRICK_WIDTH)*i, InitYLocation, BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
				rect.setColor(Color.RED);
				add(rect);
				rect= new GRect(InitXLocationRight+(BRICK_SEP+BRICK_WIDTH)*i, InitYLocation, BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
				rect.setColor(Color.RED);
				add(rect);
			}
		}
	}
	
//	public void setBricks() {
//		
//	}
	
	
	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");

		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
		// TODO: finish this program
		setOneBrickLine(1, 20);
	}
}
