package view.Payment.middlePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class MiddlePanel extends JPanel{
	JPanel total_payment;
	public MiddlePanel(JTable table) {
		setBackground(new Color(236, 238, 236));
		setLayout(new BorderLayout());
		
		total_payment = new total_payment_panel();
		
		add(total_payment, BorderLayout.EAST);
		JLabel MiddleJLabel = new MiddleJLabel("합계");
//		MiddleJLabel.setBorder(new TitledBorder(new LineBorder(new Color(43, 51, 62), 1)));
		MiddleJLabel.setPreferredSize(new Dimension(230, 50));
		add(MiddleJLabel, BorderLayout.WEST);
	}
	public JLabel get_total_payment() {
		return ((total_payment_panel)total_payment).get_total_payment();
	}
}

class total_payment_panel extends JPanel{
	JLabel total_payment;
	public total_payment_panel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(new Color(43, 51, 62), 1)));
		total_payment = new total_payment("0");
		total_payment.setPreferredSize(new Dimension(650, 50));
		add(total_payment, BorderLayout.CENTER);
		
	}
	
	public JLabel get_total_payment() {
		return total_payment;
		
	}
	
	
}
