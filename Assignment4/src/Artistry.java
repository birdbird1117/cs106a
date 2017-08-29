// TODO: comment this program

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.*; // Java graphical objects

public class Artistry extends GraphicsProgram {
	public void run() {
			GRect rect = new GRect(50, 50, 200, 250); 
			rect.setFilled(true); 
			rect.setColor(Color.RED);
			add(rect);
		}
}
