
// TODO: comment this file

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	//private myCanvas canvas;
	private NameSurferGraph graph;
	private JTextField nameField;
	private NameSurferDatabase nameDataBase;

	public void init() {
		//	canvas = new MyCanvas();
		//	add(canvas);
		JLabel nameLabel = new JLabel("Name: ");
		add(nameLabel, NORTH);
		nameField = new JTextField(TEXT_FIELD_WIDTH);
		add(nameField, NORTH);
		JButton graphButton = new JButton("Graph");
		add(graphButton, NORTH);
		JButton clearButton = new JButton("Clear");
		add(clearButton, NORTH);
		addActionListeners();
		nameField.addActionListener(this);
		nameField.setActionCommand("Graph");
		graph = new NameSurferGraph();
		add(graph);
		// it is so wired, here the path is ../ , not ./ like in the NameSurferDB main()
		nameDataBase = new NameSurferDatabase("../res/names-data.txt");

	}

	public void actionPerformed(ActionEvent event) {
		println(event.getActionCommand());
		if (event.getActionCommand().equals("Graph")) {
			println("graphButton");
			println(nameField.getText());
			if(nameDataBase.findEntry(nameField.getText()) != null) {
			NameSurferEntry entry = nameDataBase.findEntry(nameField.getText());
			println(entry.toString());
			graph.addEntry(entry);
			}
		} else if (event.getActionCommand().equals("Clear")) {
			graph.clear();
		}
	}

}
