// TODO: comment this file

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	private double windowWidth;
	private double windowHeight;
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
	// It seems like that when window pop up, it triggers componentResized()
	public void update() {
		// TODO: implement this method
		removeAll();
		initGrid();
	}

	private void initGrid() {
		windowWidth = getWidth();
		windowHeight = getHeight();
		double step = windowWidth/11;
		for(int i = 0; i<11; i++) {
			GLine aGrid = new GLine(step*i, 0, step*i, windowHeight);
			add(aGrid);
			Integer decade = START_DECADE + i*10;
			GLabel aLabel = new GLabel(decade.toString(), step*i, windowHeight-DECADE_LABEL_MARGIN_SIZE);
			add(aLabel);
			//System.out.println(i);
		}
		GLine upGrid = new GLine(0, GRAPH_MARGIN_SIZE, windowWidth, GRAPH_MARGIN_SIZE);
		add(upGrid);
		GLine downGrid = new GLine(0, windowHeight-GRAPH_MARGIN_SIZE, windowWidth, windowHeight-GRAPH_MARGIN_SIZE);
		add(downGrid);
	}
	
	
	/* Implementation of the ComponentListener interface for updating when the window is resized */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
