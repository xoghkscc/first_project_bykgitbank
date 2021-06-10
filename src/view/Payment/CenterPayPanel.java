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

import function.payment.Products_Stocks_Modify;
import view.Payment.lowPanel.LowPanel;
import view.Payment.middlePanel.MiddlePanel;
import view.Payment.topPanel.TopTable;


public class CenterPayPanel extends JPanel{
	JFrame mainJf;
	private static JTable table;
	JPanel middle;
	public static JTable getTop() {
		return table;
	}
	public MiddlePanel getMiddle() {
		return (MiddlePanel) middle;
	}
	public CenterPayPanel(JFrame mainJf) {
		this.mainJf = mainJf;
		
		table = new TopTable();
		table.addMouseListener(new Products_Stocks_Modify());
		JScrollPane scrollPane = new JScrollPane(table);
		middle = new MiddlePanel(table);
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
