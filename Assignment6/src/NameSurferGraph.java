// TODO: comment this file

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	// TODO: comment this constructor
	public NameSurferGraph() {
		addComponentListener(this);
		// TODO: implement the rest of the constructor
	}
	
	// TODO: comment this method
	public void clear() {
		// TODO: implement this method
	}
	
	// TODO: comment this method
	public void addEntry(NameSurferEntry entry) {
		// TODO: implement this method
	}
	
	// TODO: comment this method
	public void update() {
		// TODO: implement this method
	}
	
	
	/* Implementation of the ComponentListener interface for updating when the window is resized */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
