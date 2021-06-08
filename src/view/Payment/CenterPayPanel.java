package view.Payment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.Payment.lowPanel.LowPanel;
import view.Payment.middlePanel.MiddlePanel;
import view.Payment.topPanel.TopTable;


public class CenterPayPanel extends JPanel{
	JFrame mainJf;
	JTable table;
	public JTable getTop() {
		return table;
	}
	public CenterPayPanel(JFrame mainJf) {
		this.mainJf = mainJf;
		
		table = new TopTable();
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel middle = new MiddlePanel();
		JPanel low = new LowPanel();
		
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 0));
		setLayout(new BorderLayout());
		scrollPane.setPreferredSize(new Dimension(980, 380));//720-400 = 320
		low.setPreferredSize(new Dimension(980, 140));
		add(scrollPane, BorderLayout.NORTH);
		add(middle , BorderLayout.CENTER);
		add(low, BorderLayout.SOUTH);
		
	}
	
	
	

}
