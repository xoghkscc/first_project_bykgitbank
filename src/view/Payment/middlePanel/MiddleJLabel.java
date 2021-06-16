package view.Payment.middlePanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MiddleJLabel extends JLabel{
	public MiddleJLabel(String name) {
		super(name);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 40));
		setOpaque(true);
	}
}

class total_payment extends JLabel{
	public total_payment(String name) {
		super(name+" ");
		setFont(new Font("맑은 고딕", Font.BOLD, 70));
		
		setForeground(Color.yellow);
		setHorizontalAlignment(JLabel.RIGHT);
		setBackground(new Color(109, 107, 108));
		setOpaque(true);
	}
}
