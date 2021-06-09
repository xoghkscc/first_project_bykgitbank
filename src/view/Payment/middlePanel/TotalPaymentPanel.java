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


public class TotalPaymentPanel extends JPanel{
	private static JLabel total_payment;
	private static JLabel money_total_payment;
	public TotalPaymentPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(new Color(43, 51, 62), 1)));
		total_payment = new total_payment("0");
		money_total_payment = new total_payment("0");
		money_total_payment.setPreferredSize(new Dimension(650, 50));
		add(money_total_payment, BorderLayout.CENTER);
		
	}
	
	public static JLabel get_money_total_payment() {
		return money_total_payment;
	}
	
	public static JLabel get_total_payment() {
		return total_payment;
		
	}
}
