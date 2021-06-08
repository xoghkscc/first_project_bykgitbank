package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.topBar.*;
import view.Payment.*;
import view.Payment.east.*;

public class PaymentMainFrame extends JFrame{
	JFrame jf;
	JTextField text;
	JTable top;
	public PaymentMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(43, 51, 62));
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(new BorderLayout());
		
		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		
		
		
		JPanel center = new CenterPayPanel(this);
		top = ((CenterPayPanel) center).getTop();
		JPanel east = new EastPanel(this, top);
		
		
		east.setPreferredSize(new Dimension(350, 720));
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
		
		}
	}
