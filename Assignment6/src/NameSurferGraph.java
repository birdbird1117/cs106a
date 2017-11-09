// TODO: comment this file

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	private double windowWidth;
	private double windowHeight;
	private double step;
	private ArrayList<NameSurferEntry> nameList;
	// TODO: comment this constructor
	public NameSurferGraph() {
		addComponentListener(this);
		// TODO: implement the rest of the constructor
		nameList  = new ArrayList<>();
		
	}
	
	// TODO: comment this method
	public void clear() {
		// TODO: implement this method
	}
	
	// TODO: comment this method
	public void addEntry(NameSurferEntry entry) {
		nameList.add(entry);
		drawOneEntry(entry);
	}
	
	private void drawOneEntry(NameSurferEntry entry) {
		String entryName = entry.getName();
		System.out.println(entryName);
		for(int i = 0; i<10; i++) {
			Integer entryRankPre = entry.getRank(i);
			Integer entryRankPost = entry.getRank(i+1);
			double entryRankPreY = (double)(entryRankPre)/1000*windowHeight;
			double entryRankPostY = (double)(entryRankPost)/1000*windowHeight;
			System.out.println(entryRankPreY );
			GLine aLine = new GLine(step*i, entryRankPreY, step*(i+1), entryRankPostY);
			add(aLine);
			GLabel aLabel = new GLabel(entryName+" "+entryRankPre.toString(), step*i, entryRankPreY);
			add(aLabel);
		}
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
		step = windowWidth/11;
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
