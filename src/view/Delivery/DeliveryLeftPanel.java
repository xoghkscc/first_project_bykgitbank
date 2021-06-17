package view.Delivery;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeliveryLeftPanel extends JPanel {
	public DeliveryLeftPanel (JFrame jf, JPanel center, JPanel DelivryRightPanel) {
	setBackground(new Color(43, 51, 62));
	setLocation(0, 0);
	setSize(635, 700);
	setLayout(null);
	
	JButton DeliveryLeftButton = new DeliveryLeftButton("주문 정보");
	JPanel DeliveryTable = new DeliveryLeftTable(jf, center, DelivryRightPanel);

	DeliveryLeftButton.setSize(500, 50);
	DeliveryLeftButton.setLocation(65, 50);
	
	DeliveryTable.setSize(500, 400);
	DeliveryTable.setLocation(65, 140);
	
	add(DeliveryLeftButton);
	add(DeliveryTable);
	}
}
