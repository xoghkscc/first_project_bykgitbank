package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.model.Products_DB;
import function.topBar.*;
import view.Payment.*;
import view.Payment.east.*;

public class PaymentMainFrame extends JFrame{
	JFrame jf;
	JTextField text;
	JTable table;
	JPanel east;
	
	public PaymentMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(43, 51, 62));
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(new BorderLayout());
		
		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		topBar.setBackground(new Color(43, 51, 62));
		
		JPanel center = new CenterPayPanel(this);
		table = ((CenterPayPanel) center).getTop();
		JLabel total_payment =  ((CenterPayPanel) center).getMiddle().get_total_payment();//합계 숫자임
		//가지고 오기 왜케 힘들지..
		east = new EastPanel(this, table, total_payment);
		
		
		east.setPreferredSize(new Dimension(350, 720));
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
		
		}
	
	public JTable getTable() {
		return table;
	}
	
}
