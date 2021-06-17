package view.Delivery;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeliveryCenterPanel extends JPanel {
	JFrame jf2;
	public DeliveryCenterPanel(JFrame jf) {
		this.jf2 = jf;

		
		setLayout(new GridLayout(0, 2, 10, 10));
		setBackground(new Color(43, 51, 62));
		
		DeliveryRightPanel.getRightPanel();
		DeliveryRightPanel dp = DeliveryRightPanel.getRightPanel();
	
		
		JPanel DeliveryLeftPanel = new DeliveryLeftPanel();
		

		
		add(DeliveryLeftPanel);
		add(dp);
	}
}
