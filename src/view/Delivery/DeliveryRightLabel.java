package view.Delivery;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class DeliveryRightLabel extends JLabel {
	public DeliveryRightLabel(String name) {
		super(name);
		setOpaque(true);
		setLayout(null);
		setHorizontalAlignment(JLabel.CENTER);
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setSize(500, 50);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));


	}


}