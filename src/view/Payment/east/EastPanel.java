package view.Payment.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EastPanel extends JPanel{
	JFrame mainJf;
	public EastPanel(JFrame mainJf, JTable top, JLabel total_payment) {
		this.mainJf = mainJf;
		setBackground(new Color(43, 51, 62));
		setLayout(new GridLayout(3, 1, 30, 30));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 40));
		JPanel bacode = new BacodePanel(top, total_payment);
		
		JPanel memberPanel = new MemberPanel();
		bacode.setPreferredSize(new Dimension(10, 10));
		JPanel paymentPanle = new EastPayPanel();
		
		add(bacode);
		add(memberPanel);
		add(paymentPanle);
		
	}
	
}
