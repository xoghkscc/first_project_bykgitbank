package view.Payment.middlePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class MiddlePanel extends JPanel{
	public MiddlePanel() {
		setBackground(new Color(236, 238, 236));
		setLayout(new BorderLayout());
		
		JPanel total_payment = new total_payment_panel();
		
		add(total_payment, BorderLayout.EAST);
		JLabel MiddleJLabel = new MiddleJLabel("합계");
//		MiddleJLabel.setBorder(new TitledBorder(new LineBorder(new Color(43, 51, 62), 1)));
		MiddleJLabel.setPreferredSize(new Dimension(230, 50));
		add(MiddleJLabel, BorderLayout.WEST);

	}
}

class total_payment_panel extends JPanel{
	public total_payment_panel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(new Color(43, 51, 62), 1)));
		JLabel total_payment = new total_payment("0");
		total_payment.setPreferredSize(new Dimension(650, 50));
		add(total_payment, BorderLayout.CENTER);
		
	}
}
