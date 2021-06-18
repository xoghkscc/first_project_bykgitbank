package function.store;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.Delivery.DeliveryLeftButton;

public class RightPane_product extends JPanel{
	JButton LookupLeftButton;
	JButton LookupRightButton;
	private static JTable lookupTable;
	private static JTable lookupRightTable;
	public RightPane_product() {
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 80));
		LookupRightButton =  new DeliveryLeftButton("폼목별  상세 매출 정보");
		LookupRightButton.setSize(800, 50);
		LookupRightButton.setLocation(65, 10);
		
		lookupRightTable = new LookupRightTable_product();
		JScrollPane scroll = new JScrollPane(lookupRightTable);
		add(LookupRightButton);
		add(scroll);
	}
	
	public static JTable getlookupRightTable() {
		return lookupRightTable;
	}

}
