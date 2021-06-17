package view.store.centerPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import function.store.LookupTable_date;
import function.store.LookupTable_product;
import function.store.RightPane_date;
import function.store.RightPane_product;
import function.store.LookupRightTable_date;
import function.store.LookupTableClick;
import view.Delivery.DeliveryLeftButton;

public class StoreLookup extends JPanel{
	JButton LookupLeftButton;
	JButton LookupRightButton;
	private static JTable lookupTable;
	private static JPanel rightPanle_date;
	private static JPanel rightPanle_product;
	public StoreLookup(String type) {
		setLayout(new GridLayout(1, 2));
		setBackground(new Color(43, 51, 62));
		
		if(type.equals("date")) {
			lookupTable = new LookupTable_date();
			rightPanle_date = new RightPane_date();
			LookupLeftButton =  new DeliveryLeftButton("날짜별 매출 정보");
		}else if(type.equals("product")) {
			lookupTable = new LookupTable_product();
			rightPanle_product = new RightPane_product();
			LookupLeftButton =  new DeliveryLeftButton("품목별 매출 정보");
		}
		LookupLeftButton.setSize(800, 50);
		LookupLeftButton.setLocation(65, 10);
		
		JPanel leftPanle = new JPanel();
		
		leftPanle.setBackground(new Color(43, 51, 62));
		leftPanle.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
		
		lookupTable.addMouseListener(new LookupTableClick(type));
		
		lookupTable.setSize(600, 400);
		JScrollPane scrollPane = new JScrollPane(lookupTable);
		leftPanle.add(LookupLeftButton);
		leftPanle.add(scrollPane);
		
		add(leftPanle);
		if(type.equals("date")) {
			add(rightPanle_date);
		}else if(type.equals("product")) {
			add(rightPanle_product);
		}
		setVisible(true);
	}
	
	public static JTable getlookupTable() {
		return lookupTable;
	}
	public static JPanel getrightPanle_date() {
		return rightPanle_date;
	}
}
