package view.store.centerPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import function.store.LookupTable;
import view.Delivery.DeliveryLeftButton;

public class StoreLookup extends JPanel{
	JButton LookupLeftButton;
	private static JTable lookupTable;
	public StoreLookup(String type) {
		if(type.equals("date")) {
			LookupLeftButton =  new DeliveryLeftButton("날짜별 매출 정보");
		}else if(type.equals("product")) {
			LookupLeftButton =  new DeliveryLeftButton("품목별 매출 정보");
		}else if(type.equals("member")) {
			LookupLeftButton =  new DeliveryLeftButton("회원별 매출 정보");
		}
		setBorder(BorderFactory.createEmptyBorder(50, 250, 50, 250));
		setPreferredSize(new Dimension(300, 500));
		setBackground(new Color(43, 51, 62));
		lookupTable = new LookupTable(type);
		LookupLeftButton.setSize(800, 50);
		LookupLeftButton.setLocation(65, 10);
		lookupTable.setSize(600, 400);
		
		JScrollPane scrollPane = new JScrollPane(lookupTable);
		add(LookupLeftButton);
		
		add(scrollPane);
		setVisible(true);
	}
}
