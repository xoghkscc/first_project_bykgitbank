package view.Delivery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class DeliveryLeftButton extends DeliveryRoundedButton {
	public DeliveryLeftButton(String name) {
		super(name);
		super.c = new Color(51, 61, 71);
		setHorizontalAlignment(JLabel.CENTER);
		setLayout(new BorderLayout());
		setLayout(null);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}