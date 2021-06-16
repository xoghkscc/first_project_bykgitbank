package view.Delivery;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class DeliveryCenterPanel extends JPanel {
	public DeliveryCenterPanel() {
		
		setLayout(new GridLayout(0, 2, 10, 10));
		setBackground(new Color(43, 51, 62));
		
		JPanel DeliveryLeftPanel = new DeliveryLeftPanel();
		JPanel DeliveryRightPanel = new DeliveryRightPanel();
		
		add(DeliveryLeftPanel);
		add(DeliveryRightPanel);
	}
}
