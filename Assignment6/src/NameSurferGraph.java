
// TODO: comment this file

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas implements NameSurferConstants, ComponentListener {

	private double windowWidth;
	private double windowHeight;
	private double step;
	private ArrayList<NameSurferEntry> nameList;

	// TODO: comment this constructor
	public NameSurferGraph() {
		addComponentListener(this);
		// TODO: implement the rest of the constructor
		nameList = new ArrayList<>();

	}

	// TODO: comment this method
	public void clear() {
		// TODO: implement this method
		nameList.clear();
		update();
	}

	// TODO: comment this method
	public void addEntry(NameSurferEntry entry) {
		nameList.add(entry);
		drawOneEntry(entry);
	}

	private void drawOneEntry(NameSurferEntry entry) {
		String entryName = entry.getName();
		Color color = selectColor(nameList.indexOf(entry));
		System.out.println(entryName);
		for (int i = 0; i < 10; i++) {
			Integer entryRankPre = entry.getRank(i) - 1;
			Integer entryRankPost = entry.getRank(i + 1) - 1;
			if (entryRankPre == -1) {
				entryRankPre = 1000;
			}
			if (entryRankPost == -1) {
				entryRankPost = 1000;
			}
			double entryRankPreY = (double) (entryRankPre) / 1000 * (windowHeight - 2 * GRAPH_MARGIN_SIZE)
					+ GRAPH_MARGIN_SIZE;
			double entryRankPostY = (double) (entryRankPost) / 1000 * (windowHeight - 2 * GRAPH_MARGIN_SIZE)
					+ GRAPH_MARGIN_SIZE;
			System.out.println(entryRankPreY);
			GLine aLine = new GLine(step * i, entryRankPreY, step * (i + 1), entryRankPostY);
			aLine.setColor(color);
			add(aLine);
			if (entryRankPre != 1000) {
				entryRankPre++;
				GLabel aLabel = new GLabel(entryName + " " + entryRankPre.toString(), step * i, entryRankPreY);
				aLabel.setColor(color);
				add(aLabel);

			} else {
				GLabel aLabel = new GLabel(entryName + " " + "*", step * i, entryRankPreY);
				aLabel.setColor(color);
				add(aLabel);
			}
			if (i == 9) {
				if (entryRankPost != 1000) {
					entryRankPost++;
					GLabel aLabel = new GLabel(entryName + " " + entryRankPost.toString(), step * (i+1), entryRankPostY);
					aLabel.setColor(color);
					add(aLabel);
	
				} else {
					GLabel aLabel = new GLabel(entryName + " " + "*", step * (i+1), entryRankPostY);
					aLabel.setColor(color);
					add(aLabel);
				}
			}
		}
	}

	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color RED = new Color(255, 0, 0);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color MAGENTA = new Color(255, 0, 255);

	private Color selectColor(int i) {
		if (i % 4 == 0) {
			return BLACK;
		} else if (i % 4 == 1) {
			return RED;
		} else if (i % 4 == 2) {
			return BLUE;
		} else if (i % 4 == 3) {
			return MAGENTA;
		}
		return BLACK;
	}

	// TODO: comment this method
	// It seems like that when window pop up, it triggers componentResized()
	public void update() {
		// TODO: implement this method
		removeAll();
		initGrid();
		for (NameSurferEntry e : nameList) {
			drawOneEntry(e);
		}
	}

	private void initGrid() {
		windowWidth = getWidth();
		windowHeight = getHeight();
		step = windowWidth / 11;
		for (int i = 0; i < 11; i++) {
			GLine aGrid = new GLine(step * i, 0, step * i, windowHeight);
			add(aGrid);
			Integer decade = START_DECADE + i * 10;
			GLabel aLabel = new GLabel(decade.toString(), step * i, windowHeight - DECADE_LABEL_MARGIN_SIZE);
			add(aLabel);
			//System.out.println(i);
		}
		GLine upGrid = new GLine(0, GRAPH_MARGIN_SIZE, windowWidth, GRAPH_MARGIN_SIZE);
		add(upGrid);
		GLine downGrid = new GLine(0, windowHeight - GRAPH_MARGIN_SIZE, windowWidth, windowHeight - GRAPH_MARGIN_SIZE);
		add(downGrid);
	}

	/* Implementation of the ComponentListener interface for updating when the window is resized */
	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
		update();
	}

	public void componentShown(ComponentEvent e) {
	}
}
