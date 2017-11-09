// TODO: comment this file

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	//private myCanvas canvas;
	public void init() {
	//	canvas = new MyCanvas();
	//	add(canvas);
	    JLabel nameLabel = new JLabel("Name: ");
		add(nameLabel, NORTH);
		JTextField nameField = new JTextField(TEXT_FIELD_WIDTH);
		add(nameField, NORTH);
		JButton graphButton = new JButton("Graph");
		add(graphButton, NORTH);
		JButton clearButton = new JButton("Clear");
		add(clearButton, NORTH);
		addActionListeners();
		nameField.addActionListener(this);
		nameField.setActionCommand("Graph");
		NameSurferGraph grids = new NameSurferGraph();
		add(grids);
	}

	public void actionPerformed(ActionEvent event) {
		println(event.getActionCommand());
		if(event.getActionCommand().equals("Graph"))
		println("graphButton");	
	}

}
