package view.Payment.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.payment.PaymentInsertTable;


public class BacodePanel extends JPanel{
	public BacodePanel(JTable top) {
		setBackground(new Color(43, 51, 62));
		setLayout(new GridLayout(2, 1, 30, 10));
		
		JTextField bacodeText = new EastJText2("물품번호 입력");
		bacodeText.addActionListener(new PaymentInsertTable((DefaultTableModel) top.getModel()));
		add(bacodeText);
		JLabel cntText = new Label2();
		add(bacodeText);
		add(cntText);
		
	}
}
