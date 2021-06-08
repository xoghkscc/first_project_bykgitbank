package view.Members;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mainpan extends JPanel {
	
	public Mainpan() {
		
		DefaultTableModel model = new DefaultTableModel(1,5);
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		
		setLocation(0,200);
		setSize(1280,600);
		add(pane);
		
	}
}
