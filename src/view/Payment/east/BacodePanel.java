package view.Payment.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class BacodePanel extends JPanel{
	public BacodePanel(JTable top) {
		setBackground(new Color(43, 51, 62));
		setLayout(new GridLayout(2, 1, 30, 10));
		
		JTextField bacodeText = new EastJText2("물품번호 입력");
		add(bacodeText);
		JLabel cntText = new Label2();
		add(bacodeText);
		add(cntText);
		
	}
}
